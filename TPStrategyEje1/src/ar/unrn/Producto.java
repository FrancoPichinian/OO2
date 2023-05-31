package ar.unrn;

public class Producto {
	private double costo;
	private double peso;

	public Producto(double costo, double peso) {
		this.costo = costo;
		this.peso = peso;
	}

	public double costo() {
		return costo;
	}

	public double peso() {
		return peso;
	}
}
