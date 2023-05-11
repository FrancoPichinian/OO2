package eje2;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

public class TestReporte {

	private static final String PATH = "C:\\Users\\CX\\ArchivosOO2\\file.txt";

	@Test
	public void escribirEnFileNull() {
		Reporte reporte = new ReporteDefault("Prueba de reporte");
		try {
			reporte.export(null);
			fail();
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}

	@Test
	public void sobreescribeFile() {
		Reporte reporte = new ReporteDefault("Prueba de reporte");
		try {
			reporte.export(new File(PATH));
		} catch (RuntimeException re) {

		}
	}

	@Test
	public void noSobreescribeFileExistente() {
		Reporte reporte = new ReporteSinSobreescribir(new ReporteDefault("Prueba de reporte sin sobreescribir"));
		try {
			reporte.export(new File(PATH));
			fail();
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}
}
