package hex.infrastructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hex.domain.portsout.InfrastructureException;

public class Conn {
	private static final String URL = "jdbc:mysql://localhost:3306/tp4eje3";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String MSG = "No fue posible cerrar la base de datos...";
	private Connection connection;

	public Connection abrir() throws SQLException {
		return this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public void cerrar() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new InfrastructureException(e, MSG);
		}
	}
}
