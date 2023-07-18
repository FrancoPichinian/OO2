package hex.infrastructure.ui;

import java.awt.BorderLayout;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hex.domain.portsin.VentaRecord;
import hex.domain.portsin.VentaService;

public class ConsultaVentas extends JFrame {

	private JPanel contentPane;
	private VentaService ventas;
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane = new JScrollPane();
	private JTable tabla = new JTable();
	private Object[] titulos = { "Fecha_venta", "Litros_cargados", "Monto_facturado", "Es_importante" };
	private DefaultTableModel modelo = new DefaultTableModel(titulos, 0) {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	public ConsultaVentas(VentaService ventas) {
		this.ventas = ventas;
		setTitle("Listado ventas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		tabla.setModel(modelo);
		scrollPane.setViewportView(tabla);
		cargarDatos();
	}

	private void cargarDatos() {
		List<VentaRecord> ventasParseadas = ventas.ventas();
		IntStream.range(0, ventasParseadas.size()).forEach(i -> {
			modelo.addRow(new Object[] { ventasParseadas.get(i).fecha(), ventasParseadas.get(i).litros(),
					ventasParseadas.get(i).montoTotal(), ventasParseadas.get(i).esImportante() });
		});
	}
}
