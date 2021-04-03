package ventanas;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class DialogoConfiguracionObsequio extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCantidadMnimaDe;
	private JLabel lblObsequio;
	private JTextField txtCantidadMinima;
	private JTextField txtObsequio;
	private JButton btnAceptar;
	private JButton btnCancelar;

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoConfiguracionObsequio dialog = new DialogoConfiguracionObsequio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoConfiguracionObsequio() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar obsequio");
		setBounds(100, 100, 745, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(237, 197, 115));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCantidadMnimaDe = new JLabel("Cantidad m\u00EDnima de resmas adquiridas");
		lblCantidadMnimaDe.setForeground(Color.DARK_GRAY);
		lblCantidadMnimaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadMnimaDe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCantidadMnimaDe.setBounds(40, 87, 280, 23);
		contentPanel.add(lblCantidadMnimaDe);
		
		lblObsequio = new JLabel("Obsequio");
		lblObsequio.setForeground(Color.DARK_GRAY);
		lblObsequio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObsequio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblObsequio.setBounds(40, 121, 280, 23);
		contentPanel.add(lblObsequio);
		
		txtCantidadMinima = new JTextField();
		txtCantidadMinima.setForeground(Color.DARK_GRAY);
		txtCantidadMinima.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCantidadMinima.setBounds(330, 87, 86, 23);
		contentPanel.add(txtCantidadMinima);
		txtCantidadMinima.setColumns(10);
		txtCantidadMinima.addActionListener(this);
		
		txtObsequio = new JTextField();
		txtObsequio.setForeground(Color.DARK_GRAY);
		txtObsequio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtObsequio.setBounds(330, 121, 86, 23);
		contentPanel.add(txtObsequio);
		txtObsequio.setColumns(10);
		txtObsequio.addActionListener(this);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DialogoConfiguracionObsequio.class.getResource("/img/btnGrabar.png")));
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(448, 64, 135, 46);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(DialogoConfiguracionObsequio.class.getResource("/img/btnCancelar.png")));
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(448, 121, 135, 46);
		contentPanel.add(btnCancelar);
		
		lblTitulo = new JLabel("CONFIGURACI\u00D3N DE OBSEQUIO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(155, 11, 428, 29);
		contentPanel.add(lblTitulo);
		
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(DialogoConfiguracionObsequio.class.getResource("/img/configurarObsequio.png")));
		lblIcono.setBounds(591, 42, 138, 143);
		contentPanel.add(lblIcono);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Configuraci\u00F3n del obsequio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(237, 197, 115));
		panel.setBounds(30, 64, 412, 105);
		contentPanel.add(panel);
		
		mostrarCantidadObsequiable(); // Obtiene y muestra la Cantidad Obsequiable en el cuadro de texto
		mostrarObsequio(); 			  // Obtiene y muestra el Obsequio en el cuadro de texto
		guardarDatosIniciales();	  // Guarda los valores iniciales de la Cantidad Obsequiable y el Obsequio
	}
	
	// Variables que guardan los valores iniciales Cantidad Obsequiable y Obsequio 
	int cantidadObsequiableInicial;
	String obsequioInicial;

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar || e.getSource() == txtCantidadMinima || e.getSource() == txtObsequio) {
			actionPerformedBtnAceptar(e);
		}
	}
	
	// Procesa la pulsación del botón Aceptar
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		aceptar();
	}
	
	boolean esCorrecto; // Permite saber si los datos ingresados son todos correctos
	private JLabel lblTitulo;
	private JLabel lblIcono;
	private JPanel panel;
	
	// Graba los nuevos valores para el obsequio
	void aceptar() {
		esCorrecto = true; // Se asume que los datos ingresados son correctos
		
		// Declaración de variables
		int cantidadObsequiable;
		String obsequio;
		
		// Entrada de datos
		cantidadObsequiable = getCantidadObsequiable();
		obsequio = getObsequio();
		
		// Se guardan los cambios efectuados
		if (esCorrecto) {
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar los cambios efectuados?",
					"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
			
			if (respuesta == JOptionPane.YES_OPTION) {
				// Se cambia la cantidad obsequiable y el obsequio
				cambiarCantidadObsequiable(cantidadObsequiable);
				cambiarObsequio(obsequio);
				JOptionPane.showMessageDialog(this, "Los datos fueron guardados correctamente");
				dispose();
			} else {
				regresarValoresIniciales();
			}
		}
	}

	// Lee y retorna la Cantidad Obsequiable (cantidad mínima de resmas adquiridas para acceder al obsequio)
	int getCantidadObsequiable() {
		int cantidadObsequiable;
		
		try {
			cantidadObsequiable = Integer.parseInt(txtCantidadMinima.getText());
			
			if (cantidadObsequiable <= 0) { // validación
				mensajeError("Debe ingresar un valor positivo para la Cantidad Obsequiable", 
						"Error en la lectura de la Cantidad Obsequiable");
				cantidadObsequiable = cantidadObsequiableInicial; // Regresa la cantidad obsequiable a su valor inicial
				txtCantidadMinima.setText(cantidadObsequiable + ""); // Muestra en el cuadro de texto el valor inicial de la cantidad obsequiable
				txtCantidadMinima.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor numérico
			String strCantidadObsequiable = txtCantidadMinima.getText(); // Se obtiene el texto ingresado
			if (strCantidadObsequiable.length() > 0) {
				mensajeError("No debe ingresar texto para el valor de la Cantidad Obsequiable", 
						"Error en la lectura de la Cantidad Obsequiable");
			} else {
				// Se dejó en blanco el valor de la cantidad obsequiable
				mensajeError("No debe dejar en blanco el valor de la Cantidad Obsequiable", 
						"Error en la lectura de la Cantidad Obsequiable");
			}
			cantidadObsequiable = cantidadObsequiableInicial; // Regresa la cantidad obsequiable a su valor inicial
			txtCantidadMinima.setText(cantidadObsequiable + ""); // Muestra en el cuadro de texto el valor inicial de la cantidad obsequiable
			txtCantidadMinima.requestFocus();
			esCorrecto = false;
		}
		
		return cantidadObsequiable;
	}
	
	// Lee y retorna el obsequio
	String getObsequio() {
		String obsequio;
		
		obsequio = txtObsequio.getText();
		if (obsequio.length() == 0) {
			// Se dejó en blanco el valor del obsequio
			mensajeError("No debe dejar en blanco el valor del Obsequio", "Error en la lectura del Obsequio");
			obsequio = obsequioInicial; // Regresa el obsequio a su valor inicial
			txtObsequio.setText(obsequio); // Muestra en el cuadro de texto el valor inicial del obsequio
			txtObsequio.requestFocus();
			esCorrecto = false;
		}
		
		return obsequio;
	}
	
	// Cambia la cantidad obsequiable
	void cambiarCantidadObsequiable(int cantidadObsequiable) {
		Tienda.cantidadObsequiable = cantidadObsequiable;
	}
	
	// Cambia el obsequio
	void cambiarObsequio(String obsequio) {
		Tienda.obsequio = obsequio;
	}
	
	// Obtiene la cantidad obsequiable y lo muestra en un cuadro de texto
	void mostrarCantidadObsequiable() {
		txtCantidadMinima.setText(Tienda.cantidadObsequiable + "");
	}
	
	// Obtiene el obsequio y lo muestra en un cuadro de texto
	void mostrarObsequio() {
		txtObsequio.setText(Tienda.obsequio + "");
	}
	
	// Procesa la pulsación del botón Cancelar
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
	
	// Guarda los valores iniciales de la Cantidad Obsequiable y el Obsequio 
	void guardarDatosIniciales() {
		cantidadObsequiableInicial = Integer.parseInt(txtCantidadMinima.getText());
		obsequioInicial = txtObsequio.getText();
	}
	
	// Regresa los valores iniciales a los cuadros de texto
	void regresarValoresIniciales() {
		txtCantidadMinima.setText("" + cantidadObsequiableInicial);
		txtObsequio.setText(obsequioInicial);
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje y título específico
		void mensajeError(String mensaje, String titulo) {
			JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		}
}
