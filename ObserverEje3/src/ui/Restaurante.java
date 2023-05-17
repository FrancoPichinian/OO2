package ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bebida;
import model.DispositivoElectronico;
import model.Observer;
import model.Plato;

public class Restaurante extends JFrame {

	private static final long serialVersionUID = 1L;
	private List<Plato> platos;
	private List<Bebida> bebidas;
	private JLabel lblPlatos = new JLabel("Platos");
	private JLabel lblBebidas = new JLabel("Bebidas");
	private JComboBox<String> platoss = new JComboBox<>();
	private JComboBox<String> bebidass = new JComboBox<>();
	private JButton botonPagar = new JButton("Pagar");
	private List<Observer> monitores;

	public Restaurante(List<Plato> platos, List<Bebida> bebidas, List<Observer> monitores) {
		this.platos = platos;
		this.bebidas = bebidas;
		this.monitores = monitores;
		setupUIComponents();
	}

	private void setupUIComponents() {
		DispositivoElectronico de = new DispositivoElectronico(monitores);
		setTitle("Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(lblPlatos);
		contentPane.add(platoss);
		contentPane.add(lblBebidas);
		contentPane.add(bebidass);
		contentPane.add(botonPagar);
		agregarPlatos();
		agregarBebidas();

		botonPagar.addActionListener(e -> {
			de.pagar(this.platos.get(platoss.getSelectedIndex()), this.bebidas.get(bebidass.getSelectedIndex()), 1);
			System.out.println(de.montoTotal());
		});
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setSize(300, 150);
		setVisible(true);
	}

	private void agregarPlatos() {
		platos.forEach(p -> this.platoss.addItem(p.nombre()));
	}

	private void agregarBebidas() {
		bebidas.forEach(b -> this.bebidass.addItem(b.nombre()));
	}
}
