package accesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import model.Persona;
import model.SetProxy;
import model.Telefono;

public class PersonaDao {

	private Conn conexionDB;
	private static final String FIND_BY_ID = "select p.nombre,t.numero " + "from personas p, telefonos t "
			+ "where p.id = t.idpersona and p.id = ?";
	private static final String SELECT_PERSONA = "select p.nombre " + "from personas p " + "where p.id = ?";
	private static final String SELECT_TELEFONO = "select t.numero " + "from telefonos t " + "where t.idpersona = ?";

	public PersonaDao(Conn conexionDB) {
		this.conexionDB = Objects.requireNonNull(conexionDB);
	}

	public Persona personaPorId(int id) {
		try (Connection conn = conexionDB.abrir();
				PreparedStatement statement = conn.prepareStatement(SELECT_PERSONA);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> proxy = new SetProxy<Telefono>(new PersonaDao(new Conn()), id);
			String nombrePersona = null;
			while (result.next())
				nombrePersona = result.getString(1);
			return new Persona(id, nombrePersona, proxy);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Telefono> telefonosDePersona(int id) {
		try (Connection conn = conexionDB.abrir();
				PreparedStatement statement = conn.prepareStatement(SELECT_TELEFONO);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonos = new HashSet<Telefono>();
			while (result.next())
				telefonos.add(new Telefono(result.getString(1)));
			return telefonos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
