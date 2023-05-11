package eje3;

public class ComboBasico implements Combo {

	@Override
	public float precio() {
		return 1000;
	}

	@Override
	public String descripcion() {
		return "Combo basico, precio: 1000";
	}
}
