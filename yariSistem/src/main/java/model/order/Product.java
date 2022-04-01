package model.order;

import java.util.HashMap;

public class Product extends Item {

	private Integer yearsWarranty;
	private Double WARRANTY = 0.02;
	private HashMap<String,String> errors;

	public Product(Integer id, String name, Double baseCost, Double iva, Double iibb) {
		super(id, name, baseCost, iva, iibb);
	}
	
	public Product(Integer id, String name, Double baseCost, Double iva, Double iibb, Integer yearsWarranty) {
		super(id, name, baseCost, iva, iibb);
		this.yearsWarranty = yearsWarranty;
	}

	public Double warrantyCost() {
		return getFinalCost() * yearsWarranty * WARRANTY;
	}

	@Override
	public Double getFinalCost() {
		getTaxes();

		finalCost = baseCost + taxes;

		return finalCost;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	private void validate() {
		errors = new HashMap<String, String>();
		
		if (baseCost <= 0) {
			errors.put("baseCost", "invalid base cost");
		}
		if (iva < 0) {
			errors.put("iva", "invalid iva");
		}
		if (iibb < 0) {
			errors.put("iibb", "invalid iibb");
		}
		
	}

}
