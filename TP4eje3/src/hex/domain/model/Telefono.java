package hex.domain.model;

import java.util.Objects;

import hex.domain.portsin.DomainException;

class Telefono {

	private String telefono;
	private static final String REGEX_PHONE = "\\d{4}-\\d{6}";

	public Telefono(String telefono) {
		if (!telefono.matches(REGEX_PHONE))
			throw new DomainException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		this.telefono = Objects.requireNonNull(telefono);
	}

	public String toString() {
		return this.telefono;
	}
}
