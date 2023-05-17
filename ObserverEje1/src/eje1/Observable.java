package eje1;

import java.util.List;
import java.util.Objects;

public abstract class Observable {
	private List<Observer> observadores;

	public Observable(List<Observer> observadores) {
		this.observadores = Objects.requireNonNull(observadores);
	}

	protected void notificar(String temperatura) {
		for (Observer o : observadores)
			o.actualizar(temperatura);
	}
}
