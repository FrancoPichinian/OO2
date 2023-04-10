package eje1;

public class LibroNuevoLanzamiento extends Libro {

	private static final int PUNTO_MINIMO = 1;
	private static final int PUNTOS_ADICIONALES = 2;
	private static final double PRECIO_POR_DIA = 3;

	public LibroNuevoLanzamiento(String nombre) {
		super(nombre);
	}

	@Override
	public int calcularPuntosFrecuentes(int diasAlquilados) {
		return esMayorAPuntoMinimo(diasAlquilados) ? PUNTOS_ADICIONALES : PUNTO_MINIMO;
	}

	private boolean esMayorAPuntoMinimo(int diasAlquilados) {
		return diasAlquilados > PUNTO_MINIMO;
	}

	@Override
	double calcularMontoPorCantidadDias(int diasAlquilados) {
		return diasAlquilados * PRECIO_POR_DIA;
	}
}
