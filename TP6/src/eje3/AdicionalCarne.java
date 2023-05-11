package eje3;

import java.util.Objects;

public class AdicionalCarne implements Combo {

	private Combo combo;

	public AdicionalCarne(Combo combo) {
		this.combo = Objects.requireNonNull(combo);
	}

	@Override
	public float precio() {
		return combo.precio() + 300;
	}

	@Override
	public String descripcion() {
		return this.combo.descripcion() + " + Adicional de carne, precio: 300";
	}
}
