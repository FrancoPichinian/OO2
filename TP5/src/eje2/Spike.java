package eje2;

public class Spike extends Item {

	private int tiempo;

	public Spike(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	protected int calcularTiempo() {
		return this.tiempo;
	}
}
