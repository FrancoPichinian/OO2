package eje4;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public abstract class Calculador {

	protected int mesEnPromocion;
	protected LogTransaction log;

	public Calculador(int mesEnPromocion) {
		this.mesEnPromocion = mesEnPromocion;
		this.log = new LogTransaction();
	}

	private boolean mesEnPromocion() {
		return of(mesEnPromocion).equals(now().getMonth());
	}

	// Final para que las subclases no lo puedan sobreescribir
	public final double calcularPrecio(double precioProducto) {
		double precioTotal = precioProducto;
		log.log(this.getClass().getName());
		precioTotal = mesEnPromocion() ? this.mesEnPromocion(precioProducto) : this.mesSinPromocion(precioProducto);
		return precioTotal;
	}

	protected abstract double mesEnPromocion(double precioProducto);

	protected abstract double mesSinPromocion(double precioProducto);
}