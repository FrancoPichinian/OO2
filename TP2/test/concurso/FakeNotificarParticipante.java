package concurso;

public class FakeNotificarParticipante implements NotificarParticipante {

	private String contenido;

	@Override
	public void enviarCorreo(String asunto, String mensaje, String remitente, String destinatario) {
		this.contenido = asunto;
	}

	public String contenido() {
		return this.contenido;
	}
}
