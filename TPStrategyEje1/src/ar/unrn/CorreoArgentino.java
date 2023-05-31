package ar.unrn;

public class CorreoArgentino implements FormaEnvio {

	@Override
	public double costoDeEnvio(Compra compra) {
		double costoEnvio = 0.0;

		if (esCapitalFederal(compra.destino()))
			costoEnvio = 500.0;
		else {
			int distancia = obtenerDistancia("Capital Federal", compra.destino());
			costoEnvio = 800.0 + (5.0 * distancia);
		}
		return costoEnvio;
	}

	private boolean esCapitalFederal(String destino) {
		return destino.equalsIgnoreCase("Capital Federal");
	}

	private int obtenerDistancia(String origen, String destino) {
		return 100;
	}
}
