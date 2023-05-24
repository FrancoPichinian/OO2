package main;

import accesos.Conn;
import accesos.PersonaDao;
import model.Persona;
import model.Telefono;

public class Main {

	public static void main(String args[]) {
		PersonaDao dao = new PersonaDao(new Conn());
		Persona p = dao.personaPorId(1);
		System.out.println(p.nombre());
		for (Telefono telefono : p.telefonos())
			System.out.println(telefono);
	}
}
