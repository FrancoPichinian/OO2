package hex.infrastructure.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import hex.domain.portsin.InscriptoRecord;
import hex.domain.portsout.InfrastructureException;
import hex.domain.portsout.RepositorioInscriptos;

public class EnDiscoRepositorioInscriptos implements RepositorioInscriptos {

	private String path;
	private static final String DELIMITER = ", ";
	private static final String MSG = "No se pudo escribir en el archivo";

	public EnDiscoRepositorioInscriptos(String path) {
		this.path = Objects.requireNonNull(path);
	}

	@Override
	public void nuevoInscripto(InscriptoRecord record) {
		String[] campos = { record.nombre(), record.apellido(), record.dni(), record.telefono(), record.email(),
				record.concurso() };
		String registro = String.join(DELIMITER, campos);
		try {
			Files.write(Paths.get(path), (registro + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new InfrastructureException(e, MSG);
		}
	}
}
