package anemicClass;

import java.time.LocalDateTime;

// Los objetos anemicos no tienen comportamiento, solo datos.

public class AnemicClass {

	private LocalDateTime time;

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}
