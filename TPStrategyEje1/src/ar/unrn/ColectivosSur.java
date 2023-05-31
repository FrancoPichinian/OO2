package ar.unrn;

public class ColectivosSur implements FormaEnvio {

	@Override
	public double costoDeEnvio(Compra compra) {
		double pesoTotal = compra.pesoTotal();
		double costoEnvio = 0.0;

		if (esCapitalFederal(compra.destino()))
			costoEnvio = 1000.0;
		else if (esBuenosAires(compra.destino())) {
			costoEnvio = 1500.0;
		} else
			costoEnvio = 3000.0;

		if (pesoTotal > 5 && pesoTotal <= 30)
			costoEnvio += 500.0;
		if (pesoTotal > 30)
			costoEnvio += 2000.0;
		return costoEnvio;
	}

	private boolean esCapitalFederal(String destino) {
		return destino.equalsIgnoreCase("Capital Federal");
	}

	private boolean esBuenosAires(String destino) {
		return destino.equalsIgnoreCase("Gran Buenos Aires");
	}
}
