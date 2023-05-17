package hex.infrastructure.ui;

import java.util.Objects;

import hex.domain.model.Observer;
import hex.domain.portsout.Notificar;

public class EmailAParticipante implements Observer {

	private Notificar notificador;
	private static final String ASUNTO = "Nuevo participante";
	private static final String MENSAJE = "¡Gracias por registrarte en nuestro evento!";
	private static final String REMITENTE = "from@example.com";

	public EmailAParticipante(Notificar notificador) {
		this.notificador = Objects.requireNonNull(notificador);
	}

	@Override
	public void actualizar(String email) {
		notificador.enviarCorreo(ASUNTO, MENSAJE, REMITENTE, email);
	}
}
