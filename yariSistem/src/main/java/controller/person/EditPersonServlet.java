package controller.person;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.customer.Person;
import services.PersonService;


@WebServlet("/editPerson")
public class EditPersonServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -4942391200331348336L;
	private PersonService personService;

	@Override
	public void init() throws ServletException {
		super.init();
		personService = new PersonService();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Person person = personService.find(id);
		req.setAttribute("person", person);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/customers/create.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("customerID"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String dni = (req.getParameter("dni"));

		Person person = personService.update(id, firstName, lastName, dni);

		if (person.isValid()) {
			resp.sendRedirect("/listCustomers.jsp");

		} else {
			req.setAttribute("person", person);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/customer/editPerson.jsp");
			dispatcher.forward(req, resp);
		}

	}
}
