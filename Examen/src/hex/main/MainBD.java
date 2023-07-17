package hex.main;

import hex.domain.model.DefaultVentaService;
import hex.infrastructure.data.Conn;
import hex.infrastructure.data.JdbcRepositorioVentas;
import hex.infrastructure.ui.CargaCombustible;

public class MainBD {

	public static void main(String[] args) {
		CargaCombustible ui = new CargaCombustible(
				new DefaultVentaService(new JdbcRepositorioVentas(new Conn()), null));
	}
}
