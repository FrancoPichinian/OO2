package eje2;

import java.util.List;
import java.util.Objects;

public class HistoriaUsuario extends Item {

	private List<Item> tareas;

	public HistoriaUsuario(List<Item> tareas) {
		this.tareas = Objects.requireNonNull(tareas);
	}

	@Override
	protected int calcularTiempo() {
		return this.tareas.stream().mapToInt(Item::calcularTiempo).sum();
	}
}
