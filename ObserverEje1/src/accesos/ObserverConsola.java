package accesos;

import eje1.Observer;

public class ObserverConsola implements Observer {

	@Override
	public void actualizar(String temperatura) {
		int temperaturaValor = Double.valueOf(temperatura).intValue();
		if (temperaturaValor < 12)
			System.out.println("Hace frio, se encendera la Caldera");
		if (temperaturaValor > 17)
			System.out.println("Hace calor, se encenderá el aire acondicionado");
	}
}
