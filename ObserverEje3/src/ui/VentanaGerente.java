package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Observer;

public class VentanaGerente implements Observer {
	private JLabel label;
	private JFrame frame = new JFrame("Monitor Gerente");

	public VentanaGerente() {
		frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		label = new JLabel("...");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 150);
		frame.setLocation(200, 200);
		frame.setVisible(true);
	}

	@Override
	public void actualizar(String valor) {
		label.setText(valor);
		int intValue = Double.valueOf(valor).intValue();
		if (intValue > 10000)
			frame.getContentPane().setBackground(Color.RED);
	}
}
