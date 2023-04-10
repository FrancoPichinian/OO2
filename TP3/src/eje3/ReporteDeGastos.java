package eje3;

import java.util.List;
import java.util.Objects;

public class ReporteDeGastos {

	private ProveedorFecha fecha;
	private List<Gasto> gastos;

	public ReporteDeGastos(List<Gasto> gastos, ProveedorFecha fecha) {
		this.fecha = Objects.requireNonNull(fecha);
		this.gastos = Objects.requireNonNull(gastos);
	}

	public int montoComidas() {
		return gastos.stream().mapToInt(g -> g.sumaMontoComida(0)).sum();
	}

	public int montoTotal() {
		return this.gastos.stream().mapToInt(Gasto::monto).sum();
	}

	public StringBuffer informacionGastos() {
		StringBuffer informacionGastos = new StringBuffer();
		gastos.forEach(gasto -> {
			String marcaExceso = gasto.verificarExceso() ? "X" : " ";
			informacionGastos.append(gasto.nombre() + "\t" + gasto.monto() + "\t" + marcaExceso);
		});
		return informacionGastos;
	}

	public String imprimir() {
		StringBuffer reporte = new StringBuffer();
		reporte.append("Expenses " + this.fecha.obtenerFechaActual());
		reporte.append(this.informacionGastos());
		reporte.append("Gastos de comida: " + montoComidas());
		reporte.append("Total de gastos: " + montoTotal());
		return reporte.toString();
	}
}
