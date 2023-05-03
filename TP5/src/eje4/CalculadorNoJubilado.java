package eje4;

public class CalculadorNoJubilado extends Calculador {

	private static final double IVA_PROMOCION = 0.15;
	private static final double IVA_SIN_PROMOCION = 0.21;

	public CalculadorNoJubilado(int mesEnPromocion) {
		super(mesEnPromocion);
	}

	@Override
	protected double mesEnPromocion(double precioProducto) {
		return (precioProducto * IVA_PROMOCION) + precioProducto;
	}

	@Override
	protected double mesSinPromocion(double precioProducto) {
		return (precioProducto * IVA_SIN_PROMOCION) + precioProducto;
	}
}
