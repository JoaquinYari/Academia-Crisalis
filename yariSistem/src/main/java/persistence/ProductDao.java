package persistence;

import model.order.Product;
import persistence.commons.GenericDao;

public interface ProductDao extends GenericDao<Product> {
	
	Product findById(Integer dni);

}
