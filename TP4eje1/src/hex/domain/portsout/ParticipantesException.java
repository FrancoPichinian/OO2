package hex.domain.portsout;

public class ParticipantesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParticipantesException(Exception e, String msg) {
		super(msg, e);
	}
}
