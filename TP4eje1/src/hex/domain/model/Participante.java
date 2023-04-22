package hex.domain.model;

import java.util.Objects;

import hex.domain.portsin.DomainException;
import hex.domain.portsin.ParticipanteRecord;

class Participante {
	private String nombre;
	private Telefono telefono;
	private String region;
	private static final String MSG_NAME = "Debe cargar un nombre";
	private static final String MSG_REGION = "Region desconocida. Las conocidas son: China, US, Europa";

	public Participante(String nombre, String telefono, String region) {
		if (nombre.isEmpty())
			throw new DomainException(MSG_NAME);
		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))
			throw new DomainException(MSG_REGION);
		this.nombre = Objects.requireNonNull(nombre);
		this.region = Objects.requireNonNull(region);
		this.telefono = new Telefono(telefono);
	}

	public ParticipanteRecord record() {
		return new ParticipanteRecord(nombre, telefono.toString(), region);
	}
}
