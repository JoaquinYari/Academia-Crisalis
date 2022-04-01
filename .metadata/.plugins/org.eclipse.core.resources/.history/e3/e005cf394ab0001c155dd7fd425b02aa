package controller.customer;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.customer.Company;
import model.customer.Person;
import services.CustomerService;


@WebServlet("/crearUsuario")
public class CreateCustomerServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 5278887740341288569L;
	
	private CustomerService customerService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		customerService = new CustomerService();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("customerID"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String dni = req.getParameter("dni");
		
		if (req.getParameter("companyName") != null) {
			String companyName = req.getParameter("companyName");
			String cuit = req.getParameter("cuit");
			String startActivity = req.getParameter("startActivity");
			
			Company company = customerService.create(id, companyName, cuit, startActivity, firstName, lastName, dni);
		
			// TODO definir a donde redirige
		} else {
			Person person = customerService.create(id, firstName, lastName, dni);
			
			// TODO definir a donde redirige
		}
		
		
	}
	
	

}
