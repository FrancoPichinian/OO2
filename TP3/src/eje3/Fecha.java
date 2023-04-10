package eje3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha implements ProveedorFecha {

	@Override
	public LocalDate obtenerFechaActual() {
		return LocalDate.now();
	}

	@Override
	public String obtenerFechaFormateada() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.now().format(formatter);
	}
}
