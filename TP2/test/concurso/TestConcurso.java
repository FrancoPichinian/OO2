package concurso;

import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class TestConcurso {

	private FakeRegistroInscripcion fakeRegistroInscripcion = new FakeRegistroInscripcion();
	private FakeNotificarParticipante fakeNotificarParticipante = new FakeNotificarParticipante();

	@Test
	public void participanteSeInscribeEnConcurso() {

		// Inicializacion
		Concurso concurso = new Concurso("Concurso", LocalDate.now().minusDays(1), LocalDate.now().plusDays(10),
				fakeRegistroInscripcion, fakeNotificarParticipante);
		Participante participante = new Participante("Franco");
		// Ejercitacion
		concurso.inscribirParticipante(participante);
		// Verificacion
		Assert.assertTrue(concurso.estaInscripto(participante));

		String formato = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + ", "
				+ participante.obtenerNombre() + ", " + concurso.obtenerNombre() + "\n";
		Assert.assertEquals(formato, fakeRegistroInscripcion.contenido());

		Assert.assertEquals("Inscripción", fakeNotificarParticipante.contenido());
	}

	@Test
	public void participanteSeInscribeElPrimerDia() {
		Concurso concurso = new Concurso("Concurso", LocalDate.now(), LocalDate.now().plusDays(10),
				fakeRegistroInscripcion, fakeNotificarParticipante);
		Participante participante = new Participante("Juan");
		concurso.inscribirParticipante(participante);
		Assert.assertEquals(participante.cantidadTotalPuntos(), 10);

		String formato = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + ", "
				+ participante.obtenerNombre() + ", " + concurso.obtenerNombre() + "\n";
		Assert.assertEquals(formato, fakeRegistroInscripcion.contenido());

		Assert.assertEquals("Inscripción", fakeNotificarParticipante.contenido());
	}

	@Test
	public void participanteIntentaInscribirseFueraDeTermino() {
		Concurso concurso = new Concurso("Concurso", LocalDate.now().plusDays(1), LocalDate.now().plusDays(10),
				fakeRegistroInscripcion, fakeNotificarParticipante);
		Participante participante = new Participante("Agustin");
		try {
			concurso.inscribirParticipante(participante);
			fail("Participante se inscribio fuera de termino");
			Assert.assertEquals("", fakeRegistroInscripcion.contenido());

			Assert.assertEquals("", fakeNotificarParticipante.contenido());
		} catch (RuntimeException e) {
			e.getMessage();
		}
	}
}
