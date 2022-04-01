package services;

import model.customer.Person;
import model.order.Product;
import persistence.PersonDao;
import persistence.ProductDao;
import persistence.commons.DaoFactory;

public class ProductService {

	public Product create(Integer id, String name, Double baseCost, Double iva, Double iibb) {

		Product product = new Product(id, name, baseCost, iva, iibb);

		if (product.isValid()) {
			ProductDao productDao = DaoFactory.getProductDao();

			productDao.insert(product);
		}
		return product;

	}

	public void delete(Integer id) {

		ProductDao productDao = DaoFactory.getProductDao();

		productDao.delete(id);

	}

	public Product update(Integer id, String name, Double baseCost, Double iva, Double iibb) {

		ProductDao productDao = DaoFactory.getProductDao();

		Product product = productDao.findById(id);

		if (product.isValid()) {
			product.setName(name);
			product.setBaseCost(baseCost);
			product.setIva(iva);
			product.setIibb(iibb);

			productDao.update(product);
		}

		return product;

	}

	public Product find(Integer id) {
		ProductDao productDao = DaoFactory.getProductDao();
		Product product = productDao.findById(id);
		return product;
	}

}
