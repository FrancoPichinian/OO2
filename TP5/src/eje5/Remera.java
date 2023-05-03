package eje5;

public abstract class Remera {
	protected double precioUnitario;

	public Remera(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public final double precioVenta() {
		return (this.precioUnitario + this.recargo() - this.bonificacion() + this.precioFinal());
	}

	protected abstract double recargo();

	protected abstract double bonificacion();

	protected abstract double precioFinal();
}