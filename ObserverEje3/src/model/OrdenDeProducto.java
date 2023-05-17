package model;

import java.util.Objects;

public class OrdenDeProducto {
	private IProducto producto;
	private int cantidad;

	public OrdenDeProducto(IProducto producto, int cantidad) {
		this.producto = Objects.requireNonNull(producto);
		this.cantidad = cantidad;
	}

	public double calcularPrecio() {
		return producto.calcularMonto(cantidad);
	}
}
