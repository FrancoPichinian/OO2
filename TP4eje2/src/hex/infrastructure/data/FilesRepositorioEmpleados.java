package hex.infrastructure.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import hex.domain.portsout.EmpleadosException;
import hex.domain.portsout.RepositorioEmpleados;

public class FilesRepositorioEmpleados implements RepositorioEmpleados {

	private String path;
	private static final String MSG = "No se pudo leer el archivo";

	public FilesRepositorioEmpleados(String path) {
		this.path = Objects.requireNonNull(path);
	}

	public List<String[]> obtenerEmpleados() {
		List<String[]> listaEmpleados = new ArrayList<String[]>();
		try {
			List<String> lineasArchivo = Files.readAllLines(Paths.get(this.path));
			lineasArchivo.forEach(linea -> listaEmpleados.add(linea.split(", ")));
		} catch (IOException e) {
			throw new EmpleadosException(e, MSG);
		}
		return listaEmpleados;
	}
}
