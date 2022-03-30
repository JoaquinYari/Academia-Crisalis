package persistence;

import model.customer.Company;
import persistence.commons.GenericDao;

public interface CompanyDao extends GenericDao<Company> {
	
	Company finByBusinessName(String name);

}
