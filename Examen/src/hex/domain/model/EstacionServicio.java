package hex.domain.model;

import java.time.LocalDate;

abstract class EstacionServicio {

	private double litros;
	protected double precio;

	public EstacionServicio(double precio, double litros) {
		this.precio = precio;
		this.litros = litros;
	}

	public abstract double calcularMontoFacturado(double litros, LocalDate fecha);

	public double litros() {
		return litros;
	}
}
