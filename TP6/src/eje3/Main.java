package eje3;

public class Main {

	public static void main(String[] args) {

		Combo comboFamiliar = new AdicionalTomate(new AdicionalPapas(new AdicionalCarne(new ComboFamiliar())));
		System.out.println(comboFamiliar.descripcion());
		System.out.println(comboFamiliar.precio());

		Combo comboEspecial = new AdicionalTomate(new AdicionalPapas(new AdicionalCarne(new ComboEspecial())));
		System.out.println(comboEspecial.descripcion());
		System.out.println(comboEspecial.precio());
	}
}
