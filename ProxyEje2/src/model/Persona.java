package model;

import java.util.Objects;
import java.util.Set;

public class Persona {
	private int id;
	private String nombre;
	private Set<Telefono> telefonos;

	public Persona(int id, String nombre, Set<Telefono> telefonos) {
		this.id = id;
		this.nombre = Objects.requireNonNull(nombre);
		this.telefonos = Objects.requireNonNull(telefonos);
	}

	public Telefono[] telefonos() {
		return telefonos.toArray(new Telefono[telefonos.size()]);
	}

	public String nombre() {
		return nombre;
	}
}