package ar.unrn;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestCompra {

	@Test
	public void compraColectivosSur() {
		Producto celular = new Producto(80000, 200);
		Producto reloj = new Producto(10000, 90);
		List<Producto> productos = List.of(celular, reloj);

		Compra compra = new Compra(productos, new ColectivosSur(), "gran buenos aires");

		Assert.assertEquals(93500, compra.calcularCostoTotal(), 0);
	}

	@Test
	public void compraCorreoArgentino() {
		Producto celular = new Producto(80000, 200);
		Producto reloj = new Producto(10000, 90);

		List<Producto> productos = List.of(celular, reloj);

		Compra compra = new Compra(productos, new CorreoArgentino(), "gran buenos aires");

		Assert.assertEquals(91300, compra.calcularCostoTotal(), 0);
	}
}
