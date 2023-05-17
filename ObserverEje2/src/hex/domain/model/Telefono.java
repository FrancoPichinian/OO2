package hex.domain.model;

import java.util.Objects;

import hex.domain.portsin.DomainException;

class Telefono {

	private String telefono;
	private static final String MSG_PHONE = "Debe cargar un telefono";
	private static final String MSG_PHONE_REGEX = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
	private static final String REGEX = "\\d{4}-\\d{6}";

	public Telefono(String telefono) {
		if (telefono.isEmpty())
			throw new DomainException(MSG_PHONE);
		if (!telefono.matches(REGEX))
			throw new DomainException(MSG_PHONE_REGEX);
		this.telefono = Objects.requireNonNull(telefono);
	}

	public String toString() {
		return this.telefono;
	}
}
