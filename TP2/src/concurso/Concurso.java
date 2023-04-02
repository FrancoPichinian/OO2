package concurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concurso {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private List<Participante> participantes;
	private RegistroInscripcion registro;
	private NotificarParticipante correo;

	public Concurso(String nombre, LocalDate fechaInicio, LocalDate fechaFin, RegistroInscripcion registro,
			NotificarParticipante correo) {
		this.nombre = Objects.requireNonNull(nombre);
		this.fechaInicio = Objects.requireNonNull(fechaInicio);
		this.fechaFin = Objects.requireNonNull(fechaFin);
		this.registro = Objects.requireNonNull(registro);
		this.correo = Objects.requireNonNull(correo);
		this.participantes = new ArrayList<>();
	}

	public void inscribirParticipante(Participante participante) {
		if (LocalDate.now().isBefore(fechaInicio) || LocalDate.now().isAfter(fechaFin))
			throw new RuntimeException("Fecha inválida");
		if (estaInscripto(participante))
			throw new RuntimeException("El participante ya está inscripto");
		if (LocalDate.now().equals(fechaInicio))
			participante.sumarPuntos(10);
		participantes.add(participante);

		String formato = new FechaFormateada(LocalDate.now()).obtenerFechaFormateada() + ", "
				+ participante.obtenerNombre() + ", " + this.nombre + "\n";
		this.registro.registrar(formato);

		String asunto = "Inscripción";
		String mensaje = participante.obtenerNombre() + " se inscribió en el concurso " + this.nombre;
		this.correo.enviarCorreo(asunto, mensaje, "from@example.com", "to@example.com");
	}

	public boolean estaInscripto(Participante participante) {
		return this.participantes.stream().anyMatch(p -> p.equals(participante));
	}

	String obtenerNombre() {
		return this.nombre;
	}
}
