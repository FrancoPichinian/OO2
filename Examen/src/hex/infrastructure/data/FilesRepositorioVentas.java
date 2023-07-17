package hex.infrastructure.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import hex.domain.portsout.InfrastructureException;
import hex.domain.portsout.RepositorioVentas;

public class FilesRepositorioVentas implements RepositorioVentas {

	private String path;
	private String delimiter;
	private static final String MSG = "No se pudo registrar la venta...";

	public FilesRepositorioVentas(String path, String delimiter) {
		this.path = Objects.requireNonNull(path);
		this.delimiter = Objects.requireNonNull(delimiter);
	}

	@Override
	public void persistir(LocalDate fecha, double litros, double montoTotal) {
		try {
			StringJoiner joiner = new StringJoiner(delimiter);
			joiner.add("Fecha:" + fecha.toString()).add("Litros:" + litros).add("Monto total:" + montoTotal);
			String contenido = joiner.toString() + System.lineSeparator();
			Files.write(Paths.get(path), contenido.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new InfrastructureException(e, MSG);
		}
	}
}
