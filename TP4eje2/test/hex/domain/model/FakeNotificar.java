package hex.domain.model;

import hex.domain.portsout.Notificar;

public class FakeNotificar implements Notificar {

	private String contenido = "";

	@Override
	public void enviarCorreo(String asunto, String mensaje, String remitente, String destinatario) {
		this.contenido = asunto;
	}

	public String contenido() {
		return this.contenido;
	}
}
