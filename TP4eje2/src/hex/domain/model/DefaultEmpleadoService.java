package hex.domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import hex.domain.portsin.EmpleadoService;
import hex.domain.portsout.Notificar;
import hex.domain.portsout.RepositorioEmpleados;

public class DefaultEmpleadoService implements EmpleadoService {

	private RepositorioEmpleados repositorio;
	private Notificar notificar;
	private List<Empleado> empleados;
	private static final String ASUNTO = "Saludo";
	private static final String MSJ = "Feliz Cumpleaños ";
	private static final String REMITENTE = "from@example.com";
	private static final String DESTINATARIO = "to@example.com";

	public DefaultEmpleadoService(RepositorioEmpleados repositorio, Notificar notificar) {
		this.repositorio = Objects.requireNonNull(repositorio);
		this.notificar = Objects.requireNonNull(notificar);
		this.empleados = new ArrayList<>();
	}

	@Override
	public void cargarEmpleados() {
		List<String[]> empleadosString = repositorio.obtenerEmpleados();
		empleados = empleadosString.stream().map(this::crearEmpleado).collect(Collectors.toList());
	}

	private Empleado crearEmpleado(String[] datos) {
		return new Empleado(datos[0], datos[1], convertiAFecha(datos[2]), datos[3]);
	}

	private LocalDate convertiAFecha(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.parse(fecha, formatter);
		return localDate;
	}

	@Override
	public void enviarSaludo() {
		this.empleados.stream().filter(Empleado::cumpleHoy)
				.forEach(e -> this.notificar.enviarCorreo(ASUNTO, MSJ + e.nombre(), REMITENTE, DESTINATARIO));
	}
}
