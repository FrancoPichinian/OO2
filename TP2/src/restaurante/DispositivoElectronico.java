package restaurante;

import java.time.LocalDate;
import java.util.Objects;

public class DispositivoElectronico {
	private Pedido pedido;
	private Pago pago;
	private RegistroPago registro;

	public DispositivoElectronico(RegistroPago registro) {
		pedido = new Pedido();
		this.registro = Objects.requireNonNull(registro);
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
		Objects.requireNonNull(tarjeta);
		pago = new Pago(pedido, tarjeta, propina);

		String fechaYMonto = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + "||" + this.montoTotal()
				+ "\n";
		this.registro.registrarPago(fechaYMonto);
	}

	double montoTotal() {
		return pago.montoTotal();
	}
}
