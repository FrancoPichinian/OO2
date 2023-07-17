package hex.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

class CombustibleExtraSuper extends EstacionServicio {
	private static final double DESCUENTO_EXTRA_SUPER_DOMINGO = 0.10;

	public CombustibleExtraSuper(double precio, double litros) {
		super(precio, litros);
	}

	public double calcularMontoFacturado(double litros, LocalDate fecha) {
		double monto = precio;
		if (esDomingo(fecha))
			monto -= precio * DESCUENTO_EXTRA_SUPER_DOMINGO;
		return monto * litros;
	}

	private boolean esDomingo(LocalDate fecha) {
		return fecha.getDayOfWeek() == DayOfWeek.SUNDAY;
	}
}
