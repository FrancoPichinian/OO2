package eje1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TestEmpresa {

	private Empleado empleadoRegular1 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular2 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular3 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular4 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular5 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular6 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular7 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular8 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular9 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular10 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular11 = new EmpleadoRegular(2000.0);
	private Empleado empleadoRegular12 = new EmpleadoRegular(2000.0);

	@Test
	public void calcularMontoSalarial() {

		Empleado liderProyecto1 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular1, empleadoRegular2));
		Empleado liderProyecto2 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular3, empleadoRegular4));
		Empleado liderProyecto3 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular5, empleadoRegular6));
		Empleado liderProyecto4 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular7, empleadoRegular8));

		Empleado mandoMedio1 = new EmpleadoConGenteACargo(5000.0, List.of(liderProyecto1, liderProyecto2));
		Empleado mandoMedio2 = new EmpleadoConGenteACargo(5000.0, List.of(liderProyecto3, liderProyecto4));

		Empleado gerente1 = new EmpleadoConGenteACargo(7000.0, List.of(mandoMedio1));
		Empleado gerente2 = new EmpleadoConGenteACargo(7000.0, List.of(mandoMedio2));

		Empleado director = new EmpleadoConGenteACargo(10000.0, List.of(gerente1, gerente2));

		assertEquals(62000.0, director.calcularSalario(), 0);
	}

	@Test
	public void calcularMontoSalarialSegundoCaso() {
		Empleado liderProyecto1 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular1, empleadoRegular2));
		Empleado liderProyecto2 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular3, empleadoRegular4));
		Empleado liderProyecto3 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular5, empleadoRegular6));
		Empleado liderProyecto4 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular7, empleadoRegular8));
		Empleado liderProyecto5 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular9, empleadoRegular10));
		Empleado liderProyecto6 = new EmpleadoConGenteACargo(3000.0, List.of(empleadoRegular11, empleadoRegular12));

		Empleado mandoMedio1 = new EmpleadoConGenteACargo(5000.0, List.of(liderProyecto1, liderProyecto2));
		Empleado mandoMedio2 = new EmpleadoConGenteACargo(5000.0, List.of(liderProyecto3, liderProyecto4));
		Empleado mandoMedio3 = new EmpleadoConGenteACargo(5000.0, List.of(liderProyecto5, liderProyecto6));

		Empleado gerente1 = new EmpleadoConGenteACargo(7000.0, List.of(mandoMedio1));
		Empleado gerente2 = new EmpleadoConGenteACargo(7000.0, List.of(mandoMedio2, mandoMedio3));

		Empleado director = new EmpleadoConGenteACargo(10000.0, List.of(gerente1, gerente2));

		assertEquals(81000.0, director.calcularSalario(), 0);
	}
}
