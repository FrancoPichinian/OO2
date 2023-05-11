package eje1;

public class Main {

	public static void main(String[] args) {
		Motor motorComun = new MotorComun();
		motorComun.arrancar();
		motorComun.acelerar();
		motorComun.apagar();
		motorComun = new MotorElectricoAdapter(new MotorElectrico());
		System.out.println("");
		motorComun.arrancar();
		motorComun.acelerar();
		motorComun.apagar();
	}
}
