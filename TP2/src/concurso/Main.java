package concurso;

import java.time.LocalDate;

import persistenciaConcurso.EmailNotificarParticipante;
import persistenciaConcurso.JdbcRegistroInscripcion;
import persistenciaConcurso.EnDiscoRegistroInscripcion;

public class Main {

	public static void main(String[] args) {
		RegistroInscripcion registroArchivo = new EnDiscoRegistroInscripcion("C:\\Users\\CX\\ArchivosOO2\\tp2eje1.txt");
		EmailNotificarParticipante email = new EmailNotificarParticipante("73e57dd705c620", "25797e4dced79d",
				"sandbox.smtp.mailtrap.io", 2525);

		Concurso concurso = new Concurso("Concurso", LocalDate.now().minusDays(1), LocalDate.now().plusDays(10),
				registroArchivo, email);
		Participante participante = new Participante("Juan");
		concurso.inscribirParticipante(participante);

		RegistroInscripcion registroBD = new JdbcRegistroInscripcion();
		Concurso concursoo = new Concurso("Concurso", LocalDate.now().minusDays(1), LocalDate.now().plusDays(10),
				registroBD, email);
		Participante participantee = new Participante("Juan");
		concursoo.inscribirParticipante(participantee);
	}
}
