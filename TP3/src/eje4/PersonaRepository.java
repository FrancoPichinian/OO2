package eje4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jdbi.v3.core.Jdbi;

public class PersonaRepository {

	private Jdbi jdbi;
	private static final String SELECT_BY_NAME = "select nombre, apellido from persona where nombre like ?";
	private static final String SELECT_BY_ID = "select nombre, apellido from persona where id_persona = ?";

	public PersonaRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}

	public List<Persona> buscarPorNombre(String nombreOParte) {
		return jdbi.withHandle(handle -> {
			var rs = handle.select(SELECT_BY_NAME).bind(0, "%" + nombreOParte + "%").mapToMap(String.class).list();

			var personas = new ArrayList<Persona>();

			for (Map<String, String> map : rs)
				personas.add(new Persona(map.get("nombre"), map.get("apellido")));

			return personas;
		});
	}

	public Optional<Persona> buscarId(Long id) {
		return jdbi.withHandle(handle -> {

			var rs = handle.select(SELECT_BY_ID).bind(0, id).mapToMap(String.class).list();

			if (rs.size() == 0)
				return Optional.empty();

			return Optional.of(new Persona(rs.get(0).get("nombre"), rs.get(0).get("apellido")));
		});
	}
}