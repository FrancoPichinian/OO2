package eje1;

public class MotorEconomico implements Motor {

	public void arrancar() {
		System.out.println("Metodo arrancar, clase Motor: " + this.getClass().getSimpleName());
	}

	public void acelerar() {
		System.out.println("Metodo acelerar, clase Motor: " + this.getClass().getSimpleName());
	}

	public void apagar() {
		System.out.println("Metodo apagar, clase Motor: " + this.getClass().getSimpleName());
	}
}
