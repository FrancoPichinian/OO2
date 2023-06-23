package pichiñan.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Menu {
	private String pathConfig;
	private List<Accion> acciones;
	private static final String MSG = "Se produjo un error al instanciar una clase del config";

	public Menu(String pathConfig) {
		this.pathConfig = Objects.requireNonNull(pathConfig);
		this.acciones = new ArrayList<>();
		this.acciones = leerAccionesDelArchivoConfig();
	}

	public void run() {
		imprimirMenu();
	}

	private List<Accion> leerAccionesDelArchivoConfig() {
		String configJson = leerArchivoConfigComoString();
		JsonObject jsonObject = new Gson().fromJson(configJson, JsonObject.class);
		JsonArray accionesArray = jsonObject.getAsJsonArray("acciones");

		List<Accion> listaDeAcciones = new ArrayList<>();

		try {
			for (JsonElement accionElement : accionesArray) {
				String accionClassName = accionElement.getAsString();
				Class<? extends Accion> accionClass = (Class<? extends Accion>) Class.forName(accionClassName);
				Accion accion = accionClass.getDeclaredConstructor().newInstance();
				listaDeAcciones.add(accion);
			}
		} catch (Exception e) {
			throw new RuntimeException(MSG + "\n" + e.getMessage());
		}

		return listaDeAcciones;
	}

	private String leerArchivoConfigComoString() {
		StringBuilder sb = new StringBuilder();
		try (InputStream configFile = getClass().getResourceAsStream(this.pathConfig);
				BufferedReader reader = new BufferedReader(new InputStreamReader(configFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(MSG);
		}
		return sb.toString();
	}

	private void imprimirMenu() {
		System.out.println("\nBienvenido, estas son sus opciones: ");

		IntStream.range(0, acciones.size()).mapToObj(i -> (i + 1) + ". " + acciones.get(i).nombreItemMenu() + " ("
				+ acciones.get(i).descripcionItemMenu() + ")").forEach(System.out::println);

		System.out.println((acciones.size() + 1) + ". Salir");
		System.out.println("Ingrese su opcion: ");
		leerAccionDeConsola();
	}

	private void leerAccionDeConsola() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String opcion;
		try {
			opcion = reader.readLine();
			if (!opcion.equals(String.valueOf(acciones.size() + 1))) {
				try {
					this.acciones.get(Integer.valueOf(opcion) - 1).ejecutar();
					imprimirMenu();
				} catch (Exception e) {
					System.out.println("Por Favor, Ingrese una opcion valida");
					imprimirMenu();
				}
			} else
				System.out.println("Finalizando...!!!");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}