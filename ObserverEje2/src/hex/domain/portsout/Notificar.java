package hex.domain.portsout;

public interface Notificar {

	void enviarCorreo(String asunto, String mensaje, String remitente, String destinatario);

}
