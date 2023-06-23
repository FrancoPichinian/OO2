package pichiñan.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.IntStream;

public class Menu {
	private String pathConfig;
	private List<Accion> acciones;
	private static final String MSG = "Se produjo un error al instanciar una clase del config";

	public Menu(String pathConfig) {
		this.pathConfig = Objects.requireNonNull(pathConfig);
		this.acciones = new ArrayList<>();
		this.acciones = leerAccionesDelProperties();
	}

	public void run() {
		imprimirMenu();
	}

	private List<Accion> leerAccionesDelProperties() {
		Properties prop = new Properties();
		ArrayList<Accion> listaDeAcciones = new ArrayList<>();
		try (InputStream configFile = getClass().getResourceAsStream(this.pathConfig);) {
			prop.load(configFile);
			String clase = prop.getProperty("acciones");
			String[] clases = clase.split(";");

			for (int i = 0; i < clases.length; i++) {
				Accion accionTemp = (Accion) Class.forName(clases[i]).getDeclaredConstructor().newInstance();
				listaDeAcciones.add(accionTemp);
			}
		} catch (Exception e) {
			throw new RuntimeException(MSG);
		}
		return listaDeAcciones;
	}

	private void imprimirMenu() {
		System.out.println("\nBienvenido, estas son sus opciones: ");

		IntStream.range(0, acciones.size()).mapToObj(i -> (i + 1) + ". " + acciones.get(i).nombreItemMenu() + " ("
				+ acciones.get(i).descripcionItemMenu() + ")").forEach(System.out::println);

		System.out.println("3. Salir");
		System.out.println("Ingrese su opcion: ");
		leerAccionDeConsola();
	}

	private void leerAccionDeConsola() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String opcion;
		try {
			opcion = reader.readLine();
			if (!opcion.equals("3")) {
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
