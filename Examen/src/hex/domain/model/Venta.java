package hex.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import hex.domain.portsin.DomainException;

class Venta {
	private LocalDate fecha;
	private double cantidadLitros;
	private double montoTotal;
	private EstacionServicio estacionServicio;

	public Venta(LocalDate fecha, double cantidadLitros, EstacionServicio combustible) {
		if (cantidadLitros <= 0)
			throw new DomainException("La cantidad de litros debe ser mayor a 0");
		this.fecha = Objects.requireNonNull(fecha);
		this.cantidadLitros = cantidadLitros;
		this.estacionServicio = Objects.requireNonNull(combustible);
		this.montoTotal = this.calcularMontoTotal();
	}

	private double calcularMontoTotal() {
		return estacionServicio.calcularMontoFacturado(cantidadLitros, fecha);
	}

	public double montoTotal() {
		return this.montoTotal;
	}
}
