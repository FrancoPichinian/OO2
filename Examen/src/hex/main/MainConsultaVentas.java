package hex.main;

import hex.domain.model.DefaultVentaService;
import hex.infrastructure.data.Conn;
import hex.infrastructure.data.JdbcAlmacenamientoVentas;
import hex.infrastructure.ui.ConsultaVentas;

public class MainConsultaVentas {

	public static void main(String[] args) {
		ConsultaVentas frame = new ConsultaVentas(
				new DefaultVentaService(null, new JdbcAlmacenamientoVentas(new Conn())));

		frame.setVisible(true);
	}
}
