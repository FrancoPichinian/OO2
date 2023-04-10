package eje1;

import java.util.Objects;

public class Alquiler {
	private Libro libro;
	private int diasAlquilados;

	public Alquiler(Libro libro, int diasAlquilados) {
		// Programacion defensiva
		this.libro = Objects.requireNonNull(libro);
		this.diasAlquilados = diasAlquilados;
	}

	public int diasAlquilados() {
		return this.diasAlquilados;
	}

	public Libro libro() {
		return this.libro;
	}

	public double calcularMonto() {
		return this.libro.calcularMontoPorCantidadDias(this.diasAlquilados);
	}

	public int calcularPuntosFrecuentes() {
		return this.libro.calcularPuntosFrecuentes(this.diasAlquilados);
	}
}
