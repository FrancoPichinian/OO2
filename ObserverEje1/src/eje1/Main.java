package eje1;

import java.util.List;

import accesos.ObserverArchivo;
import accesos.ObserverConsola;

public class Main {

	private static final String API_KEY = "8b52d3671b3d18440fe95365c2e6b289";
	private static final String PATH = "C:\\Users\\CX\\eclipse-workspace\\ObserverEje1\\registroTemperaturas.txt";

	public static void main(String[] args) {
		ClimaOnline clima = new WeatherChannelService(API_KEY);
		System.out.println(Double.valueOf(clima.temperatura()).intValue());

		ObserverConsola observerConsola = new ObserverConsola();
		ObserverArchivo observerArchivo = new ObserverArchivo(PATH);
		Medidor medidor = new Medidor(clima, List.of(observerConsola, observerArchivo));
		medidor.leerTemperatura();
	}
}
