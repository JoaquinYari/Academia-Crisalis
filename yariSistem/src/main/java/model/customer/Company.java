package model.customer;

public class Company extends Customer {
	
	private String companyName;
	private String cuit;
	private String startActivity;
	private Person responsable;
	
	public Company(Integer id, String businessName, String cuit, String startActivity, String lastName, String firstName, String dni) {
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

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getStartActivity() {
		return startActivity;
	}

	public void setStartActivity(String startActivity) {
		this.startActivity = startActivity;
	}

	public Person getResponsable() {
		return responsable;
	}

	public void setResponsable(Person responsable) {
		this.responsable = responsable;
	}
	
	
	
	
}
