package eje4;

import static java.time.LocalDate.now;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculador {

	@Test
	public void testJubiladoSinPromocion() {
		Calculador calculador = new CalculadorJubilado(now().getMonth().getValue() - 1);
		Assert.assertEquals(200 * 1.1, calculador.calcularPrecio(200), 1);
	}

	@Test
	public void testJubiladoConPromocion() {
		Calculador calculador = new CalculadorJubilado(now().getMonth().getValue());
		Assert.assertEquals(200, calculador.calcularPrecio(200), 1);
	}

	@Test
	public void testNoJubiladoSinPromocion() {
		Calculador calculador = new CalculadorNoJubilado(now().getMonth().getValue() - 1);
		Assert.assertEquals(200 * 1.21, calculador.calcularPrecio(200), 1);
	}

	@Test
	public void testNoJubiladoConPromocion() {
		Calculador calculador = new CalculadorNoJubilado(now().getMonth().getValue());
		Assert.assertEquals(200 * 1.15, calculador.calcularPrecio(200), 1);
	}
}