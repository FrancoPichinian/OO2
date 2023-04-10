package eje3;

public class GastoDesayuno extends Gasto {

	private static final int MONTO_LIMITE = 1000;

	public GastoDesayuno(int monto) {
		super(monto);
	}

	@Override
	public String nombre() {
		return "Desayuno";
	}

	@Override
	public int sumaMontoComida(int monto) {
		return this.monto() + monto;
	}

	@Override
	public boolean verificarExceso() {
		return this.monto() > MONTO_LIMITE ? true : false;
	}
}
