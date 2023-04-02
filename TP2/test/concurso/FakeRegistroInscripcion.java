package concurso;

public class FakeRegistroInscripcion implements RegistroInscripcion {

	private String registro;

	@Override
	public void registrar(String registro) {
		this.registro = registro;
	}

	public String contenido() {
		return this.registro;
	}
}
