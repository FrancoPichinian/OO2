package concurso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaFormateada {
	private LocalDate fecha;

	public FechaFormateada(LocalDate fecha) {
		this.fecha = Objects.requireNonNull(fecha);
	}

	public String obtenerFechaFormateada() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fecha.format(formatter);
	}
}
