package hex.domain.model;

import java.util.Objects;

import hex.domain.portsin.DomainException;
import hex.domain.portsin.InscriptoRecord;

class Inscripto {
	private String nombre;
	private String apellido;
	private String dni;
	private Telefono telefono;
	private Email email;
	private String concurso;

	public Inscripto(String nombre, String apellido, String dni, String telefono, String email, String concurso) {
		if (nombre.isEmpty())
			throw new DomainException("Nombre no puede ser vacio");
		if (apellido.isEmpty())
			throw new DomainException("Apellido no puede ser vacio");
		if (dni.isEmpty())
			throw new DomainException("Dni no puede ser vacio");
		if (concurso.isEmpty())
			throw new DomainException("Concurso no puede ser vacio");
		this.nombre = Objects.requireNonNull(nombre);
		this.apellido = Objects.requireNonNull(apellido);
		this.dni = Objects.requireNonNull(dni);
		this.telefono = new Telefono(telefono);
		this.email = new Email(email);
		this.concurso = Objects.requireNonNull(concurso);
	}

	public InscriptoRecord record() {
		return new InscriptoRecord(nombre, apellido, dni, telefono.toString(), email.toString(), concurso);
	}
}
