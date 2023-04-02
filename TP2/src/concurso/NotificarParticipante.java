package concurso;

public interface NotificarParticipante {

	void enviarCorreo(String asunto, String mensaje, String remitente, String destinatario);

}
