package eje1;

import java.util.Objects;

public class EmpleadoRegular extends Empleado {

	private Double salario;

	public EmpleadoRegular(Double salario) {
		this.salario = Objects.requireNonNull(salario);
	}

	@Override
	protected Double calcularSalario() {
		return this.salario;
	}
}