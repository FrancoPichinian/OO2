package restaurante;

public class FakeRegistroPago implements RegistroPago {

	private String registro;

	@Override
	public void registrarPago(String registro) {
		this.registro = registro;
	}

	public String contenido() {
		return this.registro;
	}
}
