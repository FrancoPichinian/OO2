package hex.infrastructure.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import hex.domain.portsin.InscriptoRecord;
import hex.domain.portsout.InfrastructureException;
import hex.domain.portsout.RepositorioInscriptos;

public class JdbcRepositorioInscriptos implements RepositorioInscriptos {

	private Conn conexionDB;
	private static final String INSERT = "insert into inscriptos(apellido, nombre, telefono, email, id_concurso) values(?,?,?,?,?)";
	private static final String MSG = "No se puede conectar a la base de datos...";

	public JdbcRepositorioInscriptos(Conn conexionDB) {
		this.conexionDB = Objects.requireNonNull(conexionDB);
	}

	@Override
	public void nuevoInscripto(InscriptoRecord record) {
		try {
			Connection connection = conexionDB.abrir();
			PreparedStatement statement = connection.prepareStatement(INSERT);
			statement.setString(1, record.apellido());
			statement.setString(2, record.nombre());
			statement.setString(3, record.telefono());
			statement.setString(4, record.email());
			statement.setString(5, record.concurso());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new InfrastructureException(e, MSG);
		} finally {
			conexionDB.cerrar();
		}
	}
}
