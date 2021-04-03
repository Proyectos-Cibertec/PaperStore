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

public class DialogoConfiguracionDescuentos extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblA;
	private JLabel lblMsDe;
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
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
			DialogoConfiguracionDescuentos dialog = new DialogoConfiguracionDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Crea la GUI
	public DialogoConfiguracionDescuentos() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 469, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(237, 197, 115));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 resmas");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 80, 135, 23);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("6 a 10 resmas");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 114, 135, 23);
		contentPanel.add(lblNewLabel_1);
		
		lblA = new JLabel("11 a 15 resmas");
		lblA.setForeground(Color.DARK_GRAY);
		lblA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblA.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblA.setBounds(20, 148, 135, 23);
		contentPanel.add(lblA);
		
		lblMsDe = new JLabel("M\u00E1s de 15 resmas");
		lblMsDe.setForeground(Color.DARK_GRAY);
		lblMsDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMsDe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMsDe.setBounds(20, 182, 135, 23);
		contentPanel.add(lblMsDe);
		
		txtPorcentaje1 = new JTextField();
		txtPorcentaje1.setForeground(Color.DARK_GRAY);
		txtPorcentaje1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPorcentaje1.setBounds(178, 80, 86, 23);
		contentPanel.add(txtPorcentaje1);
		txtPorcentaje1.setColumns(10);
		txtPorcentaje1.addActionListener(this);
		
		txtPorcentaje2 = new JTextField();
		txtPorcentaje2.setForeground(Color.DARK_GRAY);
		txtPorcentaje2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPorcentaje2.setBounds(178, 114, 86, 23);
		contentPanel.add(txtPorcentaje2);
		txtPorcentaje2.setColumns(10);
		txtPorcentaje2.addActionListener(this);
		
		txtPorcentaje3 = new JTextField();
		txtPorcentaje3.setForeground(Color.DARK_GRAY);
		txtPorcentaje3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPorcentaje3.setBounds(178, 149, 86, 23);
		contentPanel.add(txtPorcentaje3);
		txtPorcentaje3.setColumns(10);
		txtPorcentaje3.addActionListener(this);
		
		txtPorcentaje4 = new JTextField();
		txtPorcentaje4.setForeground(Color.DARK_GRAY);
		txtPorcentaje4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPorcentaje4.setBounds(178, 183, 86, 23);
		contentPanel.add(txtPorcentaje4);
		txtPorcentaje4.setColumns(10);
		txtPorcentaje4.addActionListener(this);
		
		label = new JLabel("%");
		label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label.setBounds(274, 80, 46, 23);
		contentPanel.add(label);
		
		label_1 = new JLabel("%");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_1.setBounds(274, 114, 46, 23);
		contentPanel.add(label_1);
		
		label_2 = new JLabel("%");
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_2.setBounds(274, 148, 46, 23);
		contentPanel.add(label_2);
		
		label_3 = new JLabel("%");
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_3.setBounds(274, 182, 46, 23);
		contentPanel.add(label_3);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DialogoConfiguracionDescuentos.class.getResource("/img/btnGrabar.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(20, 234, 135, 46);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(DialogoConfiguracionDescuentos.class.getResource("/img/btnCancelar.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(165, 234, 140, 46);
		contentPanel.add(btnCancelar);
		
		lblIcono = new JLabel("New label");
		lblIcono.setIcon(new ImageIcon(DialogoConfiguracionDescuentos.class.getResource("/img/configuracionDescuentos.png")));
		lblIcono.setBounds(315, 63, 133, 128);
		contentPanel.add(lblIcono);
		
		lblTitulo = new JLabel("CONFIGURACI\u00D3N DE DESCUENTOS");
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(10, 11, 428, 29);
		contentPanel.add(lblTitulo);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Porcentajes de descuento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(237, 197, 115));
		panel.setBounds(20, 51, 285, 172);
		contentPanel.add(panel);
		
		mostrarPorcentajes(); // Obtiene y muestra los valores de los porcentajes en los cuadros de texto
		guardarDatosIniciales(); // Guarda los valores iniciales de los porcentajes
	}

	// Variables que guardan los valores iniciales de los porcentajes
	double porcentajeInicial1, porcentajeInicial2, porcentajeInicial3, porcentajeInicial4;
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		
		if (e.getSource() == btnAceptar ||
			e.getSource() == txtPorcentaje1 ||
			e.getSource() == txtPorcentaje2 ||
			e.getSource() == txtPorcentaje3 ||
			e.getSource() == txtPorcentaje4) {
			
			actionPerformedBtnAceptar(e);
		}
	}
	
	// Procesa la pulsación del botón Aceptar
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		aceptar();
	}
	
	boolean esCorrecto; // Permite saber si los datos ingresados son todos correctos
	private JLabel lblIcono;
	private JLabel lblTitulo;
	private JPanel panel;
	
	// Graba los nuevos valores para los porcentajes 
	void aceptar() {
		esCorrecto = true; // Se asume que los datos ingresados son correctos
		
		// Declaración de variables
		double porcentaje1, porcentaje2, porcentaje3, porcentaje4;
		
		// Entrada de datos
		porcentaje1 = getPorcentaje1();
		porcentaje2 = getPorcentaje2();
		porcentaje3 = getPorcentaje3();
		porcentaje4 = getPorcentaje4();
	
		// Se cambian los porcentajes
		if (esCorrecto) {
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar los cambios efectuados?",
					"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
			
			if (respuesta == JOptionPane.YES_OPTION) {
				cambiarPorcentajes(porcentaje1, porcentaje2, porcentaje3, porcentaje4);
				JOptionPane.showMessageDialog(this, "Los datos fueron guardados correctamente");
				dispose();
			} else {
				regresarValoresIniciales();
			}
		}
	}
	
	// Lee y retorna el porcentaje1
	double getPorcentaje1() {
		double porcentaje1;
		
		try {
			porcentaje1 = Double.parseDouble(txtPorcentaje1.getText());
			
			if (porcentaje1 < 0.0 || porcentaje1 > 100) { // validación
				mensajeError("Error en la lectura del Porcentaje 1");
				porcentaje1 = porcentajeInicial1; // Regresa el porcentaje1 a su valor inicial
				txtPorcentaje1.setText(porcentaje1 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje1
				txtPorcentaje1.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor numérico
			String strPorcentaje1 = txtPorcentaje1.getText(); // Se obtiene el texto ingresado
			if (strPorcentaje1.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Porcentaje 1", "Error en la lectura del Porcentaje 1");
			} else {
				// Se dejó en blanco el valor del porcentaje1
				mensajeError("No debe dejar en blanco el valor del Porcentaje 1", "Error en la lectura del Porcentaje 1");
			}
			porcentaje1 = porcentajeInicial1; // Regresa el porcentaje1 a su valor inicial
			txtPorcentaje1.setText(porcentaje1 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje1
			txtPorcentaje1.requestFocus();
			esCorrecto = false;
		}
		
		return porcentaje1;
	}
	
	// Lee y retorna el porcentaje2
	double getPorcentaje2() {
		double porcentaje2;
		
		try {
			porcentaje2 = Double.parseDouble(txtPorcentaje2.getText());
			
			if (porcentaje2 < 0.0 || porcentaje2 > 100) { // validación
				mensajeError("Error en la lectura del Porcentaje 2");
				porcentaje2 = porcentajeInicial2; // Regresa el porcentaje2 a su valor inicial
				txtPorcentaje2.setText(porcentaje2 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje2
				txtPorcentaje2.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor numérico
			String strPorcentaje2 = txtPorcentaje2.getText(); // Se obtiene el texto ingresado
			if (strPorcentaje2.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Porcentaje 2", "Error en la lectura del Porcentaje 2");
			} else {
				// Se dejó en blanco el valor del porcentaje2
				mensajeError("No debe dejar en blanco el valor del Porcentaje 2", "Error en la lectura del Porcentaje 2");
			}
			porcentaje2 = porcentajeInicial2; // Regresa el porcentaje2 a su valor inicial
			txtPorcentaje2.setText(porcentaje2 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje2
			txtPorcentaje2.requestFocus();
			esCorrecto = false;
		}
		
		return porcentaje2;
	}
	
	// Lee y retorna el porcentaje3
	double getPorcentaje3() {
		double porcentaje3;
		
		try {
			porcentaje3 = Double.parseDouble(txtPorcentaje3.getText());
			
			if (porcentaje3 < 0.0 || porcentaje3 > 100) { // validación
				mensajeError("Error en la lectura del Porcentaje 3");
				porcentaje3 = porcentajeInicial3; // Regresa el porcentaje3 a su valor inicial
				txtPorcentaje3.setText(porcentaje3 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje3
				txtPorcentaje3.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor numérico
			String strPorcentaje3 = txtPorcentaje3.getText(); // Se obtiene el texto ingresado
			if (strPorcentaje3.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Porcentaje 3", "Error en la lectura del Porcentaje 3");
			} else {
				// Se dejó en blanco el valor del porcentaje3
				mensajeError("No debe dejar en blanco el valor del Porcentaje 3", "Error en la lectura del Porcentaje 3");
			}
			porcentaje3 = porcentajeInicial3; // Regresa el porcentaje3 a su valor inicial
			txtPorcentaje3.setText(porcentaje3 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje3
			txtPorcentaje3.requestFocus();
			esCorrecto = false;
		}
		
		return porcentaje3;
	}
	
	// Lee y retorna el porcentaje4
	double getPorcentaje4() {
		double porcentaje4;
		
		try {
			porcentaje4 = Double.parseDouble(txtPorcentaje4.getText());
			
			if (porcentaje4 < 0.0 || porcentaje4  > 100) { // validación
				mensajeError("Error en la lectura del Porcentaje 4");
				porcentaje4 = porcentajeInicial4; // Regresa el porcentaje4 a su valor inicial
				txtPorcentaje4.setText(porcentaje4 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje4
				txtPorcentaje4.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor numérico
			String strPorcentaje4 = txtPorcentaje4.getText(); // Se obtiene el texto ingresado
			if (strPorcentaje4.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Porcentaje 4", "Error en la lectura del Porcentaje 4");
			} else {
				// Se dejó en blanco el valor del porcentaje4
				mensajeError("No debe dejar en blanco el valor del Porcentaje 4", "Error en la lectura del Porcentaje 4");
			}
			porcentaje4 = porcentajeInicial4; // Regresa el porcentaje4 a su valor inicial
			txtPorcentaje4.setText(porcentaje4 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje4
			txtPorcentaje4.requestFocus();
			esCorrecto = false;
		}
		
		return porcentaje4;
	}
	
	// Cambia los valores de los porcentajes por defecto
	void cambiarPorcentajes(double porcentaje1, double porcentaje2, double porcentaje3, double porcentaje4) {
		Tienda.porcentaje1 = porcentaje1;
		Tienda.porcentaje2 = porcentaje2;
		Tienda.porcentaje3 = porcentaje3;
		Tienda.porcentaje4 = porcentaje4;
	}
	
	// Obtiene y muestra los valores de los porcentajes en los cuadros de texto
	void mostrarPorcentajes() {
		txtPorcentaje1.setText(Tienda.porcentaje1 + "");
		txtPorcentaje2.setText(Tienda.porcentaje2 + "");
		txtPorcentaje3.setText(Tienda.porcentaje3 + "");
		txtPorcentaje4.setText(Tienda.porcentaje4 + "");
	}
	
	// Procesa la pulsación del botón Cancelar
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
	
	// Guarda los valores iniciales de los porcentajes antes de ser modificados
	void guardarDatosIniciales() {
		porcentajeInicial1 = Double.parseDouble(txtPorcentaje1.getText()); // Guarda el valor inicial de porcentaje1
		porcentajeInicial2 = Double.parseDouble(txtPorcentaje2.getText()); // Guarda el valor inicial de porcentaje2
		porcentajeInicial3 = Double.parseDouble(txtPorcentaje3.getText()); // Guarda el valor inicial de porcentaje3
		porcentajeInicial4 = Double.parseDouble(txtPorcentaje4.getText()); // Guarda el valor inicial de porcentaje4
	}
	
	// Regresa los valores iniciales a los cuadros de texto
	void regresarValoresIniciales() {
		txtPorcentaje1.setText(porcentajeInicial1 + "");
		txtPorcentaje2.setText(porcentajeInicial2 + "");
		txtPorcentaje3.setText(porcentajeInicial3 + "");
		txtPorcentaje4.setText(porcentajeInicial4 + "");
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje por defecto y un título específico
	void mensajeError(String titulo) {
		mensajeError("Debe ingresar un porcentaje válido desde 0% hasta 100%", titulo);
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje y título específico
	void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}