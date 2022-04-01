package services;

import model.customer.Person;
import persistence.PersonDao;
import persistence.commons.DaoFactory;

public class PersonService {

	public Person create(Integer id, String firstName, String lastName, String dni) {

		Person person = new Person(id, firstName, lastName, dni);

		if (person.isValid()) {
			PersonDao personDao = DaoFactory.getPersonDao();

			personDao.insert(person);
		}
		return person;

	}

	public void delete(Integer id) {

		PersonDao personDao = DaoFactory.getPersonDao();

		personDao.delete(id);

	}

	public Person update(Integer id, String firstName, String lastName, String dni) {

		PersonDao personDao = DaoFactory.getPersonDao();

		Person person = personDao.findById(id);

		if (person.isValid()) {
			person.setFirstName(firstName);
			person.setLastName(lastName);
			person.setDni(dni);

			personDao.update(person);
		}

		return person;

	}

	public Person find(Integer id) {
		PersonDao personDao = DaoFactory.getPersonDao();
		Person person = personDao.findById(id);
		return person;
	}

}
