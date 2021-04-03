import java.awt.BorderLayout;

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
		setBounds(100, 100, 499, 101);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCantidadMnimaDe = new JLabel("Cantidad m\u00EDnima de resmas adquiridas");
		lblCantidadMnimaDe.setBounds(10, 11, 182, 14);
		contentPanel.add(lblCantidadMnimaDe);
		
		lblObsequio = new JLabel("Obsequio");
		lblObsequio.setBounds(10, 36, 45, 14);
		contentPanel.add(lblObsequio);
		
		txtCantidadMinima = new JTextField();
		txtCantidadMinima.setBounds(226, 8, 86, 20);
		contentPanel.add(txtCantidadMinima);
		txtCantidadMinima.setColumns(10);
		txtCantidadMinima.addActionListener(this);
		
		txtObsequio = new JTextField();
		txtObsequio.setBounds(226, 33, 86, 20);
		contentPanel.add(txtObsequio);
		txtObsequio.setColumns(10);
		txtObsequio.addActionListener(this);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(395, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(395, 32, 89, 23);
		contentPanel.add(btnCancelar);
		
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
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar los cambios efectuados?");
			
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
