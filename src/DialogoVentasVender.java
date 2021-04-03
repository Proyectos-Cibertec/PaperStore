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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DialogoVentasVender extends JDialog implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblMarca;
	private JLabel lblCantidadDeResmas;
	private JComboBox<String> cboMarca;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		try {
			DialogoVentasVender dialog = new DialogoVentasVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoVentasVender() {
		setModal(true);
		setResizable(false);
		setTitle("Vender");
		setBounds(100, 100, 507, 349);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 29, 14);
		contentPanel.add(lblMarca);
		
		lblCantidadDeResmas = new JLabel("Cantidad de resmas");
		lblCantidadDeResmas.setBounds(10, 36, 95, 14);
		contentPanel.add(lblCantidadDeResmas);
		
		cboMarca = new JComboBox<String>();
		cboMarca.addItemListener(this);
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Class Bond", "Copy Premium", "Master Bond", "Vision Bond", "Copy Paper"}));
		cboMarca.setBounds(115, 8, 176, 20);
		contentPanel.add(cboMarca);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(115, 33, 176, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		txtCantidad.addActionListener(this);
		
		btnVender = new JButton("Vender");
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVender.addActionListener(this);
		btnVender.setBounds(406, 7, 89, 23);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(406, 32, 89, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 481, 246);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Consolas", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVender || e.getSource() == txtCantidad) {
			actionPerformedBtnVender(e);
		}
	}
	
	// Procesa la pulsación del botón Vender
	protected void actionPerformedBtnVender(ActionEvent e) {
		vender();
	}
	
	// Método que realiza la venta
	void vender() {
		try {
			// Declaración de variables locales
			int marcaPapel, cantidadResmas;
			double importeCompra, importeDescuento, importePagar, precioResma;
			String obsequio, premioSorpresa;
			
			// Entrada de datos
			marcaPapel = getMarcaPapel();
			cantidadResmas = getCantidadResmas();
		
			if (cantidadResmas > 0) { // Validación
				
				// Proceso de cálculo
				precioResma = getPrecioResma(marcaPapel);
				importeCompra = calcularImporteCompra(precioResma, cantidadResmas);
				importeDescuento = calcularImporteDescuento(importeCompra, cantidadResmas);
				importePagar = calcularImportePagar(importeCompra, importeDescuento);
				obsequio = calcularObsequio(cantidadResmas);
				
				// Contabiliza la venta efectuada
				contabilizarVenta(marcaPapel, cantidadResmas, importePagar);
				
				premioSorpresa = calcularPremioSorpresa();
				
				// Salida de resultados
				mostrarResultados(Tienda.cantidadVentas, marcaPapel, precioResma, cantidadResmas, importeCompra,
						importeDescuento, importePagar, obsequio, premioSorpresa);
				
				JOptionPane.showMessageDialog(this, "La venta se realizó satisfactoriamente", "Venta realizada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				mensajeError("Debe ingresar un valor positivo para la cantidad de Resmas", "Error en la lectura de la cantidad de Resmas");
			}
		} catch (Exception e) { // Procesa el error que se genera al ingresar texto en vez de un valor numérico
			
			String strCantidadResmas = txtCantidad.getText(); // Se obtiene el texto ingresado
			if (strCantidadResmas.length() > 0) {
				mensajeError("No debe ingresar texto para el valor de la cantidad de Resmas", "Error en la lectura de la cantidad de Resmas");
			} else {
				// Se dejó en blanco el valor la cantidad de Resmas
				mensajeError("No debe dejar en blanco el valor de la cantidad de Resmas", "Error en la lectura de la cantidad de Resmas");
			}
		}
		txtCantidad.setText("");
		txtCantidad.requestFocus();
	}
	
	// Lee y retorna el índice de la marca de papel
	int getMarcaPapel() {
		return cboMarca.getSelectedIndex();
	}
	
	// Lee y retorna la cantidad de resmas
	int getCantidadResmas() throws NumberFormatException {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	// Determina y retorna el precio de la resma
	double getPrecioResma(int marca) {
		double precio;
		
		switch (marca) {
			case 0:
				precio = Tienda.precio0;
				break;
				
			case 1:
				precio = Tienda.precio1;
				break;
				
			case 2:
				precio = Tienda.precio2;
				break;
				
			case 3:
				precio = Tienda.precio3;
				break;
				
			default:
				precio = Tienda.precio4;
		}
		
		return precio;
	}
	
	// Calcula y retorna el importe de la compra
	double calcularImporteCompra(double precio, int cantidad) {
		return precio * cantidad;
	}
	
	// Calcula y retorna el importe del descuento
	double calcularImporteDescuento(double importeCompra, int cantidad) {
		double importeDescuento;
		
		if (cantidad >= 1 && cantidad <= 5)
			importeDescuento = importeCompra * Tienda.porcentaje1 / 100;
		
		else if (cantidad <= 10)
			importeDescuento = importeCompra * Tienda.porcentaje2 / 100;
		
		else if (cantidad <= 15)
			importeDescuento = importeCompra * Tienda.porcentaje3 / 100;
		
		else
			importeDescuento = importeCompra * Tienda.porcentaje4 / 100;
		
		return importeDescuento;
	}
	
	// Calcula y retorna el importe a pagar
	double calcularImportePagar(double importeCompra, double importeDescuento) {
		return importeCompra - importeDescuento;
	}
	
	// Calcula y retorna el obsequio
	String calcularObsequio (int cantidadResmas) {
		String obsequio;
		
		if (cantidadResmas >= Tienda.cantidadObsequiable)
			obsequio = Tienda.obsequio;
		else
			obsequio = "Ninguno";
		
		return obsequio;
	}
	
	// Calcula y retorna el premio sorpresa
	String calcularPremioSorpresa() {
		String premioSorpresa;
		
		if (Tienda.cantidadVentas == Tienda.numeroClienteSorpresa) {
			premioSorpresa = Tienda.premioSorpresa;
		} else {
			premioSorpresa = "Ninguno";
		}
		
		return premioSorpresa;
	}
	
	// Contabiliza la venta efectuada
	void contabilizarVenta(int marcaPapel, int cantidadResmas, double importePagar) {
		// Contabiliza el número de ventas totales
		Tienda.cantidadVentas++;
		
		// Acumula el importe total acumulado general
		Tienda.importeTotalAcumulado += importePagar;
		
		contabilizarVentasPorMarca(marcaPapel, cantidadResmas, importePagar);		
	}
	
	// Contabiliza las ventas por marca, cantidad de resmas vendidas y el importe total acumulado
	void contabilizarVentasPorMarca(int marcaPapel, int cantidadResmas, double importePagar) {
		
		switch(marcaPapel) {
			case 0:
				Tienda.cantidadVentas0++;
				Tienda.cantidadResmas0 += cantidadResmas;
				Tienda.importeTotal0 += importePagar;
				break;
				
			case 1:
				Tienda.cantidadVentas1++;
				Tienda.cantidadResmas1 += cantidadResmas;
				Tienda.importeTotal1 += importePagar;
				break;
				
			case 2:
				Tienda.cantidadVentas2++;
				Tienda.cantidadResmas2 += cantidadResmas;
				Tienda.importeTotal2 += importePagar;
				break;
				
			case 3:
				Tienda.cantidadVentas3++;
				Tienda.cantidadResmas3 += cantidadResmas;
				Tienda.importeTotal3 += importePagar;
				break;
				
			default:
				Tienda.cantidadVentas4++;
				Tienda.cantidadResmas4 += cantidadResmas;
				Tienda.importeTotal4 += importePagar;
				break;
		}
	}
	
	// Muestra los resultados obtenidos
	void mostrarResultados(int numeroCliente, int marcaPapel, double precioResma, int cantidadResmas, 
			double importeCompra, double importeDescuento, double importePagar, String obsequio, String premioSorpresa) {
		txtS.setText("");
		imprimir("# DE VENTA DEL DÍA: " + numeroCliente); // Número de ventas del día
		imprimir("\nMarca de papel.................. : " + cboMarca.getItemAt(marcaPapel));
		imprimir("Precio de la resma.............. : S/. " + precioResma);
		imprimir("Cantidad de resmas adquiridas... : " + cantidadResmas);
		imprimir("Importe de compra............... : S/. " + importeCompra);
		imprimir("Importe de descuento............ : S/. " + importeDescuento);
		imprimir("Importe a pagar................. : S/. " + importePagar);
		imprimir("Obsequio........................ : " + obsequio);
		imprimir("Premio sorpresa................. : " + premioSorpresa);
	}
	
	// Imprime una línea de texto incluyendo un salto de línea al final
	void imprimir(String cadena) {
		txtS.append(cadena + "\n");
	}
	
	// Procesa la pulsación del botón Cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje y título específico
	void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboMarca) {
			itemStateChangedCboMarca(e);
		}
	}
	
	protected void itemStateChangedCboMarca(ItemEvent e) {
		txtCantidad.requestFocus();
	}
}
