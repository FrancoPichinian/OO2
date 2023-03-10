package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import anemicClass.AnemicClass;
import anemicClass.TiempoRecord;
import noAnemicClass.NoAnemicClass;

public class Main {

	public static void main(String[] args) {

		AnemicClass anemicClass = new AnemicClass();

		anemicClass.setTime(LocalDateTime.now());
		LocalDateTime date = anemicClass.getTime();

		System.out.println("Anemic Class");

		String formatoCorto = DateTimeFormatter.ofPattern("dd/MM/YY h:mm").format(date);
		System.out.println("Formato corto: " + formatoCorto);

		String formatoLargo = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(date);
		System.out.println("Formato largo: " + formatoLargo);

		NoAnemicClass noAnemicClass = new NoAnemicClass(LocalDateTime.now());

		System.out.println("\nNo Anemic Class");

		System.out.println("Formato corto: " + noAnemicClass.shortWay());

		System.out.println("Formato largo: " + noAnemicClass.longWay());

		System.out.println("\nRecord");

		TiempoRecord record = new TiempoRecord(LocalDateTime.now());
		LocalDateTime time = record.time();
		String shortWay = DateTimeFormatter.ofPattern("dd/MM/YY h:mm").format(time);
		System.out.println("Formato corto: " + shortWay);

		String longWay = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(time);
		System.out.println("Formato largo: " + longWay);

	}
}
