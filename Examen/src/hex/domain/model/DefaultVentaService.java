package hex.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hex.domain.portsin.DomainException;
import hex.domain.portsin.VentaRecord;
import hex.domain.portsin.VentaService;
import hex.domain.portsout.AlmacenamientoVentas;
import hex.domain.portsout.InfrastructureException;
import hex.domain.portsout.RepositorioVentas;

public class DefaultVentaService implements VentaService {

	private RepositorioVentas repositorioVentas;
	private AlmacenamientoVentas almacenamientoVentas;
	private static final double PRECIO_SUPER = 270.0;
	private static final double PRECIO_EXTRA_SUPER = 390.0;
	private static final double MONTO_MAX = 100000;
	private static final String MSG = "No fue posible registrar la venta";

	public DefaultVentaService(RepositorioVentas repositorioVentas, AlmacenamientoVentas almacenamientoVentas) {
		this.repositorioVentas = repositorioVentas;
		this.almacenamientoVentas = almacenamientoVentas;
	}

	@Override
	public void nuevaVenta(double litros, String tipoCombustible) {
		try {
			EstacionServicio combustible = crearCombustible(tipoCombustible, litros);
			Venta venta = new Venta(LocalDate.now(), combustible.litros(), combustible);
			this.repositorioVentas.persistir(LocalDate.now(), combustible.litros(), venta.montoTotal());
		} catch (InfrastructureException e) {
			throw new DomainException(e, MSG);
		}
	}

	private EstacionServicio crearCombustible(String tipoCombustible, double litros) {
		return tipoCombustible.equals("Super") ? new CombustibleSuper(PRECIO_SUPER, litros)
				: new CombustibleExtraSuper(PRECIO_EXTRA_SUPER, litros);
	}

	@Override
	public double consultaMontoVenta(double litros, String tipoCombustible) {
		EstacionServicio combustible = crearCombustible(tipoCombustible, litros);
		Venta venta = new Venta(LocalDate.now(), combustible.litros(), combustible);
		return venta.montoTotal();
	}

	@Override
	public List<VentaRecord> ventas() {
		List<String[]> datos = this.almacenamientoVentas.ventasRealizadas();
		List<VentaRecord> ventas = new ArrayList<>();

		for (String[] venta : datos) {
			LocalDate fecha = LocalDate.parse(venta[0]);
			double litros = Double.parseDouble(venta[1]);
			double montoTotal = Double.parseDouble(venta[2]);
			VentaRecord ventaRecord = new VentaRecord(fecha, litros, montoTotal, esImportante(montoTotal));
			ventas.add(ventaRecord);
		}
		return ventas;
	}

	private String esImportante(double montoTotal) {
		return montoTotal > MONTO_MAX ? "Sí" : "No";
	}
}
