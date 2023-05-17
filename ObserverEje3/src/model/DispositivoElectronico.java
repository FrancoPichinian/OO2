package model;

import java.util.List;

public class DispositivoElectronico extends Observable {
	private Pedido pedido;
	private Pago pago;

	public DispositivoElectronico(List<Observer> monitores) {
		pedido = new Pedido();
		for (Observer observer : monitores) {
			this.agregarObservador(observer);
		}
	}

	public void agregarOrden(Plato plato, int cantidad) {
		pedido.agregarOrden(plato, cantidad);
	}

	public void agregarOrden(Bebida bebida, int cantidad) {
		pedido.agregarOrden(bebida, cantidad);
	}

	public void confimarPedido() {
		pedido.confirmarPedido();
	}

	public void pagar(Plato plato, Bebida bebida, int cantidad) {
		pago = new Pago(pedido);
		this.agregarOrden(plato, cantidad);
		this.agregarOrden(bebida, cantidad);
	}

	public double montoTotal() {
		this.notificar(String.valueOf(pago.montoTotal()));
		return pago.montoTotal();
	}
}
