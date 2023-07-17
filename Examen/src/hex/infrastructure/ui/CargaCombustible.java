package hex.infrastructure.ui;

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

import hex.domain.portsin.DomainException;
import hex.domain.portsin.VentaService;

public class CargaCombustible extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLitros = new JLabel("Litros:");
	private JTextField txtLitros = new JTextField();
	private JLabel lblTipoCombustible = new JLabel("Tipo combustible:");
	private JComboBox<String> combustibles = new JComboBox<>();
	private JLabel lblMontoTotal = new JLabel("Monto Total:");
	private JTextField txtMontoTotal = new JTextField();

	private JButton btnRealizarCarga = new JButton("Realizar Carga");
	private VentaService ventas;

	public CargaCombustible(VentaService ventas) {
		this.ventas = ventas;
		JFrame frame = new JFrame("Carga de Combustible");
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
		txtLitros.setColumns(10);
		agregarCombustibles();
		btnRealizarCarga.addActionListener(e -> {
			btnRealizarCarga.setEnabled(false);
			realizarCompra();
			btnRealizarCarga.setEnabled(true);
		});
	}

	private void realizarCompra() {
		try {
			ventas.nuevaVenta(Double.valueOf(txtLitros.getText()), (String) combustibles.getSelectedItem());
		} catch (DomainException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ingrese cantidad de Litros");
		}
	}

	private void agregarCombustibles() {
		combustibles.addItem("Super");
		combustibles.addItem("Extra Super");
	}

	private double consultarMontoVenta() {
		return ventas.consultaMontoVenta(Double.valueOf(txtLitros.getText()), (String) combustibles.getSelectedItem());
	}

	public void layout() {
		JButton btnConsultarMonto = new JButton("Consultar Monto Total");
		btnConsultarMonto.addActionListener(e -> {
			try {
				txtMontoTotal.setText(String.valueOf(consultarMontoVenta()));
			} catch (DomainException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Ingrese cantidad de litros");
			}
		});

		txtMontoTotal.setEditable(false);
		txtMontoTotal.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane
								.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblLitros)
										.addComponent(lblTipoCombustible))
								.addGap(45)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtLitros, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298,
												Short.MAX_VALUE)

										.addComponent(combustibles, Alignment.TRAILING, 0, 298, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnConsultarMonto, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblMontoTotal)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtMontoTotal,
														GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE).addComponent(
										btnRealizarCarga, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLitros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLitros))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(combustibles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoCombustible))
				.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false).addGroup(gl_contentPane
						.createSequentialGroup().addComponent(btnConsultarMonto)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMontoTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMontoTotal)))
						.addComponent(btnRealizarCarga, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
