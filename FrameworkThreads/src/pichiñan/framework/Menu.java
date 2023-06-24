package pichiñan.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Menu {
	private String pathConfig;
	private List<Accion> acciones;
	private int maxThreads;
	private static final String MSG = "Se produjo un error al instanciar una clase del config";

	public Menu(String pathConfig) {
		this.pathConfig = Objects.requireNonNull(pathConfig);
		this.acciones = new ArrayList<>();
		this.acciones = leerAccionesDelArchivoConfig();
		this.maxThreads = 1;
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
			if (jsonObject.has("max-threads")) {
				this.maxThreads = jsonObject.get("max-threads").getAsInt();
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
		System.out.println("Ingrese su opcion (separada por comas para seleccionar varias opciones): ");
		leerAccionesDeConsola();
	}

	private void leerAccionesDeConsola() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String opciones;
		try {
			opciones = reader.readLine();
			if (!opciones.equals(String.valueOf(acciones.size() + 1))) {
				List<Integer> seleccionadas = Arrays.stream(opciones.split(",")).map(String::trim)
						.map(Integer::parseInt).collect(Collectors.toList());
				List<Accion> tareasSeleccionadas = seleccionadas.stream().map(i -> acciones.get(i - 1))
						.collect(Collectors.toList());
				ejecutarAccionesConcurrentemente(tareasSeleccionadas);
				imprimirMenu();
			} else {
				System.out.println("Finalizando...!!!");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void ejecutarAccionesConcurrentemente(List<Accion> acciones) {
		ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
		List<Future<?>> futures = new ArrayList<>();
		for (Accion accion : acciones) {
			Future<?> future = executor.submit(accion::ejecutar);
			futures.add(future);
		}
		for (Future<?> future : futures) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
		}
		executor.shutdown();
	}
}