package hex.infrastructure.mail;

import java.util.Objects;
import java.util.Properties;

import hex.domain.portsout.EmpleadosException;
import hex.domain.portsout.Notificar;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailTrapNotificar implements Notificar {

	private String username;
	private String password;
	private String host;
	private int port;
	private static final String MSG = "No se pudo enviar el correo...";

	public MailTrapNotificar(String username, String password, String host, int port) {
		this.username = Objects.requireNonNull(username);
		this.password = Objects.requireNonNull(password);
		this.host = Objects.requireNonNull(host);
		this.port = port;
	}

	public void enviarCorreo(String asunto, String mensaje, String remitente, String destinatario) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message email = new MimeMessage(session);
			email.setFrom(new InternetAddress(remitente));
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			email.setSubject(asunto);
			email.setText(mensaje);
			Transport.send(email);
		} catch (MessagingException e) {
			throw new EmpleadosException(e, MSG);
		}
	}
}
