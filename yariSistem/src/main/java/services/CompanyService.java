package services;

import model.customer.Company;
import persistence.CompanyDao;
import persistence.commons.DaoFactory;

public class CompanyService {
	
	public Company create(Integer id, String companyName, String cuit, String startActivity, String firstName,
			String lastName, String dni) {
		
		Company company = new Company (id, companyName, cuit, startActivity, firstName, lastName, dni);
		
		CompanyDao companyDao = DaoFactory.getCompanyDao();
		
		companyDao.insert(company);
		
		return company;
		
	}
	
	public void delete(Integer id) {
		
		CompanyDao companyDao = DaoFactory.getCompanyDao();
		
		companyDao.delete(id);
	}
	
	public Company update(Integer id, String companyName, String cuit, String startActivity, String firstName, String lastName, String dni) {

		CompanyDao companyDao = DaoFactory.getCompanyDao();

		Company company = companyDao.findById(id);

		if (company.isValid()) {
			company.setCompanyName(companyName);
			company.setCuit(cuit);
			company.setStartActivity(startActivity);
			company.getResponsable().setFirstName(firstName);
			company.getResponsable().setLastName(lastName);
			company.getResponsable().setDni(dni);

			companyDao.update(company);
		}

		return company;

	}

	public Company find(Integer id) {
		CompanyDao companyDao = DaoFactory.getCompanyDao();
		Company company = companyDao.findById(id);
		return company;
	}

}
