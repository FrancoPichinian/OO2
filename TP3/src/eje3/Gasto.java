package eje3;

public abstract class Gasto {

	private int monto;

	public Gasto(int monto) {
		this.monto = monto;
	}

	public abstract String nombre();

	public abstract int sumaMontoComida(int monto);

	public abstract boolean verificarExceso();

	public int monto() {
		return this.monto;
	}
}
