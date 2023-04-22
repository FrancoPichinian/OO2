package hex.main;

import javax.swing.SwingUtilities;

import hex.domain.model.DefaultConcursoService;
import hex.domain.model.DefaultInscriptoService;
import hex.infrastructure.data.Conn;
import hex.infrastructure.data.JdbcRepositorioConcursos;
import hex.infrastructure.data.JdbcRepositorioInscriptos;
import hex.infrastructure.ui.RadioCompetition;

public class MainEnBD {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					new MainEnBD().start();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

	private void start() {
		new RadioCompetition(new DefaultConcursoService(new JdbcRepositorioConcursos(new Conn())),
				new DefaultInscriptoService(new JdbcRepositorioInscriptos(new Conn())));
	}
}
