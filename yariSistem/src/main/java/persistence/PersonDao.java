package persistence;

import model.customer.Person;
import persistence.commons.GenericDao;

public interface PersonDao extends GenericDao<Person> {
	
	public abstract Person findByName(String firstName, String lastName);

}
