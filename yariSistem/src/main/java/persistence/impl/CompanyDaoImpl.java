package persistence.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.customer.Company;
import model.nullObjets.NullCompany;
import persistence.CompanyDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class CompanyDaoImpl implements CompanyDao {

	@Override
	public Integer insert(Company company) {
		try {
			String sql = "INSERT INTO Companies (businessName, startActivity, cuit, respLastName, respFirstName, respDni)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, company.getBusinessName());
			statement.setDate(2, (Date) company.getStartActivity());
			statement.setInt(3, company.getCuit());
			statement.setString(4, company.getResponsable().getLastName());
			statement.setString(5, company.getResponsable().getFirstName());
			statement.setInt(6, company.getResponsable().getDni());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer update(Company company) {
		try {
			String sql = "UPDATE Companies (businessName, startActivity, cuit, respLastName, respFirstName, respDni)"
					+ "VALUES (?, ?, ?, ?, ?, ?) WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, company.getBusinessName());
			statement.setDate(2, (Date) company.getStartActivity());
			statement.setInt(3, company.getCuit());
			statement.setString(4, company.getResponsable().getLastName());
			statement.setString(5, company.getResponsable().getFirstName());
			statement.setInt(6, company.getResponsable().getDni());
			statement.setInt(7, company.getId());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer delete(Company company) {
		try {
			String sql = "DELETE FROM Companies WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, company.getId());

			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Company findById(Integer id) {
		try {
			String sql = "SELECT * FROM Companies WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			Company company = NullCompany.build();

			if (result.next()) {
				company = toCompany(result);
			}

			return company;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Company> findAll() {
		try {
			String sql = "SELECT * FROM Companies";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			List<Company> companies = new LinkedList<Company>();

			while (result.next()) {
				companies.add(toCompany(result));
			}

			return companies;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Company finByBusinessName(String name) {
		try {
			String sql = "SELECT * FROM Companies WHERE businessName = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);

			ResultSet result = statement.executeQuery();

			Company company = NullCompany.build();

			if (result.next()) {
				company = toCompany(result);
			}

			return company;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Company toCompany(ResultSet result) {

		try {
			return new Company(result.getInt(1), result.getString(2), result.getInt(3), result.getDate(4),
					result.getString(5), result.getString(6), result.getInt(7));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

}
