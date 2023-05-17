package hex.domain.portsin;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DomainException(Exception e, String msg) {
		super(msg, e);
	}

	public DomainException(String msg) {
		super(msg);
	}
}
