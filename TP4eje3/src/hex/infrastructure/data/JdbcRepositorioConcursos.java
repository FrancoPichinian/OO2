package hex.infrastructure.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import hex.domain.portsout.InfrastructureException;
import hex.domain.portsout.RepositorioConcursos;

public class JdbcRepositorioConcursos implements RepositorioConcursos {

	private Conn conexionDB;
	private static final String SELECT = "SELECT * from concursos";
	private static final String MSG = "No se puede conectar a la base de datos...";

	public JdbcRepositorioConcursos(Conn conexionDB) {
		this.conexionDB = Objects.requireNonNull(conexionDB);
	}

	@Override
	public List<String[]> todosLosConcursos() {
		List<String[]> concursos = new ArrayList<>();
		try {
			Connection connection = conexionDB.abrir();
			PreparedStatement statement = connection.prepareStatement(SELECT);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String[] concurso = new String[4];
				concurso[0] = Integer.toString(rs.getInt("id"));
				concurso[1] = rs.getString("nombre");
				concurso[2] = rs.getDate("fechaInicio").toLocalDate().toString();
				concurso[3] = rs.getDate("fechaFin").toLocalDate().toString();
				concursos.add(concurso);
			}
		} catch (SQLException e) {
			throw new InfrastructureException(e, MSG);
		} finally {
			conexionDB.cerrar();
		}
		return concursos;
	}
}
