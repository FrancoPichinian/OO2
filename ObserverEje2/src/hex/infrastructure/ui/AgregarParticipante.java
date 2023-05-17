package hex.infrastructure.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hex.domain.portsin.DomainException;
import hex.domain.portsin.ParticipanteService;

public class AgregarParticipante extends JFrame {
	private static final long serialVersionUID = 1L;
	private ParticipanteService participantes;
	private JTextField nombre = new JTextField(10);
	private JTextField telefono = new JTextField(10);
	private JTextField region = new JTextField(10);
	private JTextField email = new JTextField(10);

	public AgregarParticipante(ParticipanteService participantes) {
		this.participantes = participantes;
		setupUIComponents();
	}

	private void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		contentPane.add(new JLabel("Email: "));
		contentPane.add(email);
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(e -> {
			try {
				this.participantes.nuevoParticipante(nombre.getText(), telefono.getText(), region.getText(),
						email.getText());
			} catch (DomainException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
				return;
			}
			dispose();
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}
}
