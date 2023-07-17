package hex.domain.portsout;

import java.time.LocalDate;

public interface RepositorioVentas {

	void persistir(LocalDate fecha, double litros, double montoTotal);

}
