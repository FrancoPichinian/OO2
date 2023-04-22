package hex.domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import hex.domain.portsin.ConcursoService;
import hex.domain.portsout.RepositorioConcursos;

public class DefaultConcursoService implements ConcursoService {

	private RepositorioConcursos repositorio;
	private List<Concurso> concursos;

	public DefaultConcursoService(RepositorioConcursos repositorio) {
		this.repositorio = Objects.requireNonNull(repositorio);
	}

	@Override
	public List<String> concursosAbiertos() {
		List<String[]> concursosString = repositorio.todosLosConcursos();
		concursos = concursosString.stream().map(this::crearConcurso).collect(Collectors.toList());
		concursos = obtenerConcursosConInscripcionAbierta();
		return mapearConcursosAListaString();
	}

	private Concurso crearConcurso(String[] datos) {
		return new Concurso(datos[0], datos[1], convertiAFecha(datos[2]), convertiAFecha(datos[3]));
	}

	private LocalDate convertiAFecha(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(fecha, formatter);
		return localDate;
	}

	private List<Concurso> obtenerConcursosConInscripcionAbierta() {
		return this.concursos.stream().filter(c -> c.inscripcionEstaAbierta()).collect(Collectors.toList());
	}

	private List<String> mapearConcursosAListaString() {
		return concursos.stream().map(concurso -> concurso.id()).collect(Collectors.toList());
	}
}
