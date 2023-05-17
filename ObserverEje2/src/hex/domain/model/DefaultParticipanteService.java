package hex.domain.model;

import java.util.List;
import java.util.Objects;

import hex.domain.portsin.DomainException;
import hex.domain.portsin.ParticipanteService;
import hex.domain.portsout.Participantes;
import hex.domain.portsout.ParticipantesException;

public class DefaultParticipanteService extends Observable implements ParticipanteService {

	private Participantes registroParticipantes;

	private static final String MSG = "No fue posible registrar el participante";

	public DefaultParticipanteService(Participantes registroParticipantes, List<Observer> observadores) {
		super(observadores);
		this.registroParticipantes = Objects.requireNonNull(registroParticipantes);
	}

	@Override
	public void nuevoParticipante(String nombre, String telefono, String region, String email) {
		try {
			Participante participante = new Participante(nombre, telefono, region, email);
			this.registroParticipantes.nuevoParticipante(participante.record());
			notificar(email);
		} catch (ParticipantesException e) {
			throw new DomainException(e, MSG);
		}
	}
}
