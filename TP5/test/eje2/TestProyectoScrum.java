package eje2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TestProyectoScrum {

	private Item tarea1 = new Tarea(1);
	private Item tarea2 = new Tarea(2);
	private Item tarea3 = new Tarea(3);
	private Item tarea4 = new Tarea(4);
	private Item tarea5 = new Tarea(3);
	private Item tarea6 = new Tarea(4);

	private Item spike1 = new Spike(10);
	private Item spike2 = new Spike(10);

	@Test
	public void testCalculoTiempoDeHistoria() {
		Item historiaUsuario1 = new HistoriaUsuario(List.of(tarea1, tarea2));
		Item historiaUsuario2 = new HistoriaUsuario(List.of(tarea3, tarea4));

		Proyecto proyecto = new Proyecto(List.of(historiaUsuario1, historiaUsuario2, spike1, spike2));

		assertEquals(30, proyecto.obtenerHorasTotales());
	}

	@Test
	public void testCalculoTiempoDeHistoriaSegundoCaso() {
		Item historiaUsuario1 = new HistoriaUsuario(List.of(tarea1, tarea2));
		Item historiaUsuario2 = new HistoriaUsuario(List.of(tarea3, tarea4));
		Item historiaUsuario3 = new HistoriaUsuario(List.of(tarea5, tarea6));

		Proyecto proyecto = new Proyecto(List.of(historiaUsuario1, historiaUsuario2, historiaUsuario3, spike1, spike2));

		assertEquals(37, proyecto.obtenerHorasTotales());
	}
}
