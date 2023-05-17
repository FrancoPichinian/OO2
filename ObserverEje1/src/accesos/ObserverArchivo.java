package accesos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Objects;

import eje1.Observer;

public class ObserverArchivo implements Observer {

	private String path;

	public ObserverArchivo(String path) {
		this.path = Objects.requireNonNull(path);
	}

	@Override
	public void actualizar(String temperatura) {
		try {
			String contenido = "Temperatura: " + Double.valueOf(temperatura).intValue() + "° Fecha: " + LocalDate.now()
					+ System.lineSeparator();
			Files.write(Paths.get(path), contenido.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
