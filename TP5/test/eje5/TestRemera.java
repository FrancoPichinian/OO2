package eje5;

import org.junit.Assert;
import org.junit.Test;

public class TestRemera {

	@Test
	public void testRemeraNacional() {
		Negocio negocioAdidas = new Negocio("Adidas");
		Remera remeraNacional = new RemeraNacional(800);
		negocioAdidas.agregarRemera(remeraNacional);
		Assert.assertEquals(800 * 0.965, remeraNacional.precioVenta(), 0);
	}

	@Test
	public void testRemeraImportada() {
		Negocio negocioPuma = new Negocio("Puma");
		Remera remeraImportada = new RemeraImportada(2000);
		negocioPuma.agregarRemera(remeraImportada);
		Assert.assertEquals(2000 * 1.33, remeraImportada.precioVenta(), 0);
	}
}
