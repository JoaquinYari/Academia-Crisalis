package model.customer;

import java.util.Date;

public class Company extends Customer {
	
	private String companyName;
	private Integer cuit;
	private Date startActivity;
	private Person responsable;
	
	public Company(Integer id, String businessName, Integer cuit, Date startActivity, String lastName, String firstName, Integer dni) {
		super(id);
		this.companyName = businessName;
		this.cuit = cuit;
		this.startActivity = startActivity;
		responsable = new Person(id ,lastName, firstName, dni);
	}

	public String getBusinessName() {
		return companyName;
	}

	public void setBusinessName(String businessName) {
		this.companyName = businessName;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public Date getStartActivity() {
		return startActivity;
	}

	public void setStartActivity(Date startActivity) {
		this.startActivity = startActivity;
	}

	public Person getResponsable() {
		return responsable;
	}

	public void setResponsable(Person responsable) {
		this.responsable = responsable;
	}
	
	
	
	
}
