package model.order;

import java.time.LocalDateTime;
import java.util.Hashtable;

import model.customer.Customer;

public class Order {

	private Integer orderID;
	private Hashtable<Item, Integer> items;
	private Double orderCost;
	private LocalDateTime orderDate;
	private Customer customer;
	private Double discount;
	private Double itemsCost;
	private Boolean isActive;

	private Double PROFIT = 0.1;
	private Double MAXDISCOUNT = 2500.0;

	public Order(Integer orderID, Customer customer) {
		this.orderID = orderID;
		this.customer = customer;
		itemsCost = 0.0;
		discount = 0.0;
		items = new Hashtable<Item, Integer>();
		isActive = true;
	}

	public void addItem(Item item, Integer quantity) {
		items.put(item, quantity);
	}

	public Double getItemsCost() {
		for (Item item : items.keySet()) {
			itemsCost += item.getFinalCost() * items.get(item);
		}
		return itemsCost;
	}

	public Boolean discountCorresponds() {
		for (Item item : items.keySet()) {
			if (item instanceof Service)
				return true;
		}
		for (Order order : customer.orders) {
			if (order.isActive) {
				for (Item item : items.keySet()) {
					if (item instanceof Service)
						return true;
				}
			}
		}
		return false;
	}

	public Double getDiscount() {
		for (Item item : items.keySet()) {
			if (item instanceof Product) {
				discount += item.getFinalCost() * PROFIT * items.get(item);
			}
		}
		if (discount > MAXDISCOUNT) {
			return MAXDISCOUNT;
		} else {
			return discount;
		}
	}

	public void closeOrder() {
		itemsCost = getItemsCost();
		if (discountCorresponds()) {
			discount = getDiscount();
		}
		orderCost = itemsCost - discount;
		setDateOrder();
		customer.orders.add(this);
	}

	public void cancelOrder() {
		orderCost = 0.0;
		isActive = false;
		customer.orders.remove(this);
	}

	public Integer getOrderId() {
		return orderID;
	}

	public Double getOrderCost() {
		return orderCost;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	private void setDateOrder() {
		this.orderDate = LocalDateTime.now();
	}

	public Hashtable<Item, Integer> getItems() {
		return items;
	}


}
