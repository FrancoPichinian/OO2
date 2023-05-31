package ar.unrn;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class TestFecha {

	@Test
	public void testFechaCorta() {
		DateManager dateShort = new FechaCorta();
		Persona persona = new Persona(LocalDate.of(1986, 06, 3), dateShort);
		Assert.assertEquals("03-06-1986", persona.fechaNacimiento());
	}

	@Test
	public void testFechaLarga() {
		DateManager dateLong = new FechaLarga();
		Persona persona = new Persona(LocalDate.of(1986, 06, 3), dateLong);
		Assert.assertEquals("3 de junio de 1986", persona.fechaNacimiento());
	}
}
