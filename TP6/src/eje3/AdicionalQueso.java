package eje3;

import java.util.Objects;

public class AdicionalQueso implements Combo {
	private Combo combo;

	public AdicionalQueso(Combo combo) {
		this.combo = Objects.requireNonNull(combo);
	}

	@Override
	public float precio() {
		return combo.precio() + 200;
	}

	@Override
	public String descripcion() {
		return this.combo.descripcion() + " + Adicional de queso, precio: 200";
	}
}