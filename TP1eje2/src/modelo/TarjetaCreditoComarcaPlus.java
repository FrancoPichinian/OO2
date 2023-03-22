package modelo;

public class TarjetaCreditoComarcaPlus extends TarjetaCredito {

	@Override
	public double calcularCosto(double precioPlatos, double precioBebidas) {
		return (precioPlatos + precioBebidas) * Descuento.COMARCA_PLUS;
	}

}
