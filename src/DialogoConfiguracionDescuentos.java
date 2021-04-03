

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

public class DialogoConfiguracionDescuentos extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaraci�n de variables
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

	// Lanza la aplicaci�n
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
		setBounds(100, 100, 358, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 resmas");
		lblNewLabel.setBounds(10, 11, 61, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("6 a 10 resmas");
		lblNewLabel_1.setBounds(10, 36, 67, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblA = new JLabel("11 a 15 resmas");
		lblA.setBounds(10, 61, 73, 14);
		contentPanel.add(lblA);
		
		lblMsDe = new JLabel("M\u00E1s de 15 resmas");
		lblMsDe.setBounds(10, 86, 86, 14);
		contentPanel.add(lblMsDe);
		
		txtPorcentaje1 = new JTextField();
		txtPorcentaje1.setBounds(112, 8, 86, 20);
		contentPanel.add(txtPorcentaje1);
		txtPorcentaje1.setColumns(10);
		txtPorcentaje1.addActionListener(this);
		
		txtPorcentaje2 = new JTextField();
		txtPorcentaje2.setBounds(112, 33, 86, 20);
		contentPanel.add(txtPorcentaje2);
		txtPorcentaje2.setColumns(10);
		txtPorcentaje2.addActionListener(this);
		
		txtPorcentaje3 = new JTextField();
		txtPorcentaje3.setBounds(112, 58, 86, 20);
		contentPanel.add(txtPorcentaje3);
		txtPorcentaje3.setColumns(10);
		txtPorcentaje3.addActionListener(this);
		
		txtPorcentaje4 = new JTextField();
		txtPorcentaje4.setBounds(112, 83, 86, 20);
		contentPanel.add(txtPorcentaje4);
		txtPorcentaje4.setColumns(10);
		txtPorcentaje4.addActionListener(this);
		
		label = new JLabel("%");
		label.setBounds(208, 11, 46, 14);
		contentPanel.add(label);
		
		label_1 = new JLabel("%");
		label_1.setBounds(208, 36, 46, 14);
		contentPanel.add(label_1);
		
		label_2 = new JLabel("%");
		label_2.setBounds(208, 61, 46, 14);
		contentPanel.add(label_2);
		
		label_3 = new JLabel("%");
		label_3.setBounds(208, 86, 46, 14);
		contentPanel.add(label_3);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(254, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(254, 32, 89, 23);
		contentPanel.add(btnCancelar);
		
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
	
	// Procesa la pulsaci�n del bot�n Aceptar
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		aceptar();
	}
	
	boolean esCorrecto; // Permite saber si los datos ingresados son todos correctos
	
	// Graba los nuevos valores para los porcentajes 
	void aceptar() {
		esCorrecto = true; // Se asume que los datos ingresados son correctos
		
		// Declaraci�n de variables
		double porcentaje1, porcentaje2, porcentaje3, porcentaje4;
		
		// Entrada de datos
		porcentaje1 = getPorcentaje1();
		porcentaje2 = getPorcentaje2();
		porcentaje3 = getPorcentaje3();
		porcentaje4 = getPorcentaje4();
	
		// Se cambian los porcentajes
		if (esCorrecto) {
			int respuesta = JOptionPane.showConfirmDialog(this, "�Seguro que desea guardar los cambios efectuados?",
					"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
			
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
			
			if (porcentaje1 < 0.0 || porcentaje1 > 100) { // validaci�n
				mensajeError("Error en la lectura del Porcentaje 1");
				porcentaje1 = porcentajeInicial1; // Regresa el porcentaje1 a su valor inicial
				txtPorcentaje1.setText(porcentaje1 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje1
				txtPorcentaje1.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor num�rico
			String strPorcentaje1 = txtPorcentaje1.getText(); // Se obtiene el texto ingresado
			if (strPorcentaje1.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Porcentaje 1", "Error en la lectura del Porcentaje 1");
			} else {
				// Se dej� en blanco el valor del porcentaje1
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
			
			if (porcentaje2 < 0.0 || porcentaje2 > 100) { // validaci�n
				mensajeError("Error en la lectura del Porcentaje 2");
				porcentaje2 = porcentajeInicial2; // Regresa el porcentaje2 a su valor inicial
				txtPorcentaje2.setText(porcentaje2 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje2
				txtPorcentaje2.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor num�rico
			String strPorcentaje2 = txtPorcentaje2.getText(); // Se obtiene el texto ingresado
			if (strPorcentaje2.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Porcentaje 2", "Error en la lectura del Porcentaje 2");
			} else {
				// Se dej� en blanco el valor del porcentaje2
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
			
			if (porcentaje3 < 0.0 || porcentaje3 > 100) { // validaci�n
				mensajeError("Error en la lectura del Porcentaje 3");
				porcentaje3 = porcentajeInicial3; // Regresa el porcentaje3 a su valor inicial
				txtPorcentaje3.setText(porcentaje3 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje3
				txtPorcentaje3.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor num�rico
			String strPorcentaje3 = txtPorcentaje3.getText(); // Se obtiene el texto ingresado
			if (strPorcentaje3.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Porcentaje 3", "Error en la lectura del Porcentaje 3");
			} else {
				// Se dej� en blanco el valor del porcentaje3
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
			
			if (porcentaje4 < 0.0 || porcentaje4  > 100) { // validaci�n
				mensajeError("Error en la lectura del Porcentaje 4");
				porcentaje4 = porcentajeInicial4; // Regresa el porcentaje4 a su valor inicial
				txtPorcentaje4.setText(porcentaje4 + ""); // Muestra en el cuadro de texto el valor inicial del porcentaje4
				txtPorcentaje4.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor num�rico
			String strPorcentaje4 = txtPorcentaje4.getText(); // Se obtiene el texto ingresado
			if (strPorcentaje4.length() > 0) {
				mensajeError("No debe ingresar texto para el valor del Porcentaje 4", "Error en la lectura del Porcentaje 4");
			} else {
				// Se dej� en blanco el valor del porcentaje4
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
	
	// Procesa la pulsaci�n del bot�n Cancelar
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose(); // Cierra el cuadro de di�logo
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
	
	// Muestra un mensaje de error en la pantalla con un mensaje por defecto y un t�tulo espec�fico
	void mensajeError(String titulo) {
		mensajeError("Debe ingresar un porcentaje v�lido desde 0% hasta 100%", titulo);
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje y t�tulo espec�fico
	void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}