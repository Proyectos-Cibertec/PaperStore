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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

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
		setBounds(100, 100, 513, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(237, 197, 115));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNmeroDeCliente = new JLabel("N\u00FAmero de cliente");
		lblNmeroDeCliente.setForeground(Color.DARK_GRAY);
		lblNmeroDeCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNmeroDeCliente.setBounds(41, 75, 127, 23);
		contentPanel.add(lblNmeroDeCliente);
		
		lblPremioSorpresa = new JLabel("Premio sorpresa");
		lblPremioSorpresa.setForeground(Color.DARK_GRAY);
		lblPremioSorpresa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPremioSorpresa.setBounds(41, 109, 127, 23);
		contentPanel.add(lblPremioSorpresa);
		
		txtNumeroCliente = new JTextField();
		txtNumeroCliente.setForeground(Color.DARK_GRAY);
		txtNumeroCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNumeroCliente.setBounds(178, 74, 133, 23);
		contentPanel.add(txtNumeroCliente);
		txtNumeroCliente.setColumns(10);
		txtNumeroCliente.addActionListener(this);
		
		txtPremioSorpresa = new JTextField();
		txtPremioSorpresa.setForeground(Color.DARK_GRAY);
		txtPremioSorpresa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPremioSorpresa.setBounds(178, 108, 133, 23);
		contentPanel.add(txtPremioSorpresa);
		txtPremioSorpresa.setColumns(10);
		txtPremioSorpresa.addActionListener(this);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DialogoConfiguracionPremioSorpresa.class.getResource("/img/btnGrabar.png")));
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(20, 166, 148, 46);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(DialogoConfiguracionPremioSorpresa.class.getResource("/img/btnCancelar.png")));
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(178, 166, 152, 46);
		contentPanel.add(btnCancelar);
		
		lblTitulo = new JLabel("PREMIO SORPRESA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(76, 11, 354, 29);
		contentPanel.add(lblTitulo);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DialogoConfiguracionPremioSorpresa.class.getResource("/img/configurarSorpresa.png")));
		lblNewLabel.setBounds(351, 51, 133, 161);
		contentPanel.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Configuraci\u00F3n del premio sorpresa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 51, 324, 104);
		panel.setBackground(new Color(237, 197, 115));
		contentPanel.add(panel);
		
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
	private JLabel lblTitulo;
	private JLabel lblNewLabel;
	private JPanel panel;
	
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
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar los cambios efectuados?",
					"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
			
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
