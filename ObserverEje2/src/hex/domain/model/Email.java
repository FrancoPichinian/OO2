package hex.domain.model;

import java.util.Objects;

import hex.domain.portsin.DomainException;

class Email {
	private String email;
	private static final String REGEX_EMAIL = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	public Email(String email) {
		if (email.isEmpty())
			throw new DomainException("Ingrese un email");
		if (!email.matches(REGEX_EMAIL))
			throw new DomainException("Email debe ser válido");

		this.email = Objects.requireNonNull(email);
	}

	public String toString() {
		return this.email;
	}
}
