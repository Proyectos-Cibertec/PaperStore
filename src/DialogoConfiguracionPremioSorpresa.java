

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import java.awt.Font;

public class DialogoConfiguracionPremioSorpresa extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNmeroDeCliente;
	private JLabel lblPremioSorpresa;
	private JTextField txtNumeroCliente;
	private JTextField txtPremioSorpresa;
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
			DialogoConfiguracionPremioSorpresa dialog = new DialogoConfiguracionPremioSorpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoConfiguracionPremioSorpresa() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar premio sorpresa");
		setBounds(100, 100, 398, 103);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNmeroDeCliente = new JLabel("N\u00FAmero de cliente");
		lblNmeroDeCliente.setBounds(10, 11, 86, 14);
		contentPanel.add(lblNmeroDeCliente);
		
		lblPremioSorpresa = new JLabel("Premio sorpresa");
		lblPremioSorpresa.setBounds(10, 36, 77, 14);
		contentPanel.add(lblPremioSorpresa);
		
		txtNumeroCliente = new JTextField();
		txtNumeroCliente.setBounds(106, 8, 133, 20);
		contentPanel.add(txtNumeroCliente);
		txtNumeroCliente.setColumns(10);
		txtNumeroCliente.addActionListener(this);
		
		txtPremioSorpresa = new JTextField();
		txtPremioSorpresa.setBounds(106, 36, 133, 20);
		contentPanel.add(txtPremioSorpresa);
		txtPremioSorpresa.setColumns(10);
		txtPremioSorpresa.addActionListener(this);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(274, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(274, 32, 89, 23);
		contentPanel.add(btnCancelar);
		
		mostrarNumeroClienteSorpresa(); // obtiene el número cliente sorpresa y lo muestra en un cuadro de texto
		mostrarPremioSorpresa(); // obtiene el premio sorpresa y lo muestra en un cuadro de texto
		guardarDatosIniciales(); // Guarda los valores iniciales de: número de cliente sorpresa y premio sorpresa
	}

	// Variables que guardan los valores iniciales del número de cliente sorpresa y del premio sorpresa
	int numeroClienteInicial;
	String premioSorpresaInicial;
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar || 
			e.getSource() == txtNumeroCliente ||
			e.getSource() == txtPremioSorpresa) {
			
			actionPerformedBtnAceptar(e);
		}
	}
	
	// Procesa la pulsación del botón Aceptar
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		aceptar();			
	}
	
	boolean esCorrecto; // Permite saber si los datos ingresados son correctos
	
	// Graba los nuevos valores para el número de cliente sorpresa y el premio sorpresa
	void aceptar() {
		esCorrecto = true; // Se asume que los datos ingresados son correctos
		
		// Declaración de variables
		int numeroCliente;
		String premioSorpresa;
		
		// Entrada de datos
		numeroCliente = getNumeroCliente();
		premioSorpresa = getPremioSorpresa();
		
		if (esCorrecto) {
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar los cambios efectuados?");
			
			if (respuesta == JOptionPane.YES_OPTION) {
				// Se modifica el número de cliente sorpresa y el premio sorpresa
				cambiarNumeroClienteSorpresa(numeroCliente);
				cambiarPremioSorpresa(premioSorpresa);
				JOptionPane.showMessageDialog(this, "Los datos fueron guardados correctamente");
				dispose();
			} else {
				regresaValoresIniciales();
			}
		}
	}
	
	// Lee y retorna el número del cliente sorpresa
	int getNumeroCliente() {
		int numeroClienteSorpresa;
		
		try {
			numeroClienteSorpresa = Integer.parseInt(txtNumeroCliente.getText());
			
			if (numeroClienteSorpresa <= 0) { // validación
				mensajeError("Debe ingresar un valor positivo para el Número de Cliente Sorpresa", 
						"Error en la lectura del Número de Cliente Sorpresa");
				numeroClienteSorpresa = numeroClienteInicial; // Regresa el número de cliente sorpresa a su valor inicial
				txtNumeroCliente.setText(numeroClienteSorpresa + ""); // Muestra en el cuadro de texto el valor inicial del número de cliente sorpresa
				txtNumeroCliente.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor numérico
			String strNumeroCliente = txtNumeroCliente.getText(); // Se obtiene el texto ingresado
			if (strNumeroCliente.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Número de Cliente Sorpresa", 
						"Error en la lectura del Número de Cliente Sorpresa");
			} else {
				// Se dejó en blanco el valor del gramaje
				mensajeError("No debe dejar en blanco el valor del Número de Cliente Sorpresa", 
						"Error en la lectura del Número de Cliente Sorpresa");
			}
			numeroClienteSorpresa = numeroClienteInicial; // Regresa el número de cliente sorpresa a su valor inicial
			txtNumeroCliente.setText(numeroClienteSorpresa + ""); // Muestra en el cuadro de texto el valor inicial del número de cliente sorpresa
			txtNumeroCliente.requestFocus();
			esCorrecto = false;
		}
		
		return numeroClienteSorpresa;
		
	}
	
	// Lee y retorna el premio sorpresa
	String getPremioSorpresa() {
		String premioSorpresa;
		
		premioSorpresa = txtPremioSorpresa.getText();
		if (premioSorpresa.length() == 0) {
			// Se dejó en blanco el valor del Premio Sorpresa
			mensajeError("No debe dejar en blanco el valor correspondiente al Premio Sorpresa", 
					"Error en la lectura del Premio Sorpresa");
			premioSorpresa = premioSorpresaInicial; // Regresa el premio sorpresa a su valor inicial
			txtPremioSorpresa.setText(premioSorpresa); // Muestra en el cuadro de texto el valor inicial del premio sorpresa
			txtPremioSorpresa.requestFocus();
			esCorrecto = false;
		}
		
		return premioSorpresa;
	}
	
	// Cambia el número cliente sorpresa
	void cambiarNumeroClienteSorpresa(int numeroCliente) {
		Tienda.numeroClienteSorpresa = numeroCliente;
	}
	
	// Cambia el premio sorpresa
	void cambiarPremioSorpresa(String premioSorpresa) {
		Tienda.premioSorpresa = premioSorpresa;
	}
	
	// Obtiene el número cliente sorpresa y lo muestra en un cuadro de texto
	void mostrarNumeroClienteSorpresa() {
		txtNumeroCliente.setText(Tienda.numeroClienteSorpresa + "");
	}
	
	// Obtiene el premio sorpresa y lo muestra en un cuadro de texto
	void mostrarPremioSorpresa() {
		txtPremioSorpresa.setText(Tienda.premioSorpresa + "");
	}
	
	// Procesa la pulsación del botón Cancelar
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
	
	// Guarda los valores de numero de cliente sorpresa y premio sorpresa antes de ser modificados
	void guardarDatosIniciales() {
		numeroClienteInicial = Integer.parseInt(txtNumeroCliente.getText());
		premioSorpresaInicial = txtPremioSorpresa.getText();
	}
	
	// Regresa los valores iniciales a los cuadros de texto
	void regresaValoresIniciales() {
		txtNumeroCliente.setText("" + numeroClienteInicial);
		txtPremioSorpresa.setText("" + premioSorpresaInicial);
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje y título específico
	void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}
