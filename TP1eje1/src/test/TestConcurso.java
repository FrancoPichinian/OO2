package test;

import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import modelo.Concurso;
import modelo.Participante;

public class TestConcurso {

	@Test
	public void participanteSeInscribeEnConcurso() {
		// Inicializacion
		Concurso concurso = new Concurso(LocalDate.now().minusDays(1), LocalDate.now().plusDays(10));
		Participante participante = new Participante();
		// Ejercitacion
		concurso.inscribirParticipante(participante);
		// Verificacion
		Assert.assertTrue(concurso.estaInscripto(participante));
	}

	@Test
	public void participanteSeInscribeElPrimerDia() {
		Concurso concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(10));
		Participante participante = new Participante();
		concurso.inscribirParticipante(participante);
		Assert.assertEquals(participante.cantidadTotalPuntos(), 10);
	}

	@Test
	public void participanteIntentaInscribirseFueraDeTermino() {
		Concurso concurso = new Concurso(LocalDate.now().plusDays(1), LocalDate.now().plusDays(10));
		Participante participante = new Participante();
		try {
			concurso.inscribirParticipante(participante);
			fail("Participante se inscribio fuera de termino");
		} catch (RuntimeException re) {

		}
	}
}
