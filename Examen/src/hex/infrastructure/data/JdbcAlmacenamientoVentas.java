package hex.infrastructure.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import hex.domain.portsout.AlmacenamientoVentas;
import hex.domain.portsout.InfrastructureException;

public class JdbcAlmacenamientoVentas implements AlmacenamientoVentas {
	private Conn conexionDB;
	private static final String SELECT = "SELECT * from ventas";
	private static final String MSG = "No se puede conectar a la base de datos...";

	public JdbcAlmacenamientoVentas(Conn conexionDB) {
		this.conexionDB = Objects.requireNonNull(conexionDB);
	}

	@Override
	public List<String[]> ventasRealizadas() {
		List<String[]> ventas = new ArrayList<>();
		try (Connection connection = conexionDB.abrir();
				PreparedStatement statement = connection.prepareStatement(SELECT);
				ResultSet rs = statement.executeQuery()) {
			while (rs.next()) {
				String[] concurso = new String[3];
				concurso[0] = rs.getDate("fecha").toLocalDate().toString();
				concurso[1] = Double.toString(rs.getDouble("litros"));
				concurso[2] = Double.toString(rs.getDouble("montoTotal"));
				ventas.add(concurso);
			}
		} catch (SQLException e) {
			throw new InfrastructureException(e, MSG);
		}
		return ventas;
	}
}
