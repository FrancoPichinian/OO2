package eje1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cliente {
	private String name;
	private List<Alquiler> alquileres;

	public Cliente(String nombre) {
		// Programacion defensiva
		this.name = Objects.requireNonNull(nombre);
		alquileres = new ArrayList<>();
	}

	public Object[] calcularDeudaYPuntosObtenidos() {
		// Regla1 (Un solo nivel de identacion por metodo)
		Object[] resultado = new Object[2];
		resultado[0] = this.alquileres.stream().collect(Collectors.summingDouble(a -> a.calcularMonto()));
		resultado[1] = this.alquileres.stream().collect(Collectors.summingInt(a -> a.calcularPuntosFrecuentes()));
		return resultado;
	}

	public void alquilar(Alquiler rental) {
		alquileres.add(rental);
	}
}