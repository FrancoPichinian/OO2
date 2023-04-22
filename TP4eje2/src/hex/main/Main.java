package hex.main;

import hex.domain.model.DefaultEmpleadoService;
import hex.domain.portsin.EmpleadoService;
import hex.infrastructure.data.FilesRepositorioEmpleados;
import hex.infrastructure.mail.MailTrapNotificar;

public class Main {
	private static final String PATH = "C:\\Users\\CX\\eclipse-workspace\\TP4eje2\\empleados.txt";
	private static final String USER = "73e57dd705c620";
	private static final String PASS = "25797e4dced79d";
	private static final String HOST = "sandbox.smtp.mailtrap.io";

	public static void main(String[] args) {

		EmpleadoService service = new DefaultEmpleadoService(new FilesRepositorioEmpleados(PATH),
				new MailTrapNotificar(USER, PASS, HOST, 2525));
		service.cargarEmpleados();
		service.enviarSaludo();
	}
}
