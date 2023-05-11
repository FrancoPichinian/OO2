package eje4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	private static final String URL = "jdbc:mysql://localhost:3306/tp6";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private Connection connection;

	public Connection abrir() throws SQLException {
		return this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public void cerrar() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
