package restaurante;

public class TarjetaCreditoMastercard extends TarjetaCredito {

	@Override
	public double calcularCosto(double precioPlatos, double precioBebidas) {
		return (precioPlatos + precioBebidas) * Descuento.MASTERCARD;
	}

}
