package hex.infrastructure.ui;

import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import hex.domain.portsin.ConcursoService;
import hex.domain.portsin.DomainException;
import hex.domain.portsin.InscriptoService;

public class RadioCompetition {
	private JPanel contentPane;
	private JLabel lblName = new JLabel("Nombre:");
	private JTextField txtName = new JTextField();
	private JLabel lblLastName = new JLabel("Apellido:");
	private JTextField txtLastName = new JTextField();
	private JLabel lblId = new JLabel("Dni:");
	private JTextField txtId = new JTextField();
	private JLabel lblPhone = new JLabel("Telefono:");
	private JTextField txtPhone = new JTextField();
	private JLabel lblEmail = new JLabel("Email:");
	private JTextField txtEmail = new JTextField();
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JButton btnOk = new JButton("Ok");
	private JLabel lblCompetition = new JLabel("Concurso:");
	private ConcursoService concursos;
	private InscriptoService inscriptos;

	public RadioCompetition(ConcursoService concursos, InscriptoService inscriptos) {
		this.concursos = concursos;
		this.inscriptos = inscriptos;
		var frame = new JFrame("Inscription to Competition");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 451, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		formElements();
		layout();
		frame.setVisible(true);
	}

	private void formElements() {
		txtName.setColumns(10);
		txtLastName.setColumns(10);
		txtId.setColumns(10);
		txtPhone.setColumns(10);
		txtEmail.setColumns(10);
		todosLosConcursos();
		btnOk.addActionListener(e -> {
			btnOk.setEnabled(false);
			saveInscription();
			btnOk.setEnabled(true);
		});
	}

	private void todosLosConcursos() {
		List<String> concursosAbiertos = concursos.concursosAbiertos();
		concursosAbiertos.forEach(c -> this.comboBox.addItem(c));
	}

	private void saveInscription() {
		try {
			this.inscriptos.nuevoInscripto(txtName.getText(), txtLastName.getText(), txtId.getText(),
					txtPhone.getText(), txtEmail.getText(), comboBox.getSelectedItem().toString());
		} catch (DomainException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	private void layout() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblLastName)
								.addComponent(lblId).addComponent(lblPhone).addComponent(lblEmail).addComponent(lblName)
								.addComponent(lblCompetition))
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtEmail, Alignment.TRAILING).addComponent(txtPhone, Alignment.TRAILING)
								.addComponent(txtId, Alignment.TRAILING).addComponent(txtLastName, Alignment.TRAILING)
								.addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298,
										Short.MAX_VALUE)))
						.addComponent(btnOk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblLastName).addComponent(
						txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblId).addComponent(txtId,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPhone)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblEmail))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCompetition))))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOk).addContainerGap(67, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
