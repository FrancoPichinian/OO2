package hex.domain.model;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class TestEstacionServicio {

	@Test
	public void cargarCombustibleSuper() {
		EstacionServicio combustibleSuper = new CombustibleSuper(270.0, 10);
		Venta venta = new Venta(LocalDate.now(), combustibleSuper.litros(), combustibleSuper);
		Assert.assertEquals(2700, venta.montoTotal(), 0);
	}

	@Test
	public void cargarCombustibleExtraSuper() {
		EstacionServicio combustibleExtraSuper = new CombustibleExtraSuper(390.0, 10);
		Venta venta = new Venta(LocalDate.now(), combustibleExtraSuper.litros(), combustibleExtraSuper);
		Assert.assertEquals(3900, venta.montoTotal(), 0);
	}

	@Test
	public void cargarCombustibleExtraSuperDomingo() {
		EstacionServicio combustibleExtraSuper = new CombustibleExtraSuper(390.0, 10);
		Venta venta = new Venta(LocalDate.now().plusDays(6), combustibleExtraSuper.litros(), combustibleExtraSuper);
		Assert.assertEquals(3510, venta.montoTotal(), 0);
	}

	@Test
	public void cargarMasVeinteLitrosCombustibleSuperSabado() {
		EstacionServicio combustibleSuper = new CombustibleSuper(270.0, 30);
		Venta venta = new Venta(LocalDate.now().plusDays(5), combustibleSuper.litros(), combustibleSuper);
		Assert.assertEquals(7128, venta.montoTotal(), 0);
	}
}
