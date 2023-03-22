package modelo;

public class DispositivoElectronico {
	private Pedido pedido;
	private Pago pago;

	public DispositivoElectronico() {
		pedido = new Pedido();
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

	public void pagar(TarjetaCredito tarjeta, double propina) {
		pago = new Pago(pedido, tarjeta, propina);
	}

	public double montoTotal() {
		return pago.montoTotal();
	}
}
