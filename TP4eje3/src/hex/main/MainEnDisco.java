package hex.main;

import javax.swing.SwingUtilities;

import hex.domain.model.DefaultConcursoService;
import hex.domain.model.DefaultInscriptoService;
import hex.infrastructure.data.EnDiscoRepositorioInscriptos;
import hex.infrastructure.data.FilesRepositorioConcursos;
import hex.infrastructure.ui.RadioCompetition;

public class MainEnDisco {

	private static final String PATH_CONCURSOS = "C:\\Users\\CX\\eclipse-workspace\\TP4eje3\\concursos.txt";
	private static final String PATH_INSCRIPTOS = "C:\\Users\\CX\\eclipse-workspace\\TP4eje3\\inscriptos.txt";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					new MainEnDisco().start();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

	private void start() {
		new RadioCompetition(new DefaultConcursoService(new FilesRepositorioConcursos(PATH_CONCURSOS)),
				new DefaultInscriptoService(new EnDiscoRepositorioInscriptos(PATH_INSCRIPTOS)));
	}
}
