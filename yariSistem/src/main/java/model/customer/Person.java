package model.customer;

import java.util.HashMap;

public class Person extends Customer {

	protected String lastName;
	protected String firstName;
	protected String dni;
	protected HashMap<String, String> errors;

	public Person(Integer id, String apellido, String nombre, String dni) {
		super(id);
		this.lastName = apellido;
		this.firstName = nombre;
		this.dni = dni;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [apellido=" + lastName + ", nombre=" + firstName + ", dni=" + dni + "]";
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();
		
		if (dni.length() != 8) {
			errors.put("dni", "invalid dni");
		}
		
	}

}
