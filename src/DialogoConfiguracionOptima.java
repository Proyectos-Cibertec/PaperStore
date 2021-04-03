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

public class DialogoConfiguracionOptima extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCantidadptimaDe;
	private JTextField txtCantidadTotalOptima;
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
			DialogoConfiguracionOptima dialog = new DialogoConfiguracionOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoConfiguracionOptima() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar cantidad \u00F3ptima de resmas vendidas");
		setBounds(100, 100, 448, 112);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCantidadptimaDe = new JLabel("Cantidad \u00F3ptima de resmas vendidas");
		lblCantidadptimaDe.setBounds(10, 11, 176, 14);
		contentPanel.add(lblCantidadptimaDe);
		
		txtCantidadTotalOptima = new JTextField();
		txtCantidadTotalOptima.setBounds(214, 8, 86, 20);
		contentPanel.add(txtCantidadTotalOptima);
		txtCantidadTotalOptima.setColumns(10);
		txtCantidadTotalOptima.addActionListener(this);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(344, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(344, 34, 89, 23);
		contentPanel.add(btnCancelar);
		
		mostrarCantidadTotalOptima(); // Muestra el valor de la cantidad total óptima de resmas vendidas
		guardarDatosIniciales(); // Guarda el valor inicial de la cantidad total óptima de resmas vendidas
	}
	
	// Variable que guarda el valor inicial de la cantidad total óptima de resmas vendidas
	int cantidadTotalOptimaInicial;
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		
		if (e.getSource() == btnAceptar || e.getSource() == txtCantidadTotalOptima) {
			actionPerformedBtnAceptar(e);
		}
	}
	
	// Procesa la pulsación del botón Aceptar
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		aceptar();
	}
	
	boolean esCorrecto; // Permite saber si el dato ingresado es correcto
	
	// Graba el nuevo valor para la cantidad óptima de resmas vendidas
	void aceptar() {
		esCorrecto = true; // Se asume que el dato ingresado es correcto
		
		// Declaración de variables
		int cantidadTotalOptima;
		
		// Entrada de datos
		cantidadTotalOptima = getCantidadTotalOptima();
		
		if (esCorrecto) {
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar el cambio efectuado?");
			
			if (respuesta == JOptionPane.YES_OPTION) {
				// Se cambia la cantidad total óptima de resmas vendidas
				cambiarCantidadTotalOptima(cantidadTotalOptima);
				JOptionPane.showMessageDialog(this, "Los datos fueron guardados correctamente");
				dispose();
			} else {
				regresaValoresIniciales();
			}
		}
	}
	
	// Lee y retorna la cantidad óptima de resmas vendidas
	int getCantidadTotalOptima() {
		int cantidadTotalOptima;
		
		try {
			cantidadTotalOptima = Integer.parseInt(txtCantidadTotalOptima.getText());
			
			if (cantidadTotalOptima <= 0) { // validación
				mensajeError("Debe ingresar un valor positivo para la Cantidad Total Óptima de Resmas Vendidas", 
						"Error en la lectura de la Cantidad Total Óptima de Resmas Vendidas");
				cantidadTotalOptima = cantidadTotalOptimaInicial; // Regresa la cantidad óptima a su valor inicial
				txtCantidadTotalOptima.setText(cantidadTotalOptima + ""); // Muestra en el cuadro de texto el valor inicial de la cantidad óptima
				txtCantidadTotalOptima.requestFocus();
				esCorrecto = false;
			}
			
		} catch (NumberFormatException e) { // Procesa el error que se genera al ingresar texto en vez de un valor numérico
			String strCantidadTotalOptima = txtCantidadTotalOptima.getText(); // Se obtiene el texto ingresado
			if (strCantidadTotalOptima.length() > 0) {
				mensajeError("No debe ingresar texto para el valor de la Cantidad Total Óptima de Resmas Vendidas", 
						"Error en la lectura de la Cantidad Total Óptima de Resmas Vendidas");
			} else {
				// Se dejó en blanco el valor de la cantidad total óptima de resmas vendidas
				mensajeError("No debe dejar en blanco el valor de la Cantidad Total Óptima de Resmas Vendidas", 
						"Error en la lectura de la Cantidad Total Óptima de Resmas Vendidas");
			}
			cantidadTotalOptima = cantidadTotalOptimaInicial; // Regresa la cantidad óptima a su valor inicial
			txtCantidadTotalOptima.setText(cantidadTotalOptima + ""); // Muestra en el cuadro de texto el valor inicial de la cantidad óptima
			txtCantidadTotalOptima.requestFocus();
			esCorrecto = false;
		}
		
		return cantidadTotalOptima;
	}
	
	// Cambia la cantidad óptima de resmas vendidas
	void cambiarCantidadTotalOptima(int cantidadTotalOptima) {
		Tienda.cantidadTotalOptima = cantidadTotalOptima;
	}
	
	// Obtiene la cantidad óptima de resmas vendidas y lo muestra en un cuadro de texto
	void mostrarCantidadTotalOptima() {
		txtCantidadTotalOptima.setText(Tienda.cantidadTotalOptima + "");
	}
	
	// Procesa la pulsación del botón Cancelar
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
	
	// Guarda el valor de la cantidad total óptima de resmas vendidas antes de ser modificado
	void guardarDatosIniciales() {
		cantidadTotalOptimaInicial = Integer.parseInt(txtCantidadTotalOptima.getText());
	}
	
	// Regresa el valor inicial de la cantidad total óptimade resmas vendidas al cuadro de texto
	void regresaValoresIniciales() {
		txtCantidadTotalOptima.setText(cantidadTotalOptimaInicial + "");
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje y título específico
	void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}
