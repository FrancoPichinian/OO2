package eje1;

public class LibroInfantil extends Libro {

	private static final double PRECIO_BASE = 1.5;
	private static final int DIAS_MINIMOS = 3;

	public LibroInfantil(String nombre) {
		super(nombre);
	}

	@Override
	double calcularMontoPorCantidadDias(int diasAlquilados) {
		return esMayorADiasMinimos(diasAlquilados) ? calcularMonto(diasAlquilados, PRECIO_BASE) : PRECIO_BASE;
	}

	private boolean esMayorADiasMinimos(int diasAlquilados) {
		return diasAlquilados > DIAS_MINIMOS;
	}

	private double calcularMonto(int diasAlquilados, double monto) {
		return monto += (diasAlquilados - DIAS_MINIMOS) * PRECIO_BASE;
	}
}
