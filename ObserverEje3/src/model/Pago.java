package model;

import java.util.Objects;

public class Pago {
	private Pedido pedido;
	private double montoTotal;

	public Pago(Pedido pedido) {
		this.pedido = Objects.requireNonNull(pedido);
		this.montoTotal = 0;
	}

	public double montoTotal() {
		double monto = pedido.calcularCostoPlatos() + pedido.calcularCostoBebidas();
		return monto;
	}
}
