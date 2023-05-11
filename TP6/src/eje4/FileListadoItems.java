package eje4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class FileListadoItems implements ListadoItems {

	private ListadoItems listador;
	private String path;

	public FileListadoItems(ListadoItems listador, String path) {
		this.listador = Objects.requireNonNull(listador);
		this.path = Objects.requireNonNull(path);
	}

	@Override
	public String obtenerListado() {
		try {
			Files.write(Paths.get(path), listador.obtenerListado().getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}
		return listador.obtenerListado();
	}
}
