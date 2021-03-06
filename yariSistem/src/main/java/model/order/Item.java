package model.order;

public abstract class Item {

	protected Integer id;
	protected String name;
	protected Double baseCost;
	protected Double taxes;
	protected Double finalCost;
	protected Integer quantity;

	protected Double iva;
	protected Double iibb;

	public Item(Integer id, String name, Double baseCost, Double iva, Double iibb) {
		this.id = id;
		this.name = name;
		this.baseCost = baseCost;
		this.iva = iva;
		this.iibb = iibb;
	}

	public Double getTaxes() {
		taxes = baseCost * (iva + iibb);
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public abstract Double getFinalCost();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getIibb() {
		return iibb;
	}

	public void setIibb(Double iibb) {
		this.iibb = iibb;
	}
	

}
