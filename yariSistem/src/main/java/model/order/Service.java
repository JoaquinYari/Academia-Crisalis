package model.order;

public class Service extends Item {

	private Boolean special;
	private Double supportCost;

	private Double SUPPORTCOST = 0.15;

	public Service(Integer id, String name, Double baseCost, Double iva, Double iibb, Boolean special) {
		super(id, name, baseCost, iva, iibb);
		this.special = special;
	}

	@Override
	public Double getFinalCost() {
		getTaxes();

		if (special)
			supportCost = cargoSoporte();
		else
			supportCost = 0.0;

		finalCost = baseCost + taxes + supportCost;
		return finalCost;
	}

	private Double cargoSoporte() {
		supportCost = baseCost * SUPPORTCOST;
		return supportCost;
	}

	public Boolean getSpecial() {
		return special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}

}
