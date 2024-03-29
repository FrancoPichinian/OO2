package persistenciaConcurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import concurso.RegistroInscripcion;

public class JdbcRegistroInscripcion implements RegistroInscripcion {

	private ConexionBaseDatos conexionDB = new ConexionBaseDatos();
	private final String INSERT = "INSERT INTO inscripciones(registro) " + "VALUES (?)";

	@Override
	public void registrar(String registro) {
		try {
			Connection connection = conexionDB.abrir();
			PreparedStatement statement = connection.prepareStatement(INSERT);
			statement.setString(1, registro);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException("No se puede conectar a la base de datos");
		} finally {
			conexionDB.cerrar();
		}
	}
}
