package ar.unrn;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {

	private LocalDate fechaNacimiento;
	private DateManager dateManager;

	public Persona(LocalDate fechaNacimiento, DateManager dateManager) {
		this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento);
		this.dateManager = Objects.requireNonNull(dateManager);
	}

	public String fechaNacimiento() {
		return dateManager.fechaFormateada(fechaNacimiento);
	}
}
