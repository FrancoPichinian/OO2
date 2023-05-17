package hex.infrastructure.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import hex.domain.portsin.ParticipanteRecord;
import hex.domain.portsout.Participantes;
import hex.domain.portsout.ParticipantesException;

public class JdbcParticipante implements Participantes {

	private Conn conexionDB;
	private static final String INSERT = "insert into participantes(nombre, telefono, region, email) values(?,?,?,?)";
	private static final String MSG = "No se puede conectar a la base de datos...";

	public JdbcParticipante(Conn conexionDB) {
		this.conexionDB = Objects.requireNonNull(conexionDB);
	}

	public void nuevoParticipante(ParticipanteRecord record) {
		try {
			Connection connection = conexionDB.abrir();
			PreparedStatement statement = connection.prepareStatement(INSERT);
			statement.setString(1, record.nombre());
			statement.setString(2, record.telefono());
			statement.setString(3, record.region());
			statement.setString(4, record.email());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new ParticipantesException(e, MSG);
		} finally {
			conexionDB.cerrar();
		}
	}
}
