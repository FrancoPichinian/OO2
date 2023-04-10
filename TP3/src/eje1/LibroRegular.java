package eje1;

public class LibroRegular extends Libro {

	private static final double PRECIO_BASE = 1.5;
	private static final int DIAS_MINIMOS = 2;

	public LibroRegular(String nombre) {
		super(nombre);
	}

	@Override
	double calcularMontoPorCantidadDias(int diasAlquilados) {
		return esMayorADiasMinimos(diasAlquilados) ? calcularMonto(diasAlquilados, 2) : 2;
	}

	private boolean esMayorADiasMinimos(int diasAlquilados) {
		return diasAlquilados > DIAS_MINIMOS;
	}

	private double calcularMonto(int diasAlquilados, double monto) {
		return monto += (diasAlquilados - 2) * PRECIO_BASE;
	}
}
