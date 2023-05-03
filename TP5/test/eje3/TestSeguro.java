package eje3;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSeguro {

	@Test
	public void calcularCostoPaquete() {
		Seguro seguroHogar = new SeguroRegular(1000.0);
		Seguro seguroAutomovil = new SeguroRegular(2000.0);
		Seguro seguroVida = new SeguroRegular(4000.0);
		Seguro seguroMedico = new SeguroRegular(8000.0);

		PaqueteDeSeguro paquete = new PaqueteDeSeguro(List.of(seguroHogar, seguroAutomovil, seguroVida, seguroMedico));
		Assert.assertEquals(15000 * 0.8, paquete.calcularMonto(), 0);
	}

	@Test
	public void calcularCostoPaqueteSegundoCaso() {
		Seguro seguroHogar = new SeguroRegular(1000.0);
		Seguro seguroAutomovil = new SeguroRegular(2000.0);
		Seguro seguroVida = new SeguroRegular(4000.0);
		Seguro seguroMedico = new SeguroRegular(8000.0);
		Seguro seguroMedico2 = new SeguroRegular(8000.0);

		PaqueteDeSeguro paquete = new PaqueteDeSeguro(
				List.of(seguroHogar, seguroAutomovil, seguroVida, seguroMedico, seguroMedico2));
		Assert.assertEquals(23000 * 0.75, paquete.calcularMonto(), 0);
	}
}
