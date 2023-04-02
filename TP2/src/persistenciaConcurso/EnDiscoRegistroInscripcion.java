package persistenciaConcurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import concurso.RegistroInscripcion;

public class EnDiscoRegistroInscripcion implements RegistroInscripcion {

	private String path;

	public EnDiscoRegistroInscripcion(String path) {
		this.path = Objects.requireNonNull(path);
	}

	@Override
	public void registrar(String registro) {
		try {
			Files.write(Paths.get(path), registro.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}
	}
}
