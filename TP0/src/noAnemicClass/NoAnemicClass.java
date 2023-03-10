package noAnemicClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;

public class NoAnemicClass {
	private LocalDateTime time;

	public NoAnemicClass(LocalDateTime time) {
		Objects.requireNonNull(time);
		this.time = time;
	}

	public String shortWay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YY h:mm");
		return dtf.format(time);
	}

	public String longWay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		return dtf.format(time);
	}
}
