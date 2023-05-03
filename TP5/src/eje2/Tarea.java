package eje2;

public class Tarea extends Item {

	private int tiempo;

	public Tarea(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	protected int calcularTiempo() {
		return this.tiempo;
	}
}
