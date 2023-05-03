package eje2;

import java.util.List;
import java.util.Objects;

public class Proyecto {
	private List<Item> items;

	public Proyecto(List<Item> items) {
		this.items = Objects.requireNonNull(items);
	}

	public int obtenerHorasTotales() {
		return this.items.stream().mapToInt(Item::calcularTiempo).sum();
	}
}
