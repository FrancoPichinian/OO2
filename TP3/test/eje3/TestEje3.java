package eje3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestEje3 {

	private ProveedorFecha fecha = new Fecha();

	@Test
	public void testMostrarInformacionCompletaSinMarcaExceso() {
		List<Gasto> listaGastos = new ArrayList<>();
		listaGastos.add(new GastoCena(750));
		listaGastos.add(new GastoAlquilerAuto(2000));
		listaGastos.add(new GastoDesayuno(200));

		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos, fecha);

		String infoEsperada = "Expenses " + fecha.obtenerFechaFormateada() + "Cena	750	 "
				+ "Alquiler de Autos	2000	 " + "Desayuno	200	 " + "Gastos de comida: 950"
				+ "Total de gastos: 2950";
		assertEquals(infoEsperada, reporte.imprimir());
	}

	@Test
	public void testMostrarInformacionCompletaConMarcaExceso() {
		List<Gasto> listaGastos = new ArrayList<>();
		listaGastos.add(new GastoCena(750));
		listaGastos.add(new GastoAlquilerAuto(2000));
		listaGastos.add(new GastoDesayuno(1001));

		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos, fecha);

		String infoEsperada = "Expenses " + fecha.obtenerFechaFormateada() + "Cena	750	 "
				+ "Alquiler de Autos	2000	 " + "Desayuno	1001	" + "X" + "Gastos de comida: 1751"
				+ "Total de gastos: 3751";
		assertEquals(infoEsperada, reporte.imprimir());
	}
}
