package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.customer.Person;
import model.nullObjets.NullPerson;
import persistence.PersonDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class PersonDaoImpl implements PersonDao {

	@Override
	public Integer insert(Person person) {
		try {
			String sql = "INSERT INTO Persons (firsName, lastName, dni)" + "VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setString(3, person.getDni());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer update(Person person) {
		try {
			String sql = "UPDATE Persons (firsName, lastName) VALUES (?, ?, ?) WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setString(3, person.getDni());
			statement.setInt(4, person.getId());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer delete(Integer id) {
		try {
			String sql = "DELETE FROM Persons WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Person findByName(String firstName, String lastName) {
		try {
			String sql = "SELECT * FROM Persons WHERE firstName = ? AND lastName = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);

			ResultSet result = statement.executeQuery();

			Person person = NullPerson.build();

			if (result.next()) {
				person = toPerson(result);
			}

			return person;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Person findById(Integer id) {
		try {
			String sql = "SELECT * FROM Persons WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			Person person = NullPerson.build();

			if (result.next()) {
				person = toPerson(result);
			}

			return person;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Person> findAll() {
		try {
			String sql = "SELECT * FROM Persons";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			List<Person> persons = new LinkedList<Person>();

			while (result.next()) {
				persons.add(toPerson(result));
			}

			return persons;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Person toPerson(ResultSet result) {
		try {
			return new Person(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
