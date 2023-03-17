package modelo;

public class Participante {
	private int puntos;

	public Participante() {
		this.puntos = 0;
	}

	public void sumarPuntos(int puntos) {
		this.puntos += puntos;
	}

	public int cantidadTotalPuntos() {
		return this.puntos;
	}
}
