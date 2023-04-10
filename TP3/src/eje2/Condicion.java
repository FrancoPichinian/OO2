package eje2;

import java.util.List;
import java.util.Map;

public interface Condicion {

	boolean esIgual(List<String[]> csvData, int columna, Map<String, String> options);

}
