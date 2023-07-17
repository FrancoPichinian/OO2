package hex.main;

import hex.domain.model.DefaultVentaService;
import hex.infrastructure.data.FilesRepositorioVentas;
import hex.infrastructure.ui.CargaCombustible;

public class MainFile {

	private static final String PATH = "C:\\Users\\CX\\eclipse-workspace\\Examen\\registroDeVentas.txt";
	private static final String DELIMITER = "| ";

	public static void main(String[] args) {
		CargaCombustible ui = new CargaCombustible(
				new DefaultVentaService(new FilesRepositorioVentas(PATH, DELIMITER), null));
	}
}
