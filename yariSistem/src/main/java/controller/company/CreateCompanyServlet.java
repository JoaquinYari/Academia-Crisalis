package controller.company;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.customer.Company;
import services.CompanyService;

@WebServlet("/createCompany")
public class CreateCompanyServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1926384893825062696L;

	private CompanyService companyService;

	public void init() throws ServletException {
		super.init();
		this.companyService = new CompanyService();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Company company = companyService.find(id);
		req.setAttribute("company", company);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/customers/createCompany.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		Integer id = Integer.parseInt(req.getParameter("customerID"));
		String companyName = req.getParameter("companyName");
		String cuit = req.getParameter("cuit");
		String startActivity = req.getParameter("startActivity");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String dni = req.getParameter("dni");

		Company company = companyService.create(id, companyName, cuit, startActivity, firstName, lastName, dni);

		if (company.isValid()) {
			resp.sendRedirect("/newOrder.jsp");
		} else {
			req.setAttribute("company", company);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/customer/createCompany.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
