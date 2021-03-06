package controller.person;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PersonService;


@WebServlet("/deletePerson")
public class DeletePersonServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 14679988699112680L;
	
	private PersonService personService;
	
	public void init() throws ServletException {
		super.init();
		this.personService = new PersonService();
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		personService.delete(id);
		
		resp.sendRedirect("/customers");
		
		
	}

}
