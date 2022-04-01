package controller.company;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CompanyService;

@WebServlet("/deleteCompany")
public class DeleteCompanyServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 5393399563799676231L;
	private CompanyService companyService;

	public void init() throws ServletException {
		super.init();
		this.companyService = new CompanyService();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		companyService.delete(id);

		resp.sendRedirect("/customers");

	}

}
