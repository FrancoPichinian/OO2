package eje4;

public class CalculadorJubilado extends Calculador {

	private static final double IVA = 0.1;

	public CalculadorJubilado(int mesEnPromocion) {
		super(mesEnPromocion);
	}

	@Override
	protected double mesEnPromocion(double precioProducto) {
		return precioProducto;
	}

	@Override
	protected double mesSinPromocion(double precioProducto) {
		return (precioProducto * IVA) + precioProducto;
	}
}