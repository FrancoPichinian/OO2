package eje1;

import org.junit.Assert;
import org.junit.Test;

public class TestEje1 {

	@Test
	public void alquilerLibroRegular() {
		Libro elTunel = new LibroRegular("El Túnel");
		Libro antesDelFin = new LibroRegular("Antes del Fin");
		Alquiler alquilerElTunel = new Alquiler(elTunel, 5);
		Alquiler alquilerAntesDelFin = new Alquiler(antesDelFin, 3);
		Cliente yo = new Cliente("Javier");
		yo.alquilar(alquilerElTunel);
		yo.alquilar(alquilerAntesDelFin);
		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
		Assert.assertEquals(10.0, resultado[0]);
	}

	@Test
	public void alquilerLibroInfantil() {
		Libro elTunel = new LibroInfantil("El Túnel");
		Libro antesDelFin = new LibroInfantil("Antes del Fin");
		Alquiler alquilerElTunel = new Alquiler(elTunel, 5);
		Alquiler alquilerAntesDelFin = new Alquiler(antesDelFin, 3);
		Cliente yo = new Cliente("Javier");
		yo.alquilar(alquilerElTunel);
		yo.alquilar(alquilerAntesDelFin);
		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
		Assert.assertEquals(6.0, resultado[0]);
	}

	@Test
	public void alquilerLibroNuevoLanzamiento() {
		Libro elTunel = new LibroNuevoLanzamiento("El Túnel");
		Libro antesDelFin = new LibroNuevoLanzamiento("Antes del Fin");
		Alquiler alquilerElTunel = new Alquiler(elTunel, 5);
		Alquiler alquilerAntesDelFin = new Alquiler(antesDelFin, 3);
		Cliente yo = new Cliente("Javier");
		yo.alquilar(alquilerElTunel);
		yo.alquilar(alquilerAntesDelFin);
		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
		Assert.assertEquals(24.0, resultado[0]);
	}
}
