package hex.domain.model;

import java.time.LocalDate;
import java.util.Objects;

class Empleado {

	private String apellido;
	private String nombre;
	private LocalDate fechaDeNacimiento;
	private String email;

	public Empleado(String apellido, String nombre, LocalDate fechaDeNacimiento, String email) {
		this.apellido = Objects.requireNonNull(apellido);
		this.nombre = Objects.requireNonNull(nombre);
		this.fechaDeNacimiento = Objects.requireNonNull(fechaDeNacimiento);
		this.email = Objects.requireNonNull(email);
	}

	public boolean cumpleHoy() {
		return this.verificarFecha() ? true : false;
	}

	private boolean verificarFecha() {
		return this.fechaDeNacimiento.getDayOfMonth() == LocalDate.now().getDayOfMonth()
				&& this.fechaDeNacimiento.getMonthValue() == LocalDate.now().getMonthValue();
	}

	public String nombre() {
		return this.nombre;
	}
}
