package persistenciaRestaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import restaurante.RegistroPago;

public class JdbcRegistroPago implements RegistroPago {

	private ConexionBaseDatos conexionDB = new ConexionBaseDatos();
	private final String INSERT = "INSERT INTO pagos(registro) " + "VALUES (?)";

	@Override
	public void registrarPago(String registro) {
		try {
			Connection connection = conexionDB.abrir();
			PreparedStatement statement = connection.prepareStatement(INSERT);
			statement.setString(1, registro);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException("No se puedo conectar a la base de datos");
		} finally {
			conexionDB.cerrar();
		}
	}
}
