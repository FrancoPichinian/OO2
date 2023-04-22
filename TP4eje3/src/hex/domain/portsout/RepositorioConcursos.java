package hex.domain.portsout;

import java.util.List;

public interface RepositorioConcursos {

	// Tanto leer los concursos de la bd y de un archivo ambos implementan la misma
	// interface
	List<String[]> todosLosConcursos();

}
