package model.customer;

import java.util.ArrayList;
import java.util.List;

import model.order.Order;
import model.order.Service;

public class Customer {

	public Integer id;
	public List<Order> orders;
	public List<Service> serviciosActivos;

	public Customer(Integer id) {
		this.id = id;
		orders = new ArrayList<Order>();
		serviciosActivos = new ArrayList<Service>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
