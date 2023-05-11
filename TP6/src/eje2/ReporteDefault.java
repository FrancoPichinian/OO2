package eje2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class ReporteDefault implements Reporte {
	private String reporte;

	public ReporteDefault(String reporte) {
		this.reporte = Objects.requireNonNull(reporte);
	}

	public void export(File file) {
		if (file == null)
			throw new IllegalArgumentException("File es NULL; no puedo exportar...");
		// Exportar el reporte a un archivo.
		try {
			Files.write(file.toPath(), reporte.getBytes());
		} catch (IOException e) {
			throw new RuntimeException("No se puede exportar..." + e.getMessage());
		}
	}
}
