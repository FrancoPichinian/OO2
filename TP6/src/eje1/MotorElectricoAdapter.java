package eje1;

import java.util.Objects;

public class MotorElectricoAdapter implements Motor {

	private MotorElectrico motorElectrico;

	public MotorElectricoAdapter(MotorElectrico motorElectrico) {
		this.motorElectrico = Objects.requireNonNull(motorElectrico);
	}

	@Override
	public void arrancar() {
		motorElectrico.conectar();
		motorElectrico.activar();
		System.out.println("Metodo arrancar, clase Motor: " + this.getClass().getSimpleName());
	}

	@Override
	public void acelerar() {
		motorElectrico.moverMasRapido();
		System.out.println("Metodo acelerar, clase Motor: " + this.getClass().getSimpleName());
	}

	@Override
	public void apagar() {
		motorElectrico.detener();
		motorElectrico.desconectar();
		System.out.println("Metodo apagar, clase Motor: " + this.getClass().getSimpleName());
	}
}
