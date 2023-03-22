package modelo;

public class TarjetaCreditoVisa extends TarjetaCredito {

	@Override
	public double calcularCosto(double precioPlatos, double precioBebidas) {
		return (precioPlatos + precioBebidas) * Descuento.VISA;
	}

}
