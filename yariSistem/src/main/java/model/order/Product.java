package model.order;

public class Product extends Item {

	private Integer yearsWarranty;
	private Double WARRANTY = 0.02;

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

}
