package eje3;

public class GastoAlquilerAuto extends Gasto {

	public GastoAlquilerAuto(int monto) {
		super(monto);
	}

	@Override
	public String nombre() {
		return "Alquiler de Autos";
	}

	@Override
	public int sumaMontoComida(int monto) {
		return monto;
	}

	@Override
	public boolean verificarExceso() {
		return false;
	}
}
