package persistence.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	private static String url = "jdbc:sqlserver://servername=DESKTOP-T4SUKVS\\SQLEXPRESS;databasename=crisalisDB;username=yari;password=yari;";
	private static Connection connection;
	
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
		}
}
