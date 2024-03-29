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
		double valorEsperado = ((tallarines.calcularMonto(1) + agua.calcularMonto(1)) * 0.97) * 1.02;
		dispositivo.agregarOrden(tallarines, 1);
		dispositivo.agregarOrden(agua, 1);
		dispositivo.confimarPedido();
		dispositivo.pagar(new TarjetaCreditoVisa(), 0.02);
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
		double valorEsperado = ((tallarines.calcularMonto(2) + agua.calcularMonto(1)) * 0.98) * 1.03;
		dispositivo.agregarOrden(tallarines, 2);
		dispositivo.agregarOrden(agua, 1);
		dispositivo.confimarPedido();
		dispositivo.pagar(new TarjetaCreditoMastercard(), 0.03);
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
		double valorEsperado = ((tallarines.calcularMonto(2) + agua.calcularMonto(2)) * 0.98) * 1.05;
		dispositivo.agregarOrden(tallarines, 2);
		dispositivo.agregarOrden(agua, 2);
		dispositivo.confimarPedido();
		dispositivo.pagar(new TarjetaCreditoComarcaPlus(), 0.05);
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
		dispositivo.pagar(new TarjetaCredito(), 0.02);
		Assert.assertEquals(valorEsperado, dispositivo.montoTotal(), 0);

		String fechaYMonto = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + "||"
				+ dispositivo.montoTotal() + "\n";
		Assert.assertEquals(fechaYMonto, registro.contenido());
	}

}
