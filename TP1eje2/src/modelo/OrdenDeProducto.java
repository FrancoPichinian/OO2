package modelo;

public class OrdenDeProducto {
	private IProducto producto;
	private int cantidad;

	public OrdenDeProducto(IProducto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public double calcularPrecio() {
		return producto.calcularMonto(cantidad);
	}
}
