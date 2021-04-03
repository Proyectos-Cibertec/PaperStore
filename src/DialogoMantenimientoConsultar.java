

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
		setBounds(100, 100, 354, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 29, 14);
		contentPanel.add(lblMarca);
		
		lblDimensiones = new JLabel("Dimensiones");
		lblDimensiones.setBounds(10, 36, 59, 14);
		contentPanel.add(lblDimensiones);
		
		lblGramaje = new JLabel("Gramaje");
		lblGramaje.setBounds(10, 61, 40, 14);
		contentPanel.add(lblGramaje);
		
		lblBlancura = new JLabel("Blancura");
		lblBlancura.setBounds(10, 86, 41, 14);
		contentPanel.add(lblBlancura);
		
		lblPrecios = new JLabel("Precio (S/.)");
		lblPrecios.setBounds(10, 111, 54, 14);
		contentPanel.add(lblPrecios);
		
		cboMarca = new JComboBox<String>();
		cboMarca.addItemListener(this);
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Class Bond", "Copy Premium", "Master Bond", "Vision Bond", "Copy Paper"}));
		cboMarca.setBounds(92, 8, 135, 20);
		contentPanel.add(cboMarca);
		
		txtDimensiones = new JTextField();
		txtDimensiones.setEditable(false);
		txtDimensiones.setBounds(92, 33, 135, 20);
		contentPanel.add(txtDimensiones);
		txtDimensiones.setColumns(10);
		
		txtGramaje = new JTextField();
		txtGramaje.setEditable(false);
		txtGramaje.setBounds(92, 58, 135, 20);
		contentPanel.add(txtGramaje);
		txtGramaje.setColumns(10);
		
		txtBlancura = new JTextField();
		txtBlancura.setEditable(false);
		txtBlancura.setBounds(92, 83, 135, 20);
		contentPanel.add(txtBlancura);
		txtBlancura.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(92, 108, 135, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(252, 7, 89, 23);
		contentPanel.add(btnCerrar);
		
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
