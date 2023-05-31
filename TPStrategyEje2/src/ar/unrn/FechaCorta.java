package ar.unrn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaCorta implements DateManager {

	@Override
	public String fechaFormateada(LocalDate fecha) {
		DateTimeFormatter formateadorCorto = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return fecha.format(formateadorCorto);
	}
}
