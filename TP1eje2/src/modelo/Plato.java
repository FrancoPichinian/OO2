package modelo;

public class Plato implements IProducto {

	private String nombre;
	private double precio;

	public Plato(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public double calcularMonto(int cantidad) {
		return this.precio * cantidad;
	}
}
