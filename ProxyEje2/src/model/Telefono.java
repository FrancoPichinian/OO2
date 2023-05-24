package model;

import java.util.Objects;

public class Telefono {
	private String numero;

	public Telefono(String numero) {
		this.numero = Objects.requireNonNull(numero);
	}

	public String numero() {
		return numero;
	}

	@Override
	public String toString() {
		return numero;
	}
}
