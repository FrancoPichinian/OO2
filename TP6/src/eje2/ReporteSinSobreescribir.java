package eje2;

import java.io.File;
import java.util.Objects;

public class ReporteSinSobreescribir implements Reporte {

	private Reporte reporte;

	public ReporteSinSobreescribir(Reporte reporte) {
		this.reporte = Objects.requireNonNull(reporte);
	}

	@Override
	public void export(File file) {
		if (file.exists())
			throw new RuntimeException("El archivo ya existe...");
		reporte.export(file);
	}
}
