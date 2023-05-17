package model;

import java.util.Objects;

public class Bebida implements IProducto {

	private String nombre;
	private double precio;

	public Bebida(String nombre, double precio) {
		this.nombre = Objects.requireNonNull(nombre);
		this.precio = precio;
	}

	@Override
	public double calcularMonto(int cantidad) {
		return this.precio * cantidad;
	}

	public String nombre() {
		return nombre;
	}
}
