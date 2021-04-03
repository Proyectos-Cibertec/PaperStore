package ventanas;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class DialogoMantenimientoConsultar extends JDialog implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblMarca;
	private JLabel lblDimensiones;
	private JLabel lblGramaje;
	private JLabel lblBlancura;
	private JLabel lblPrecios;
	private JComboBox<String> cboMarca;
	private JTextField txtDimensiones;
	private JTextField txtGramaje;
	private JTextField txtBlancura;
	private JTextField txtPrecio;
	private JButton btnCerrar;
	private JLabel lblIcono;
	private JPanel panel;
	private JLabel lblTitulo;

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoMantenimientoConsultar dialog = new DialogoMantenimientoConsultar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoMantenimientoConsultar() {
		setModal(true);
		setResizable(false);
		setTitle("Consultar papel");
		setBounds(100, 100, 477, 339);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(237, 197, 115));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.DARK_GRAY);
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMarca.setBounds(50, 85, 90, 23);
		contentPanel.add(lblMarca);
		
		lblDimensiones = new JLabel("Dimensiones");
		lblDimensiones.setForeground(Color.DARK_GRAY);
		lblDimensiones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDimensiones.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDimensiones.setBounds(50, 125, 90, 23);
		contentPanel.add(lblDimensiones);
		
		lblGramaje = new JLabel("Gramaje");
		lblGramaje.setForeground(Color.DARK_GRAY);
		lblGramaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGramaje.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGramaje.setBounds(50, 165, 90, 23);
		contentPanel.add(lblGramaje);
		
		lblBlancura = new JLabel("Blancura");
		lblBlancura.setForeground(Color.DARK_GRAY);
		lblBlancura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBlancura.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBlancura.setBounds(50, 205, 90, 23);
		contentPanel.add(lblBlancura);
		
		lblPrecios = new JLabel("Precio (S/.)");
		lblPrecios.setForeground(Color.DARK_GRAY);
		lblPrecios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecios.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPrecios.setBounds(50, 245, 90, 23);
		contentPanel.add(lblPrecios);
		
		cboMarca = new JComboBox<String>();
		cboMarca.setForeground(Color.DARK_GRAY);
		cboMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cboMarca.addItemListener(this);
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Class Bond", "Copy Premium", "Master Bond", "Vision Bond", "Copy Paper"}));
		cboMarca.setBounds(160, 85, 135, 23);
		contentPanel.add(cboMarca);
		
		txtDimensiones = new JTextField();
		txtDimensiones.setForeground(Color.DARK_GRAY);
		txtDimensiones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDimensiones.setEditable(false);
		txtDimensiones.setBounds(160, 125, 135, 23);
		contentPanel.add(txtDimensiones);
		txtDimensiones.setColumns(10);
		
		txtGramaje = new JTextField();
		txtGramaje.setForeground(Color.DARK_GRAY);
		txtGramaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGramaje.setEditable(false);
		txtGramaje.setBounds(160, 165, 135, 23);
		contentPanel.add(txtGramaje);
		txtGramaje.setColumns(10);
		
		txtBlancura = new JTextField();
		txtBlancura.setForeground(Color.DARK_GRAY);
		txtBlancura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtBlancura.setEditable(false);
		txtBlancura.setBounds(160, 205, 135, 23);
		contentPanel.add(txtBlancura);
		txtBlancura.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setForeground(Color.DARK_GRAY);
		txtPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(160, 245, 135, 23);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DialogoMantenimientoConsultar.class.getResource("/img/btnCancelar.png")));
		btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(326, 244, 128, 46);
		contentPanel.add(btnCerrar);
		
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(DialogoMantenimientoConsultar.class.getResource("/img/consultarPapel.png")));
		lblIcono.setBounds(326, 57, 128, 176);
		contentPanel.add(lblIcono);
		
		panel = new JPanel();
		panel.setBackground(new Color(237, 197, 115));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de las marcas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 51, 286, 239);
		contentPanel.add(panel);
		
		lblTitulo = new JLabel("CONSULTAR PAPEL");
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(124, 11, 238, 29);
		contentPanel.add(lblTitulo);
		
		mostrarDatos(0); // Muestra los datos de la marca de papel Class Bond
	}

	// Procesa eventos de tipo AcionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	// Procesa la pulsación del botón Cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
	
	// Procesa eventos de tipo ItemEvent
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboMarca) {
			itemStateChangedCboMarca(e);
		}
	}
	
	// Procesa el cambio de estado del combobox Marca
	protected void itemStateChangedCboMarca(ItemEvent e) {
		int marca;
		
		marca = getMarca();
		mostrarDatos(marca);
	}
	
	// Lee y retorna la marca de papel
	int getMarca() {
		return cboMarca.getSelectedIndex();
	}
	
	// Muestra los datos de una marca de papel específica
	public void mostrarDatos(int marca) {
		switch (marca) {
			case 0:
				txtDimensiones.setText(Tienda.dimensiones0);
				txtGramaje.setText(Tienda.gramaje0 + "");
				txtBlancura.setText(Tienda.blancura0 + "");
				txtPrecio.setText(Tienda.precio0 + "");
				break;
				
			case 1:
				txtDimensiones.setText(Tienda.dimensiones1);
				txtGramaje.setText(Tienda.gramaje1 + "");
				txtBlancura.setText(Tienda.blancura1 + "");
				txtPrecio.setText(Tienda.precio1 + "");
				break;
				
			case 2:
				txtDimensiones.setText(Tienda.dimensiones2);
				txtGramaje.setText(Tienda.gramaje2 + "");
				txtBlancura.setText(Tienda.blancura2 + "");
				txtPrecio.setText(Tienda.precio2 + "");
				break;
				
			case 3:
				txtDimensiones.setText(Tienda.dimensiones3);
				txtGramaje.setText(Tienda.gramaje3 + "");
				txtBlancura.setText(Tienda.blancura3 + "");
				txtPrecio.setText(Tienda.precio3 + "");
				break;
				
			default:
				txtDimensiones.setText(Tienda.dimensiones4);
				txtGramaje.setText(Tienda.gramaje4 + "");
				txtBlancura.setText(Tienda.blancura4 + "");
				txtPrecio.setText(Tienda.precio4 + "");
		}
	}
}
