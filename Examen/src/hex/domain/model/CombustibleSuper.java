package hex.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

class CombustibleSuper extends EstacionServicio {
	private static final double DESCUENTO_SUPER_SABADO = 0.12;
	private static final double DESCUENTO_SUPER_MANANA = 0.05;

	public CombustibleSuper(double precio, double litros) {
		super(precio, litros);
	}

	public double calcularMontoFacturado(double litros, LocalDate fecha) {
		double monto = this.precio;

		// Si es sabado y carga mas de 20 litros, aplico 12% de descuento
		if (esSabado(fecha) && litros > 20)
			monto -= precio * DESCUENTO_SUPER_SABADO;

		// Si carga entre las 8 y 10 de la mañana aplico 5% de descuento
		if (esHoraPico(fecha))
			monto -= precio * DESCUENTO_SUPER_MANANA;

		return monto * litros;
	}

	private boolean esSabado(LocalDate fecha) {
		return fecha.getDayOfWeek() == DayOfWeek.SATURDAY;
	}

	private boolean esHoraPico(LocalDate fecha) {
		LocalTime horaPicoInicio = LocalTime.of(8, 0);
		LocalTime horaPicoFin = LocalTime.of(10, 0);
		LocalTime horaActual = LocalTime.now();
		return horaActual.isAfter(horaPicoInicio) && horaActual.isBefore(horaPicoFin);
	}
}
