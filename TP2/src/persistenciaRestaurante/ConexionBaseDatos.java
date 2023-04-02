package persistenciaRestaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DB = "tp2eje2";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private Connection connection;

	public Connection abrir() throws SQLException {
		return this.connection = DriverManager.getConnection(URL + DB + "?useSSL=false", USER, PASSWORD);
	}

	public void cerrar() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
