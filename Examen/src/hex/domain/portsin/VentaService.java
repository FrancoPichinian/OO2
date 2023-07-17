package hex.domain.portsin;

import java.util.List;

public interface VentaService {

	void nuevaVenta(double litros, String tipoCombustible);

	double consultaMontoVenta(double litros, String tipoCombustible);

	List<VentaRecord> ventas();

}
