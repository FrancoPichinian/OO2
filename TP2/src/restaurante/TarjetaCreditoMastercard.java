package restaurante;

public class TarjetaCreditoMastercard extends TarjetaCredito {

	private static final double DESCUENTO_MASTERCARD = 0.98;

	@Override
	public double calcularCosto(double precioPlatos, double precioBebidas) {
		return (precioPlatos + precioBebidas) * DESCUENTO_MASTERCARD;
	}

}
