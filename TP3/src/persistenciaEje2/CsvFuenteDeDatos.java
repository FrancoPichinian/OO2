package persistenciaEje2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.opencsv.CSVReader;

import eje2.FuenteDeDatos;

public class CsvFuenteDeDatos implements FuenteDeDatos {

	private String archivo;

	public CsvFuenteDeDatos(String archivo) {
		this.archivo = Objects.requireNonNull(archivo);
	}

	@Override
	public List<String[]> consumirDatos() throws IOException {
		List<String[]> csvData = new ArrayList<String[]>();
		CSVReader reader = new CSVReader(new FileReader(archivo));
		String[] row = null;
		while ((row = reader.readNext()) != null)
			csvData.add(row);
		return csvData;
	}
}
