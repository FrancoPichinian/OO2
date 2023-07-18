package hex.domain.portsin;

import java.time.LocalDate;

public record VentaRecord(LocalDate fecha, double litros, double montoTotal, String esImportante) {

}
