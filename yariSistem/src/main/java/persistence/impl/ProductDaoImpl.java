package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.nullObjets.NullProduct;
import model.order.Product;
import persistence.ProductDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Integer insert(Product product) {

		try {
			String sql = "INSERT INTO Products (name, baseCost, iva, iibb)" + "VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getBaseCost());
			statement.setDouble(3, product.getIva());
			statement.setDouble(4, product.getIibb());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public Integer update(Product product) {
		try {
			String sql = "UPDATE Products (name, baseCost, iva, iibb)" + "VALUES (?, ?, ?, ?) WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getBaseCost());
			statement.setDouble(3, product.getIva());
			statement.setDouble(4, product.getIibb());
			statement.setDouble(5, product.getId());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer delete(Integer id) {
		try {
			String sql = "DELETE FROM Products WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Product findById(Integer id) {
		try {
			String sql = "SELECT * FROM Products WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			Product product = NullProduct.build();

			if (result.next()) {
				product = toProduct(result);
			}

			return product;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Product findByName(String name) {
		try {
			String sql = "SELECT * FROM Products WHERE name = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);

			ResultSet result = statement.executeQuery();

			Product product = NullProduct.build();

			if (result.next()) {
				product = toProduct(result);
			}

			return product;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Product> findAll() {
		try {
			String sql = "SELECT * FROM Products";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			List<Product> products = new LinkedList<Product>();

			while (result.next()) {
				products.add(toProduct(result));
			}

			return products;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Product toProduct(ResultSet result) {
		try {
			return new Product(result.getInt(1), result.getString(2), result.getDouble(3), result.getDouble(4),
					result.getDouble(5));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
