package eje4;

import org.jdbi.v3.core.Jdbi;

public class Main {

	public static void main(String[] args) {

		Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

		new SetUpDatabase(jdbi).setUp();

		var repo = new PersonaRepository(jdbi);
		var personas = repo.buscarPorNombre("Vla");

		personas.forEach(persona -> {
			System.out.println(persona.nombre() + " " + persona.apellido());
		});

		var persona = repo.buscarId(1L);
		persona.ifPresent(p -> {
			System.out.println(p.nombre() + " " + p.apellido());
		});
	}
}