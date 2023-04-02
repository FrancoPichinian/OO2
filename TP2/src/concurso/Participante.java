package concurso;

import java.util.Objects;

public class Participante {
	private String nombre;
	private int puntos;

	public Participante(String nombre) {
		this.nombre = Objects.requireNonNull(nombre);
		this.puntos = 0;
	}

	public void sumarPuntos(int puntos) {
		this.puntos += puntos;
	}

	public int cantidadTotalPuntos() {
		return this.puntos;
	}

	public String obtenerNombre() {
		return this.nombre;
	}
}
