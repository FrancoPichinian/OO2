package eje5;

public class RemeraNacional extends Remera {

	private static final double RECARGO = 0.015;
	private static final double BONIFICACION = 0.2;
	private static final double PORCENTAJE_APLICA = 0.15;

	public RemeraNacional(double precioUnitario) {
		super(precioUnitario);
	}

	@Override
	protected double recargo() {
		return (RECARGO * this.precioUnitario);
	}

	@Override
	protected double bonificacion() {
		return (BONIFICACION * this.precioUnitario);
	}

	@Override
	protected double precioFinal() {
		return (PORCENTAJE_APLICA * this.precioUnitario);
	}
}
