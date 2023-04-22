package hex.domain.model;

import java.util.Objects;

import hex.domain.portsin.DomainException;
import hex.domain.portsin.InscriptoService;
import hex.domain.portsout.InfrastructureException;
import hex.domain.portsout.RepositorioInscriptos;

public class DefaultInscriptoService implements InscriptoService {

	private RepositorioInscriptos repositorio;

	public DefaultInscriptoService(RepositorioInscriptos repositorio) {
		this.repositorio = Objects.requireNonNull(repositorio);
	}

	@Override
	public void nuevoInscripto(String nombre, String apellido, String dni, String telefono, String email,
			String concurso) {
		try {
			Inscripto inscripto = new Inscripto(nombre, apellido, dni, telefono, email, concurso);
			this.repositorio.nuevoInscripto(inscripto.record());
		} catch (InfrastructureException e) {
			throw new DomainException(e, "No fue posible registrar el inscripto");
		}
	}
}
