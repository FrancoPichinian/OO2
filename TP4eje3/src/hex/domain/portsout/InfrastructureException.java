package hex.domain.portsout;

public class InfrastructureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InfrastructureException(Exception e, String msg) {
		super(msg, e);
	}
}
