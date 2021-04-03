package ventanas;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class DialogoMantenimientoModificar extends JDialog implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	
	// Declaraci�n de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblMarca;
	private JLabel lblDimesiones;
	private JLabel lblGramaje;
	private JLabel lblBlancura;
	private JLabel lblPrecio;
	private JComboBox<String> cboMarca;
	private JTextField txtDimensiones;
	private JTextField txtGramaje;
	private JTextField txtBlancura;
	private JTextField txtPrecio;
	private JButton btnCerrar;
	private JButton btnGrabar;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoMantenimientoModificar dialog = new DialogoMantenimientoModificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Crea la GUI
	public DialogoMantenimientoModificar() {
		setModal(true);
		setResizable(false);
		setTitle("Modificar papel");
		setBounds(100, 100, 494, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(237, 197, 115));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.DARK_GRAY);
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMarca.setBounds(41, 96, 90, 23);
		contentPanel.add(lblMarca);
		
		lblDimesiones = new JLabel("Dimensiones");
		lblDimesiones.setForeground(Color.DARK_GRAY);
		lblDimesiones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDimesiones.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDimesiones.setBounds(41, 136, 90, 23);
		contentPanel.add(lblDimesiones);
		
		lblGramaje = new JLabel("Gramaje");
		lblGramaje.setForeground(Color.DARK_GRAY);
		lblGramaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGramaje.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGramaje.setBounds(41, 176, 90, 23);
		contentPanel.add(lblGramaje);
		
		lblBlancura = new JLabel("Blancura");
		lblBlancura.setForeground(Color.DARK_GRAY);
		lblBlancura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBlancura.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBlancura.setBounds(41, 216, 90, 23);
		contentPanel.add(lblBlancura);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setForeground(Color.DARK_GRAY);
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPrecio.setBounds(41, 256, 90, 23);
		contentPanel.add(lblPrecio);
		
		cboMarca = new JComboBox<String>();
		cboMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cboMarca.addItemListener(this);
		cboMarca.setBounds(151, 96, 135, 23);
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Class Bond", "Copy Premium", "Master Bond", "Vision Bond", "Copy Paper"}));
		contentPanel.add(cboMarca);
		
		txtDimensiones = new JTextField();
		txtDimensiones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDimensiones.setBounds(151, 136, 135, 23);
		contentPanel.add(txtDimensiones);
		txtDimensiones.setColumns(10);
		txtDimensiones.addActionListener(this);
		
		txtGramaje = new JTextField();
		txtGramaje.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGramaje.setBounds(151, 176, 135, 23);
		contentPanel.add(txtGramaje);
		txtGramaje.setColumns(10);
		txtGramaje.addActionListener(this);
		
		txtBlancura = new JTextField();
		txtBlancura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtBlancura.setBounds(151, 216, 135, 23);
		contentPanel.add(txtBlancura);
		txtBlancura.setColumns(10);
		txtBlancura.addActionListener(this);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPrecio.setBounds(151, 256, 135, 23);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.addActionListener(this);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DialogoMantenimientoModificar.class.getResource("/img/btnCancelar.png")));
		btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCerrar.setBounds(326, 255, 135, 46);
		btnCerrar.addActionListener(this);
		contentPanel.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(DialogoMantenimientoModificar.class.getResource("/img/btnGrabar.png")));
		btnGrabar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGrabar.setBounds(326, 202, 135, 46);
		btnGrabar.addActionListener(this);
		contentPanel.add(btnGrabar);
		
		lblIcono = new JLabel("New label");
		lblIcono.setIcon(new ImageIcon(DialogoMantenimientoModificar.class.getResource("/img/modificarPapel.png")));
		lblIcono.setBounds(326, 57, 135, 142);
		contentPanel.add(lblIcono);
		
		lblTitulo = new JLabel("MODIFICAR PAPEL");
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(130, 11, 228, 29);
		contentPanel.add(lblTitulo);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de las marcas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(237, 197, 115));
		panel.setBounds(21, 57, 287, 244);
		contentPanel.add(panel);
		
		mostrarDatos(0); // Muestra los datos de la marca de papel Class Bond ni bien se abre el JDialog
		guardarDatosIniciales(); // Guarda los valores iniciales de: dimensiones, gramaje, blancura, precio
		
	}
	
	// Variables que guardan los valores iniciales de las dimensiones, gramaje, blancura y precio
	String dimensionInicial;
	double gramajeInicial, blancuraInicial, precioInicial;

	// Muestra los datos de la marca de papel que fue pasada como par�metro en los cuadros de texto correspondientes
	void mostrarDatos(int marca) {
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
	
	// Guarda los valores de dimensiones, gramaje, blancura y precio antes de ser modificados
	void guardarDatosIniciales() {
		dimensionInicial = txtDimensiones.getText();
		gramajeInicial = Double.parseDouble(txtGramaje.getText());
		blancuraInicial = Double.parseDouble(txtBlancura.getText());
		precioInicial = Double.parseDouble(txtPrecio.getText());
	}
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar ||
			e.getSource() == txtDimensiones ||
			e.getSource() == txtGramaje ||
			e.getSource() == txtBlancura ||
			e.getSource() == txtPrecio) {
			
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	// Procesa la pulsaci�n del bot�n Cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // Cierra el cuadro de di�logo
	}
	
	// Procesa la pulsaci�n del bot�n Grabar
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		grabar();
	}
	
	boolean esCorrecto; // Permite saber si los datos ingresados son todos correctos
	private JLabel lblIcono;
	private JLabel lblTitulo;
	private JPanel panel;
	
	// Graba los nuevos valores de dimensi�n, gramaje, blancura y precio para una marca de papel determinada
	void grabar() {
		esCorrecto = true; // Se asume que los datos ingresados son correctos
		
		// Declaraci�n de variables
		int marca;
		String dimensiones;
		double gramaje, blancura, precio;
		
		// Entrada de datos
		marca = getMarca();
		dimensiones = getDimensiones();
		gramaje = getGramaje();
		blancura = getBlancura();
		precio = getPrecio();
		
		if (esCorrecto) {
			int respuesta = JOptionPane.showConfirmDialog(this, "�Seguro que desea guardar los cambios efectuados?",
					"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
			
			if (respuesta == JOptionPane.YES_OPTION) {
				// Se cambian las dimensiones, gramaje, blancura y/o precio
				guardarDatos(marca, dimensiones, gramaje, blancura, precio);
				JOptionPane.showMessageDialog(this, "Los datos fueron guardados correctamente");
				dispose();
			} else {
				regresarValoresIniciales();
			}
		}
	}
	
	// Lee y retorna el �ndice de la marca de papel seleccionada
	int getMarca() {
		return cboMarca.getSelectedIndex();
	}
	
	// Lee y retorna las dimensiones del papel
	String getDimensiones() {
		String dimensiones;
		
		dimensiones = txtDimensiones.getText();
		if (dimensiones.length() == 0) {
			// Se dej� en blanco el valor de las dimensiones
			mensajeError("No debe dejar en blanco el valor de las Dimensiones", "Error en la lectura de las Dimensiones");
			dimensiones = dimensionInicial; // Regresa las dimensiones a su valor inicial
			txtDimensiones.setText(dimensiones); // Muestra en el cuadro de texto el valor inicial de las dimensiones
			txtDimensiones.requestFocus();
			esCorrecto = false;
		}
		
		return dimensiones;
	}
	
	// Lee y retorna el gramaje
	double getGramaje() {
		double gramaje;
		
		try {
			gramaje = Double.parseDouble(txtGramaje.getText());
			
			if (gramaje <= 0.0) { // validaci�n
				mensajeError("Debe ingresar un valor positivo para el Gramaje", "Error en la lectura del Gramaje");
				gramaje = gramajeInicial; // Regresa el gramaje a su valor inicial
				txtGramaje.setText(gramaje + ""); // Muestra en el cuadro de texto el valor inicial del gramaje
				txtGramaje.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor num�rico
			String strGramaje = txtGramaje.getText(); // Se obtiene el texto ingresado
			if (strGramaje.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Gramaje", "Error en la lectura del Gramaje");
			} else {
				// Se dej� en blanco el valor del gramaje
				mensajeError("No debe dejar en blanco el valor del Gramaje", "Error en la lectura del Gramaje");
			}
			gramaje = gramajeInicial; // Regresa el gramaje a su valor inicial
			txtGramaje.setText(gramaje + ""); // Muestra en el cuadro de texto el valor inicial del gramaje
			txtGramaje.requestFocus();
			esCorrecto = false;
		}
		
		return gramaje;
	}

	// Lee y retorna la blancura
	double getBlancura() {
		double blancura;
		
		try {
			blancura = Double.parseDouble(txtBlancura.getText());
			
			if (blancura <= 0.0) { // validaci�n
				mensajeError("Debe ingresar un valor positivo para la Blancura", "Error en la lectura de la Blancura");
				blancura = blancuraInicial; // Regresa la blancura a su valor inicial
				txtBlancura.setText(blancuraInicial + ""); // Muestra en el cuadro de texto el valor inicial de la blancura
				txtBlancura.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor num�rico
			
			String strBlancura = txtBlancura.getText(); // Se obtiene el texto ingresado
			if (strBlancura.length() > 0) {
				mensajeError("No debe ingresar texto para el valor de la Blancura", "Error en la lectura de la Blancura");
			} else {
				// Se dej� en blanco el valor de la blancura
				mensajeError("No debe dejar en blanco el valor de la Blancura", "Error en la lectura de la Blancura");
			}
			blancura = blancuraInicial; // Regresa la blancura a su valor inicial
			txtBlancura.setText(blancura + ""); // Muestra en el cuadro de texto el valor inicial de la blancura
			txtBlancura.requestFocus();
			esCorrecto = false;
		}
		
		return blancura;
	}
	
	// Lee y retorna el precio
	double getPrecio() {
		double precio;
		
		try {
			precio = Double.parseDouble(txtPrecio.getText());
			
			if (precio <= 0.0) { // validaci�n
				mensajeError("Debe ingresar un valor positivo para el Precio", "Error en la lectura del Precio");
				precio = precioInicial; // Regresa el precio a su valor inicial
				txtPrecio.setText(precioInicial + ""); // Muestra en el cuadro de texto el valor inicial del precio
				txtPrecio.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor num�rico
			
			String strPrecio = txtPrecio.getText(); // Se obtiene el texto ingresado
			if (strPrecio.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Precio", "Error en la lectura del Precio");
			} else {
				// Se dej� en blanco el valor del precio
				mensajeError("No debe dejar en blanco el valor del Precio", "Error en la lectura del Precio");
			}
			precio = precioInicial; // Regresa el precio a su valor inicial
			txtPrecio.setText(precio + ""); // Muestra en el cuadro de texto el valor inicial del precio
			txtPrecio.requestFocus();
			esCorrecto = false;
		}
		
		return precio;
	}
	
	// Regresa los valores iniciales a los cuadros de texto
	void regresarValoresIniciales() {
		txtDimensiones.setText(dimensionInicial);
		txtBlancura.setText(blancuraInicial + "");
		txtGramaje.setText(gramajeInicial + "");
		txtPrecio.setText(precioInicial + "");
	}
	
	
	// Guarda las dimensiones, gramaje, blancura y precio de una marca de papel
	void guardarDatos(int marca, String dimensiones, double gramaje, double blancura, double precio) {
		
		switch (marca) {
			case 0:
				Tienda.dimensiones0 = dimensiones;
				Tienda.gramaje0 = gramaje;
				Tienda.blancura0 = blancura;
				Tienda.precio0 = precio;
				break;
				
			case 1:
				Tienda.dimensiones1 = dimensiones;
				Tienda.gramaje1 = gramaje;
				Tienda.blancura1 = blancura;
				Tienda.precio1 = precio;
				break;
				
			case 2:
				Tienda.dimensiones2 = dimensiones;
				Tienda.gramaje2 = gramaje;
				Tienda.blancura2 = blancura;
				Tienda.precio2 = precio;
				break;
				
			case 3:
				Tienda.dimensiones3 = dimensiones;
				Tienda.gramaje3 = gramaje;
				Tienda.blancura3 = blancura;
				Tienda.precio3 = precio;
				break;
				
			default:
				Tienda.dimensiones4 = dimensiones;
				Tienda.gramaje4 = gramaje;
				Tienda.blancura4 = blancura;
				Tienda.precio4 = precio;
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboMarca) {
			itemStateChangedComboBox(e);
		}
	}
	
	
	protected void itemStateChangedComboBox(ItemEvent e) {
		int marca = getMarca(); // Obtiene el �ndice de la marca de papel seleccionada
		mostrarDatos(marca);	// Muestra los datos de la marca de papel seleccionada
		guardarDatosIniciales(); // Guarda una copia de los valores iniciales antes de ser modificados
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje y t�tulo espec�fico
	void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}
