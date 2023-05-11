package eje4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class JdbcListadoItems implements ListadoItems {

	private ListadoItems listador;
	private Conn conexionDB;
	private static final String INSERT = "INSERT INTO posts(informacion) " + "VALUES (?)";

	public JdbcListadoItems(Conn conexionDB, ListadoItems listador) {
		this.conexionDB = Objects.requireNonNull(conexionDB);
		this.listador = Objects.requireNonNull(listador);
	}

	@Override
	public String obtenerListado() {
		try {
			Connection connection = conexionDB.abrir();
			PreparedStatement statement = connection.prepareStatement(INSERT);
			statement.setString(1, listador.obtenerListado());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("No se puede conectar a la base de datos..." + e);
		} finally {
			conexionDB.cerrar();
		}
		return listador.obtenerListado();
	}
}
