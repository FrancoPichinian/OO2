package eje3;

import java.util.Objects;

public class AdicionalTomate implements Combo {

	private Combo combo;

	AdicionalTomate(Combo combo) {
		this.combo = Objects.requireNonNull(combo);
	}

	@Override
	public float precio() {
		return combo.precio() + 150;
	}

	@Override
	public String descripcion() {
		return this.combo.descripcion() + " + Adicional de tomates, precio: 150";
	}
}
