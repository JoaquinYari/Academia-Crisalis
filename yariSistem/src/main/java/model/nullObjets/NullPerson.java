package model.nullObjets;

import model.customer.Person;

public class NullPerson extends Person {
	
	public static Person build() {
		return new NullPerson();
	}
	
	public NullPerson() {
		super(0,"", "", "");
	}
	
	public boolean isNull() {
		return true;
	}

}
