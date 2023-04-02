package restaurante;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class TestRestaurante {

	private FakeRegistroPago registro = new FakeRegistroPago();

	@Test
	public void calculoCostoConVisaYPropinaDosPorCiento() {
		DispositivoElectronico dispositivo = new DispositivoElectronico(registro);
		Plato tallarines = new Plato("tallarines", 400);
		Bebida agua = new Bebida("agua", 100);
		double valorEsperado = ((tallarines.calcularMonto(1) + agua.calcularMonto(1)) * Descuento.VISA) * 1.02;
		dispositivo.agregarOrden(tallarines, 1);
		dispositivo.agregarOrden(agua, 1);
		dispositivo.confimarPedido();
		dispositivo.pagar(new TarjetaCreditoVisa(), Propina.PROPINA_2);
		Assert.assertEquals(valorEsperado, dispositivo.montoTotal(), 0);

		String fechaYMonto = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + "||"
				+ dispositivo.montoTotal() + "\n";
		Assert.assertEquals(fechaYMonto, registro.contenido());
	}

	@Test
	public void calculoCostoConMastercardYPropinaTresPorCiento() {
		DispositivoElectronico dispositivo = new DispositivoElectronico(registro);
		Plato tallarines = new Plato("tallarines", 400);
		Bebida agua = new Bebida("agua", 100);
		double valorEsperado = ((tallarines.calcularMonto(2) + agua.calcularMonto(1)) * Descuento.MASTERCARD) * 1.03;
		dispositivo.agregarOrden(tallarines, 2);
		dispositivo.agregarOrden(agua, 1);
		dispositivo.confimarPedido();
		dispositivo.pagar(new TarjetaCreditoMastercard(), Propina.PROPINA_3);
		Assert.assertEquals(valorEsperado, dispositivo.montoTotal(), 0);

		String fechaYMonto = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + "||"
				+ dispositivo.montoTotal() + "\n";
		Assert.assertEquals(fechaYMonto, registro.contenido());
	}

	@Test
	public void calculoCostoConComarcaPlusYPropinaCincoPorCiento() {
		DispositivoElectronico dispositivo = new DispositivoElectronico(registro);
		Plato tallarines = new Plato("tallarines", 400);
		Bebida agua = new Bebida("agua", 100);
		double valorEsperado = ((tallarines.calcularMonto(2) + agua.calcularMonto(2)) * Descuento.COMARCA_PLUS) * 1.05;
		dispositivo.agregarOrden(tallarines, 2);
		dispositivo.agregarOrden(agua, 2);
		dispositivo.confimarPedido();
		dispositivo.pagar(new TarjetaCreditoComarcaPlus(), Propina.PROPINA_5);
		Assert.assertEquals(valorEsperado, dispositivo.montoTotal(), 0);

		String fechaYMonto = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + "||"
				+ dispositivo.montoTotal() + "\n";
		Assert.assertEquals(fechaYMonto, registro.contenido());
	}

	@Test
	public void calculoCostoConTarjetaViedmaYPropinaDosPorCiento() {
		DispositivoElectronico dispositivo = new DispositivoElectronico(registro);
		Plato tallarines = new Plato("tallarines", 400);
		Bebida agua = new Bebida("agua", 100);
		double valorEsperado = (tallarines.calcularMonto(1) + agua.calcularMonto(1)) * 1.02;
		dispositivo.agregarOrden(tallarines, 1);
		dispositivo.agregarOrden(agua, 1);
		dispositivo.confimarPedido();
		dispositivo.pagar(new TarjetaCredito(), Propina.PROPINA_2);
		Assert.assertEquals(valorEsperado, dispositivo.montoTotal(), 0);

		String fechaYMonto = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + "||"
				+ dispositivo.montoTotal() + "\n";
		Assert.assertEquals(fechaYMonto, registro.contenido());
	}

}
