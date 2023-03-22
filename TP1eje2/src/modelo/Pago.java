package modelo;

import java.util.Objects;

public class Pago {
	private Pedido pedido;
	private TarjetaCredito tarjeta;
	private double propina;
	private double montoTotal;

	public Pago(Pedido pedido, TarjetaCredito tarjeta, double propina) {
		this.pedido = Objects.requireNonNull(pedido);
		this.tarjeta = Objects.requireNonNull(tarjeta);
		this.propina = propina;
		this.montoTotal = 0;
	}

	public double montoTotal() {
		double monto = tarjeta.calcularCosto(pedido.calcularCostoPlatos(), pedido.calcularCostoBebidas());
		return montoTotal = monto + monto * propina;
	}
}
