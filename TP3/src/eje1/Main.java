package eje1;

public class Main {
	public static void main(String args[]) {
		Libro elTunel = new LibroRegular("El Túnel");
		Libro antesDelFin = new LibroRegular("Antes del Fin");
		Alquiler alquilerElTunel = new Alquiler(elTunel, 5);
		Alquiler alquilerAntesDelFin = new Alquiler(antesDelFin, 3);
		Cliente yo = new Cliente("Javier");
		yo.alquilar(alquilerElTunel);
		yo.alquilar(alquilerAntesDelFin);
		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
		System.out.println(resultado[0]);
		System.out.println(resultado[1]);
	}
}