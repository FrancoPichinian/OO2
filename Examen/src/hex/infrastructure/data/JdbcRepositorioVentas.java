package hex.infrastructure.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import hex.domain.portsout.InfrastructureException;
import hex.domain.portsout.RepositorioVentas;

public class JdbcRepositorioVentas implements RepositorioVentas {

	private Conn conexionDB;
	private static final String INSERT = "insert into ventas(fecha, litros, montoTotal) values(?,?,?)";
	private static final String MSG = "No se puede conectar a la base de datos...";

	public JdbcRepositorioVentas(Conn conexionDB) {
		this.conexionDB = conexionDB;
	}

	@Override
	public void persistir(LocalDate fecha, double litros, double montoTotal) {
		try (Connection connection = conexionDB.abrir();
				PreparedStatement statement = connection.prepareStatement(INSERT)) {
			statement.setDate(1, java.sql.Date.valueOf(fecha));
			statement.setDouble(2, litros);
			statement.setDouble(3, montoTotal);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new InfrastructureException(e, MSG);
		}
	}
}
