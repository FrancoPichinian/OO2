package eje1;

import java.util.Objects;

public abstract class Libro {
	private static final int PUNTO_MINIMO = 1;
	private String nombre;

	public Libro(String nombre) {
		// Programacion defensiva
		this.nombre = Objects.requireNonNull(nombre);
	}

	public int calcularPuntosFrecuentes(int diasAlquilados) {
		return PUNTO_MINIMO;
	}

	abstract double calcularMontoPorCantidadDias(int diasAlquilados);

}