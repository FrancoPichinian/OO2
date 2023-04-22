package hex.domain.portsout;

public class EmpleadosException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmpleadosException(Exception e, String msg) {
		super(msg, e);
	}
}
