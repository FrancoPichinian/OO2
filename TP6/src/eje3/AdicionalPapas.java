package eje3;

import java.util.Objects;

public class AdicionalPapas implements Combo {

	private Combo combo;

	public AdicionalPapas(Combo combo) {
		this.combo = Objects.requireNonNull(combo);
	}

	@Override
	public float precio() {
		return combo.precio() + 150;
	}

	@Override
	public String descripcion() {
		return this.combo.descripcion() + " + Adicional de papas, precio: 150";
	}
}
