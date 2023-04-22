package hex.domain.model;

import java.time.LocalDate;
import java.util.Objects;

class Concurso {
	private String id;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;

	public Concurso(String id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
		this.id = Objects.requireNonNull(id);
		this.nombre = Objects.requireNonNull(nombre);
		this.fechaInicioInscripcion = Objects.requireNonNull(fechaInicioInscripcion);
		this.fechaFinInscripcion = Objects.requireNonNull(fechaFinInscripcion);
	}

	public boolean inscripcionEstaAbierta() {
		return LocalDate.now().isAfter(fechaInicioInscripcion) && LocalDate.now().isBefore(fechaFinInscripcion);
	}

	public String id() {
		return this.id;
	}
}
