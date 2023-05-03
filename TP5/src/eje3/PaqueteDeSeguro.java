package eje3;

import java.util.List;
import java.util.Objects;

public class PaqueteDeSeguro extends Seguro {

	private List<Seguro> seguros;
	private static final double DESCUENTO = 0.05;

	public PaqueteDeSeguro(List<Seguro> listaSeguros) {
		this.seguros = Objects.requireNonNull(listaSeguros);
	}

	@Override
	protected Double calcularMonto() {
		Double monto = seguros.stream().mapToDouble(s -> s.calcularMonto()).sum();
		return monto -= monto * (DESCUENTO * seguros.size());
	}
}
