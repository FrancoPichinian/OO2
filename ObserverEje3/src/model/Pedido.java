package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<OrdenDeProducto> ordenDePlatos;
	private List<OrdenDeProducto> ordenDeBebidas;
	private boolean confirmado;

	public Pedido() {
		this.ordenDePlatos = new ArrayList<>();
		this.ordenDeBebidas = new ArrayList<>();
		this.confirmado = false;
	}

	public void agregarOrden(Plato plato, int cantidad) {
		if (this.confirmado == true)
			throw new RuntimeException("El pedido está confirmado");
		this.ordenDePlatos.add(new OrdenDeProducto(plato, cantidad));
	}

	public void agregarOrden(Bebida bebida, int cantidad) {
		if (this.confirmado == true)
			throw new RuntimeException("El pedido está confirmado");
		this.ordenDeBebidas.add(new OrdenDeProducto(bebida, cantidad));
	}

	public void confirmarPedido() {
		this.confirmado = true;
	}

	public double calcularCostoPlatos() {
		return this.ordenDePlatos.stream().mapToDouble(o -> o.calcularPrecio()).sum();

	}

	public double calcularCostoBebidas() {
		return this.ordenDeBebidas.stream().mapToDouble(o -> o.calcularPrecio()).sum();
	}
}
