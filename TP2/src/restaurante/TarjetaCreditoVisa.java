package restaurante;

public class TarjetaCreditoVisa extends TarjetaCredito {

	private static final double DESCUENTO_VISA = 0.97;

	@Override
	public double calcularCosto(double precioPlatos, double precioBebidas) {
		return (precioPlatos + precioBebidas) * DESCUENTO_VISA;
	}

}
