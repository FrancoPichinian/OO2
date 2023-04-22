package hex.domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestEmpleados {

	@Test
	public void verificaEnviaMailSaludo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String fechaString = LocalDate.now().format(formatter);
		FakeLeerArchivo leerArchivo = new FakeLeerArchivo("Young, Angus, " + fechaString + ", angus@acdc.com");
		FakeNotificar notificar = new FakeNotificar();
		DefaultEmpleadoService registro = new DefaultEmpleadoService(leerArchivo, notificar);
		registro.cargarEmpleados();
		registro.enviarSaludo();
		String resultadoEsperado = new String("Saludo");
		Assert.assertEquals(resultadoEsperado, notificar.contenido());
	}

	@Test
	public void verificaNoEnviaMailSaludo() {
		FakeLeerArchivo leerArchivo = new FakeLeerArchivo("Perez, Juan, 2023/04/08, juan@gmail.com");
		FakeNotificar notificar = new FakeNotificar();
		DefaultEmpleadoService registro = new DefaultEmpleadoService(leerArchivo, notificar);
		registro.cargarEmpleados();
		registro.enviarSaludo();
		String resultadoEsperado = new String("");
		Assert.assertEquals(resultadoEsperado, notificar.contenido());
	}

	@Test
	public void verificaCargaEmpleados() {
		FakeLeerArchivo leerArchivo = new FakeLeerArchivo("Young, Angus, 1982/10/08, angus@acdc.com\r\n"
				+ "Johnson, Brian, 1975/09/11, brian@acdc.com\r\n" + "Perez, Juan, 2023/04/08, juan@gmail.com");
		List<String[]> empleadosString = leerArchivo.obtenerEmpleados();
		Assert.assertEquals(3, empleadosString.size());
	}
}
