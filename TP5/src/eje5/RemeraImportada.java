package eje5;

public class RemeraImportada extends Remera {

	private static final double RECARGO_MAS_IMPUESTO = 0.08;
	private static final double PORCENTAJE_APLICA = 0.25;

	public RemeraImportada(double precioUnitario) {
		super(precioUnitario);
	}

	@Override
	protected double recargo() {
		return (RECARGO_MAS_IMPUESTO * this.precioUnitario);
	}

	@Override
	protected double bonificacion() {
		return 0;
	}

	@Override
	protected double precioFinal() {
		return (PORCENTAJE_APLICA * this.precioUnitario);
	}
}
