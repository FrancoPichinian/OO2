package persistenciaRestaurante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import restaurante.RegistroPago;

public class EnDiscoRegistroPago implements RegistroPago {

	private String path;

	public EnDiscoRegistroPago(String path) {
		this.path = Objects.requireNonNull(path);
	}

	@Override
	public void registrarPago(String registro) {
		try {
			Files.write(Paths.get(path), registro.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir", e);
		}
	}
}
