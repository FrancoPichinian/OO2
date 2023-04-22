package hex.infrastructure.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import hex.domain.portsout.InfrastructureException;
import hex.domain.portsout.RepositorioConcursos;

public class FilesRepositorioConcursos implements RepositorioConcursos {

	private String path;
	private static final String MSG = "No se pudo leer el archivo";

	public FilesRepositorioConcursos(String path) {
		this.path = Objects.requireNonNull(path);
	}

	@Override
	public List<String[]> todosLosConcursos() {
		List<String[]> listaConcursos = new ArrayList<>();
		try {
			List<String> lineasArchivo = Files.readAllLines(Paths.get(path));
			lineasArchivo.forEach(linea -> listaConcursos.add(linea.split(", ")));
		} catch (IOException e) {
			throw new InfrastructureException(e, MSG);
		}
		return listaConcursos;
	}
}
