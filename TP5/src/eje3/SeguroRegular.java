package eje3;

import java.util.Objects;

public class SeguroRegular extends Seguro {

	private Double monto;

	public SeguroRegular(Double monto) {
		this.monto = Objects.requireNonNull(monto);
	}

	@Override
	protected Double calcularMonto() {
		return monto;
	}
}
