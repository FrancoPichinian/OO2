package aop.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aop.accesos.JdbcRepositorioPersonas;

@RestController
public class PersonasController {

	private JdbcRepositorioPersonas personas;

	public PersonasController(JdbcRepositorioPersonas personas) {
		this.personas = personas;
	}

	@GetMapping("/personas/{count}")
	public String addPeople(@PathVariable int count) {
		personas.agregarPersonas(count);
		return "Personas agregadas correctamente";
	}
}
