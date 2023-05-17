package hex.main;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import hex.domain.model.DefaultParticipanteService;
import hex.domain.portsin.ParticipanteService;
import hex.infrastructure.data.Conn;
import hex.infrastructure.data.JdbcParticipante;
import hex.infrastructure.mail.MailTrapNotificar;
import hex.infrastructure.ui.AgregarParticipante;
import hex.infrastructure.ui.EmailAParticipante;

public class Main {

	private static final String USER = "73e57dd705c620";
	private static final String PASS = "25797e4dced79d";
	private static final String HOST = "sandbox.smtp.mailtrap.io";

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailAParticipante emailAParticipante = new EmailAParticipante(
							new MailTrapNotificar(USER, PASS, HOST, 2525));
					ParticipanteService participanteService = new DefaultParticipanteService(
							new JdbcParticipante(new Conn()), List.of(emailAParticipante));
					new AgregarParticipante(participanteService);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
