package restaurante;

public class TarjetaCreditoComarcaPlus extends TarjetaCredito {

	private static final double DESCUENTO_COMARCA = 0.98;

	@Override
	public double calcularCosto(double precioPlatos, double precioBebidas) {
		return (precioPlatos + precioBebidas) * DESCUENTO_COMARCA;
	}

}
