package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concurso {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private List<Participante> participantes;

	public Concurso(LocalDate fechaInicio, LocalDate fechaFin) {
		this.fechaInicio = Objects.requireNonNull(fechaInicio);
		this.fechaFin = Objects.requireNonNull(fechaFin);
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
	}

	public boolean estaInscripto(Participante participante) {
		return this.participantes.stream().anyMatch(p -> p.equals(participante));
	}
}
