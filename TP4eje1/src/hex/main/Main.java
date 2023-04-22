package hex.main;

import java.awt.EventQueue;
import java.sql.SQLException;

import hex.domain.model.DefaultParticipanteService;
import hex.infrastructure.data.Conn;
import hex.infrastructure.data.JdbcParticipante;
import hex.infrastructure.ui.AgregarParticipante;

public class Main {

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AgregarParticipante(new DefaultParticipanteService(new JdbcParticipante(new Conn())));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
