package eje1;

import java.util.List;
import java.util.Objects;

//Observable es a quien estoy observando
public class Medidor extends Observable {
	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima, List<Observer> observadores) {
		super(observadores);
		this.clima = Objects.requireNonNull(clima);
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		this.notificar(this.temperatura);
		return this.temperatura;
	}
}
