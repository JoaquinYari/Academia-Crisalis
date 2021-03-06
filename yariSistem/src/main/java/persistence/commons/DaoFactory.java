package persistence.commons;

import persistence.CompanyDao;
import persistence.PersonDao;
import persistence.ProductDao;
import persistence.ServiceDao;
import persistence.impl.CompanyDaoImpl;
import persistence.impl.PersonDaoImpl;
import persistence.impl.ProductDaoImpl;
import persistence.impl.ServiceDaoImpl;

public class DaoFactory {
	
	public static PersonDao getPersonDao() {
		return new PersonDaoImpl();
	}
	
	public static CompanyDao getCompanyDao() {
		return new CompanyDaoImpl();
	}
	
	public static ProductDao getProductDao() {
		return new ProductDaoImpl();
	}
	
	public static ServiceDao getServiceDao() {
		return new ServiceDaoImpl();
	}
	
}
