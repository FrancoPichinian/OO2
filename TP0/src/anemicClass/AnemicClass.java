package anemicClass;

import java.time.LocalDateTime;
import java.util.Objects;

// Los objetos anemicos no tienen comportamiento, solo datos.

public class AnemicClass {

	private LocalDateTime time;

	public AnemicClass(LocalDateTime time) {
		this.time = Objects.requireNonNull(time);
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}
