package model;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import ui.Restaurante;
import ui.VentanaGerente;

public class Main {

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurante ui = new Restaurante(List.of(new Plato("Asado", 3000), new Plato("Tallarines", 2000)),
							List.of(new Bebida("Agua", 350), new Bebida("Gaseosa", 500)),
							List.of(new VentanaGerente()));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
