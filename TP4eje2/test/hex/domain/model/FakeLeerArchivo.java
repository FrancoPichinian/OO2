package hex.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import hex.domain.portsout.RepositorioEmpleados;

public class FakeLeerArchivo implements RepositorioEmpleados {

	private String registro;

	public FakeLeerArchivo(String registro) {
		this.registro = Objects.requireNonNull(registro);
	}

	@Override
	public List<String[]> obtenerEmpleados() {
		List<String[]> listaEmpleados = new ArrayList<String[]>();
		String[] lineasArchivo = registro.split(System.lineSeparator());
		for (String linea : lineasArchivo)
			listaEmpleados.add(linea.split(", "));
		return listaEmpleados;
	}
}
