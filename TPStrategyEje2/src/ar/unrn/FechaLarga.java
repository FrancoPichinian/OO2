package ar.unrn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FechaLarga implements DateManager {

	@Override
	public String fechaFormateada(LocalDate fecha) {
		DateTimeFormatter formateadorLargo = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		return fecha.format(formateadorLargo);
	}
}
