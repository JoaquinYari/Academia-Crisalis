package ap;

import model.customer.Company;
import model.customer.Customer;
import model.order.Order;
import model.order.Product;
import model.order.Service;
import persistence.CompanyDao;
import persistence.impl.CompanyDaoImpl;

public class App {
	
	public static void main(String[] args) {
		
		Customer c1 = new Company(1, "Nana","", null, "Gonzalez", "Joaquin", "");
		
		Product p0 = new Product(0, "p0", 500.0, 21.0, 3.5, 0);
		Product p1 = new Product(1, "p1", 700.0, 21.0, 3.5, 0);
		Product p2 = new Product(2, "p2", 1200.0, 21.0, 3.5, 2);
		
		Service s0 = new Service(0, "s0", 2100.0, 21.0, 3.5, true);
		Service s1 = new Service(1, "s1", 4500.0, 21.0, 3.5, false);
		Service s2 = new Service(2, "s2", 1800.0, 21.0, 3.5, false);
		
		Order pedido0 = new Order(01, c1);
		
		pedido0.addItem(p0, 1);
		pedido0.addItem(p1, 2);
		pedido0.addItem(p2, 1);
		pedido0.addItem(s0, 1);
		pedido0.addItem(s1, 3);
		pedido0.addItem(s2, 1);
		
		
		CompanyDao companyDao = new CompanyDaoImpl();
		
		companyDao.insert((Company) c1);
	
		
		System.out.println(pedido0.getItems());
		
		pedido0.closeOrder();
		
		System.out.println(pedido0.getItems());
	
		System.out.println(pedido0);
		
		pedido0.cancelOrder();
		
		System.out.println(pedido0);
		
	}

}
