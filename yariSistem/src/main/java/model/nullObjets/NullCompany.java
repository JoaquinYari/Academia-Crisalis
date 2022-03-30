package model.nullObjets;

import model.customer.Company;

public class NullCompany extends Company {
	
	public static Company build() {
		return new NullCompany();
	}
	
	public NullCompany() {
		super(0,"", 0, null, "", "", 0);
	}
	
	public boolean isNull() {
		return true;
	}

}
