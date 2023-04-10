package eje2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Recaudacion {

	private FuenteDeDatos datos;
	private static final String COMPANY = "company_name";
	private static final String CITY = "city";
	private static final String STATE = "state";
	private static final String ROUND = "round";

	public Recaudacion(FuenteDeDatos datos) {
		this.datos = Objects.requireNonNull(datos);
	}

	public List<Map<String, String>> where(Map<String, String> options) throws IOException {
		List<String[]> data = datos.consumirDatos();

		if (options.containsKey(COMPANY))
			data = obtenerDatos(options, data,
					(csvData, i, opcionesMap) -> (csvData.get(i)[1].equals(options.get(COMPANY))));

		if (options.containsKey(CITY))
			data = obtenerDatos(options, data,
					(csvData, i, opcionesMap) -> (csvData.get(i)[4].equals(options.get(CITY))));

		if (options.containsKey(STATE))
			data = obtenerDatos(options, data,
					(csvData, i, opcionesMap) -> (csvData.get(i)[5].equals(options.get(STATE))));

		if (options.containsKey(ROUND))
			data = obtenerDatos(options, data,
					(csvData, i, opcionesMap) -> (csvData.get(i)[9].equals(options.get(ROUND))));

		return this.salida(data);
	}

	private List<String[]> obtenerDatos(Map<String, String> options, List<String[]> csvData, Condicion c) {
		return csvData.stream().filter(data -> c.esIgual(csvData, csvData.indexOf(data), options))
				.collect(Collectors.toList());
	}

	private Map<String, String> mapearFila(String[] fila) {
		Map<String, String> mapped = new HashMap<>();
		mapped.put("permalink", fila[0]);
		mapped.put("company_name", fila[1]);
		mapped.put("number_employees", fila[2]);
		mapped.put("category", fila[3]);
		mapped.put("city", fila[4]);
		mapped.put("state", fila[5]);
		mapped.put("funded_date", fila[6]);
		mapped.put("raised_amount", fila[7]);
		mapped.put("raised_currency", fila[8]);
		mapped.put("round", fila[9]);
		return mapped;
	}

	public List<Map<String, String>> salida(List<String[]> data) {
		List<Map<String, String>> output = new ArrayList<>();
		data.forEach(fila -> {
			Map<String, String> mapped = mapearFila(fila);
			output.add(mapped);
		});
		return output;
	}
}
