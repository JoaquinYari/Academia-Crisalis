package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.nullObjets.NullService;
import model.order.Service;
import persistence.ServiceDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ServiceDaoImpl implements ServiceDao {

	@Override
	public Integer insert(Service service) {

		try {
			String sql = "INSERT INTO Services (name, baseCost, iva, iibb, special)" + "VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, service.getName());
			statement.setDouble(2, service.getBaseCost());
			statement.setDouble(3, service.getIva());
			statement.setDouble(4, service.getIibb());
			statement.setBoolean(5, service.getSpecial());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public Integer update(Service service) {
		try {
			String sql = "UPDATE Services (name, baseCost, iva, iibb, special)" + "VALUES (?, ?, ?, ?, ?) WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, service.getName());
			statement.setDouble(2, service.getBaseCost());
			statement.setDouble(3, service.getIva());
			statement.setDouble(4, service.getIibb());
			statement.setBoolean(5, service.getSpecial());
			statement.setDouble(6, service.getId());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer delete(Integer id) {
		try {
			String sql = "DELETE FROM Services WHERE id = ?";
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
	public Service findById(Integer id) {
		try {
			String sql = "SELECT * FROM Services WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			Service service = NullService.build();

			if (result.next()) {
				service = toService(result);
			}

			return service;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Service findByName(String name) {
		try {
			String sql = "SELECT * FROM Service WHERE name = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);

			ResultSet result = statement.executeQuery();

			Service service = NullService.build();

			if (result.next()) {
				service = toService(result);
			}

			return service;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Service> findAll() {
		try {
			String sql = "SELECT * FROM Services";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			List<Service> services = new LinkedList<Service>();

			while (result.next()) {
				services.add(toService(result));
			}

			return services;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Service toService(ResultSet result) {
		try {
			return new Service(result.getInt(1), result.getString(2), result.getDouble(3), result.getDouble(4),
					result.getDouble(5), result.getBoolean(6));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
