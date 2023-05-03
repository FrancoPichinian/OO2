package eje1;

import java.util.List;
import java.util.Objects;

public class EmpleadoConGenteACargo extends Empleado {

	private Double salario;
	private List<Empleado> empleados;

	public EmpleadoConGenteACargo(Double salario, List<Empleado> listaEmpleados) {
		this.salario = Objects.requireNonNull(salario);
		this.empleados = Objects.requireNonNull(listaEmpleados);
	}

	@Override
	protected Double calcularSalario() {
		return salario += this.empleados.stream().mapToDouble(e -> e.calcularSalario()).sum();
	}
}
