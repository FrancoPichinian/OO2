package aop.accesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import aop.domain.Time;

@Component
public class JdbcRepositorioPersonas {

	private Conn conexionDB;

	public JdbcRepositorioPersonas(Conn conexionDB) {
		this.conexionDB = Objects.requireNonNull(conexionDB);
	}

	@Time
	public void agregarPersonas(int cantPersonas) {
		try (Connection connection = conexionDB.abrir()) {
			IntStream.rangeClosed(1, cantPersonas).forEach(i -> {
				try {
					PreparedStatement s = connection.prepareStatement("INSERT INTO Personas VALUES (?)");
					s.setString(1, "Persona " + i);
					s.executeUpdate();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			});
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
