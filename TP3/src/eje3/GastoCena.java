package eje3;

public class GastoCena extends Gasto {

	private static final int MONTO_LIMITE = 5000;

	public GastoCena(int monto) {
		super(monto);
	}

	@Override
	public String nombre() {
		return "Cena";
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
