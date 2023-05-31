package ar.unrn;

import java.util.List;
import java.util.Objects;

public class Compra {

	private List<Producto> productos;
	private FormaEnvio formaEnvio;
	private String destino;

	public Compra(List<Producto> productos, FormaEnvio formaDeEnvio, String destino) {
		this.productos = Objects.requireNonNull(productos);
		this.formaEnvio = Objects.requireNonNull(formaDeEnvio);
		this.destino = Objects.requireNonNull(destino);
	}

	public String destino() {
		return this.destino;
	}

	private double montoTotal() {
		return productos.stream().mapToDouble(Producto::costo).sum();
	}

	public double pesoTotal() {
		return productos.stream().mapToDouble(Producto::peso).sum();
	}

	public double calcularCostoTotal() {
		return this.montoTotal() + this.formaEnvio.costoDeEnvio(this);
	}
}
