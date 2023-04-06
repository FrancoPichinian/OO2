package restaurante;

import persistenciaRestaurante.EnDiscoRegistroPago;
import persistenciaRestaurante.JdbcRegistroPago;

public class Main {

	public static void main(String[] args) {
		RegistroPago registroArchivo = new EnDiscoRegistroPago("C:\\Users\\CX\\ArchivosOO2\\tp2eje2.txt");
		DispositivoElectronico dispositivo = new DispositivoElectronico(registroArchivo);
		Plato asado = new Plato("asado", 1000);
		Bebida agua = new Bebida("agua", 250);
		dispositivo.agregarOrden(asado, 1);
		dispositivo.agregarOrden(agua, 1);
		dispositivo.confimarPedido();
		dispositivo.pagar(new TarjetaCreditoVisa(), 0.02);

		RegistroPago registroBD = new JdbcRegistroPago();
		DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registroBD);
		Plato tallarines = new Plato("asado", 800);
		Bebida gaseosa = new Bebida("agua", 300);
		dispositivoElectronico.agregarOrden(tallarines, 1);
		dispositivoElectronico.agregarOrden(gaseosa, 1);
		dispositivoElectronico.confimarPedido();
		dispositivoElectronico.pagar(new TarjetaCreditoVisa(), 0.02);
	}
}
