package eje5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Negocio {
	private String nombre;
	private List<Remera> remeras;

	public Negocio(String nombre) {
		this.nombre = Objects.requireNonNull(nombre);
		remeras = new ArrayList<>();
	}

	public void agregarRemera(Remera remera) {
		remeras.add(Objects.requireNonNull(remera));
	}
}
