package persistence;

import java.util.List;

import model.customer.Customer;
import model.order.Order;
import persistence.commons.GenericDao;

public interface OrderDao extends GenericDao<Order> {
	
	List<Order> getOrdersByClient(Customer client);

}
