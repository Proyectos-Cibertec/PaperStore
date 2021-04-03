

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

public class DialogoVentasGenerarReportes extends JDialog implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JComboBox<String> cboTipoReporte;
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
			DialogoVentasGenerarReportes dialog = new DialogoVentasGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoVentasGenerarReportes() {
		setModal(true);
		setResizable(false);
		setTitle("Generar reportes");
		setBounds(100, 100, 631, 538);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de reporte");
		lblNewLabel.setBounds(10, 11, 74, 14);
		contentPanel.add(lblNewLabel);
		
		cboTipoReporte = new JComboBox<String>();
		cboTipoReporte.addItemListener(this);
		cboTipoReporte.setModel(new DefaultComboBoxModel<String>(new String[] {"Ventas por marca", "Marcas con venta \u00F3ptima", "Marcas con precios menores al 85% del precio m\u00E1ximo", "Marcas con precios mayores al 85% del precio m\u00E1ximo", "Precios menor, mayor y promedio"}));
		cboTipoReporte.setBounds(116, 8, 382, 20);
		contentPanel.add(cboTipoReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(521, 7, 89, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 600, 449);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Consolas", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		
		reporteVentasPorMarca();
	}
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	// Procesa la pulsación del botón cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
	
	// Direcciona eventos de tipo ItemEvent
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboTipoReporte) {
			itemStateChangedCboTipoReporte(e);
		}
	}
	
	// Procesa el cambio de estado de los elementos del comboBox
	protected void itemStateChangedCboTipoReporte(ItemEvent e) {
		int tipoReporte;
		
		tipoReporte = getTipoReporte();
		mostrarReporte(tipoReporte);
	}
	
	// Lee y retorna el tipo de reporte
	int getTipoReporte() {
		return cboTipoReporte.getSelectedIndex();
	}
	
	// Muestra el reporte
	void mostrarReporte(int tipoReporte) {
		
		switch (tipoReporte) {
			case 0:
				reporteVentasPorMarca();
				break;
				
			case 1:
				reporteMarcasVentaOptima();
				break;
			
			case 2:
				reportePreciosMenoresAl85PrecioMaximo();
				break;
				
			case 3:
				reportePreciosMayoresAl85PrecioMaximo();
				break;
				
			default:
				reportePreciosMenorMayorPromedio();				
		}
	}
	
	// Imprime un reporte de las ventas efectuadas por cada marca de papel
	void reporteVentasPorMarca() {
		txtS.setText("");
		imprimir("VENTAS POR MARCA");
		
		imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca0);
		imprimir("Cantidad de ventas\t\t\t: " + Tienda.cantidadVentas0);
		imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas0);
		imprimir("Importe total acumulado\t\t\t: S/. " + Tienda.importeTotal0);
		
		imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca1);
		imprimir("Cantidad de ventas\t\t\t: " + Tienda.cantidadVentas1);
		imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas1);
		imprimir("Importe total acumulado\t\t\t: S/. " + Tienda.importeTotal1);
		
		imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca2);
		imprimir("Cantidad de ventas\t\t\t: " + Tienda.cantidadVentas2);
		imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas2);
		imprimir("Importe total acumulado\t\t\t: S/. " + Tienda.importeTotal2);
		
		imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca3);
		imprimir("Cantidad de ventas\t\t\t: " + Tienda.cantidadVentas3);
		imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas3);
		imprimir("Importe total acumulado\t\t\t: S/. " + Tienda.importeTotal3);
		
		imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca4);
		imprimir("Cantidad de ventas\t\t\t: " + Tienda.cantidadVentas4);
		imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas4);
		imprimir("Importe total acumulado\t\t\t: S/. " + Tienda.importeTotal4);
		
		imprimir("\nImporte total acumulado general\t\t: S/. " + Tienda.importeTotalAcumulado);
	}
	
	// Imprime un reporte de las marcas de papel con venta óptima
	void reporteMarcasVentaOptima() {
		int contador = 0;
		
		txtS.setText("");
		imprimir("MARCAS CON VENTA ÓPTIMA");
		
		if (Tienda.cantidadResmas0 >= Tienda.cantidadTotalOptima) {
			imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca0);
			imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas0);
			contador++;
		}
		
		if (Tienda.cantidadResmas1 >= Tienda.cantidadTotalOptima) {
			imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca1);
			imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas1);
			contador++;
		}
		
		if (Tienda.cantidadResmas2 >= Tienda.cantidadTotalOptima) {
			imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca2);
			imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas2);
			contador++;
		}
		
		if (Tienda.cantidadResmas3 >= Tienda.cantidadTotalOptima) {
			imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca3);
			imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas3);
			contador++;
		}
		
		if (Tienda.cantidadResmas4 >= Tienda.cantidadTotalOptima) {
			imprimir("\nMarca\t\t\t\t\t: " + Tienda.marca4);
			imprimir("Cantidad total de resmas vendidas\t: " + Tienda.cantidadResmas4);
			contador++;
		}
		
		if (contador > 0) {
			imprimir("\nNº de marcas de papel con venta óptima: " + contador);
		} else {
			imprimir("\nNo hay marcas de papel con venta óptima");
		}
	}
	
	// Imprime un reporte de las marcas de papel cuyos precios son menores al 85% del precio máximo
	void reportePreciosMenoresAl85PrecioMaximo() {
		// Declaración de variables
		double precioMaximo, porcentajePrecioMaximo;
		
		// Entrada de datos
		precioMaximo = getPrecioMaximo();
		
		// Proceso de cálculo
		porcentajePrecioMaximo = precioMaximo * 85 / 100;
		
		// Salida de resultados
		mostrarMarcasPapelMenores(porcentajePrecioMaximo);
	}
	
	// Imprime un reporte de las marcas de papel cuyos precios son mayores al 85% del precio máximo
	void reportePreciosMayoresAl85PrecioMaximo() {
		// Declaración de variables
		double precioMaximo, porcentajePrecioMaximo;
		
		// Entrada de datos
		precioMaximo = getPrecioMaximo();
		
		// Proceso de cálculo
		porcentajePrecioMaximo = precioMaximo * 85 / 100;
		
		// Salida de resultados
		mostrarMarcasPapelMayores(porcentajePrecioMaximo);
	}

	void reportePreciosMenorMayorPromedio() {
		// Declaración de variables
		double gramajePromedio, gramajeMinimo, gramajeMaximo;
		double blancuraPromedio, blancuraMinima, blancuraMaxima;
		double precioPromedio, precioMinimo, precioMaximo;
		
		// Entrada y proceso
		gramajePromedio = getGramajePromedio();
		gramajeMinimo = getGramajeMinimo();
		gramajeMaximo = getGramajeMaximo();
		blancuraPromedio = getBlancuraPromedio();
		blancuraMinima = getBlancuraMinima();
		blancuraMaxima = getBlancuraMaxima();
		precioPromedio = getPrecioPromedio();
		precioMinimo = getPrecioMinimo();
		precioMaximo = getPrecioMaximo();
		
		// Salida de resultados
		mostrarPromediosMaximosMinimos(
				gramajePromedio, gramajeMinimo, gramajeMaximo,
				blancuraPromedio, blancuraMinima, blancuraMaxima,
				precioPromedio, precioMinimo, precioMaximo);
	}
	
	// Muestra el reporte solicitado
	void mostrarMarcasPapelMenores(double precio) {
		int contador = 0;
		
		txtS.setText("");
		imprimir("MARCAS CON PRECIOS MENORES AL 85% DEL PRECIO MÁXIMO\n");
		
		if (Tienda.precio0 < precio) {
			imprimir(Tienda.marca0);
			contador++;
		}
		
		if (Tienda.precio1 < precio) {
			imprimir(Tienda.marca1);
			contador++;
		}
		
		if (Tienda.precio2 < precio) {
			imprimir(Tienda.marca2);
			contador++;
		}
		
		if (Tienda.precio3 < precio) {
			imprimir(Tienda.marca3);
			contador++;
		}
		
		if (Tienda.precio4 < precio) {
			imprimir(Tienda.marca4);
			contador++;
		}
		
		imprimir("\n85% del precio máximo : S/. " + precio);
		imprimir("Número de marcas      : " + contador);
	}
	
	// Muestra el reporte solicitado
	void mostrarMarcasPapelMayores(double precio) {
		int contador = 0;
		
		txtS.setText("");
		imprimir("MARCAS CON PRECIOS MAYORES AL 85% DEL PRECIO MÁXIMO\n");
		
		if (Tienda.precio0 > precio) {
			imprimir(Tienda.marca0);
			contador++;
		}
		
		if (Tienda.precio1 > precio) {
			imprimir(Tienda.marca1);
			contador++;
		}
		
		if (Tienda.precio2 > precio) {
			imprimir(Tienda.marca2);
			contador++;
		}
		
		if (Tienda.precio3 > precio) {
			imprimir(Tienda.marca3);
			contador++;
		}
		
		if (Tienda.precio4 > precio) {
			imprimir(Tienda.marca4);
			contador++;
		}
		
		imprimir("\n85% del precio máximo : S/. " + precio);
		imprimir("Número de marcas      : " + contador);
	}
	
	// Calcula y retorna el gramaje promedio
	double getGramajePromedio() {
		double gramajePromedio;
		
		gramajePromedio = (Tienda.gramaje0 + Tienda.gramaje1 + Tienda.gramaje2 + Tienda.gramaje3 + Tienda.gramaje4) / 5;
		
		return gramajePromedio;
	}
	
	// Calcula y retorna el gramaje mínimo de entre los gramajes de las marcas de papel
	double getGramajeMinimo() {
		double gramajeMinimo;
		
		gramajeMinimo = Tienda.gramaje0;
		
		if (gramajeMinimo > Tienda.gramaje1) gramajeMinimo = Tienda.gramaje1;
		if (gramajeMinimo > Tienda.gramaje2) gramajeMinimo = Tienda.gramaje2;
		if (gramajeMinimo > Tienda.gramaje3) gramajeMinimo = Tienda.gramaje3;
		if (gramajeMinimo > Tienda.gramaje4) gramajeMinimo = Tienda.gramaje4;
		
		return gramajeMinimo;
	}
	
	// Calcula y retorna el gramaje máximo de entre los gramajes de las marcas de papel
	double getGramajeMaximo() {
		double gramajeMaximo;
		
		gramajeMaximo = Tienda.gramaje0;
		
		if (gramajeMaximo < Tienda.gramaje1) gramajeMaximo = Tienda.gramaje1;
		if (gramajeMaximo < Tienda.gramaje2) gramajeMaximo = Tienda.gramaje2;
		if (gramajeMaximo < Tienda.gramaje3) gramajeMaximo = Tienda.gramaje3;
		if (gramajeMaximo < Tienda.gramaje4) gramajeMaximo = Tienda.gramaje4;
		
		return gramajeMaximo;
	}
	
	// Calcula y retorna la blancura promedio
	double getBlancuraPromedio() {
		double blancuraPromedio;
		
		blancuraPromedio = (Tienda.blancura0 + Tienda.blancura1 + Tienda.blancura2 + Tienda.blancura3 + Tienda.blancura4) / 5;
		
		return blancuraPromedio;
	}
	
	// Calcula y retorna la blancura mínima de entre las blancuras de las marcas de papel
	double getBlancuraMinima() {
		double blancuraMinima;
		
		blancuraMinima = Tienda.blancura0;
		
		if (blancuraMinima > Tienda.blancura1) blancuraMinima = Tienda.blancura1;
		if (blancuraMinima > Tienda.blancura2) blancuraMinima = Tienda.blancura2;
		if (blancuraMinima > Tienda.blancura3) blancuraMinima = Tienda.blancura3;
		if (blancuraMinima > Tienda.blancura4) blancuraMinima = Tienda.blancura4;
		
		return blancuraMinima;
	}
	
	// Calcula y retorna la blancura máxima de entre las blancuras de las marcas de papel
	double getBlancuraMaxima() {
		double blancuraMaxima;
		
		blancuraMaxima = Tienda.gramaje0;
		
		if (blancuraMaxima < Tienda.blancura1) blancuraMaxima = Tienda.blancura1;
		if (blancuraMaxima < Tienda.blancura2) blancuraMaxima = Tienda.blancura2;
		if (blancuraMaxima < Tienda.blancura3) blancuraMaxima = Tienda.blancura3;
		if (blancuraMaxima < Tienda.blancura4) blancuraMaxima = Tienda.blancura4;
		
		return blancuraMaxima;
	}
	
	// Calcula y retorna el precio promedio
	double getPrecioPromedio() {
		double precioPromedio;
		
		precioPromedio = (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4) / 5;
		
		return precioPromedio;
	}
	
	// Calcula y retorna el precio mínimo de entre los precios de las marcas de papel
	double getPrecioMinimo() {
		double precioMinimo;
		
		precioMinimo = Tienda.precio0;
		
		if (precioMinimo > Tienda.precio1) precioMinimo = Tienda.precio1;
		if (precioMinimo > Tienda.precio2) precioMinimo = Tienda.precio2;
		if (precioMinimo > Tienda.precio3) precioMinimo = Tienda.precio3;
		if (precioMinimo > Tienda.precio4) precioMinimo = Tienda.precio4;
		
		return precioMinimo;
	}
	
	// Calcula y retorna el precio máximo de entre los precios de las marcas de papel
	double getPrecioMaximo() {
		double precioMaximo;
		
		precioMaximo = Tienda.precio0;
		
		if (precioMaximo < Tienda.precio1) precioMaximo = Tienda.precio1;
		if (precioMaximo < Tienda.precio2) precioMaximo = Tienda.precio2;
		if (precioMaximo < Tienda.precio3) precioMaximo = Tienda.precio3;
		if (precioMaximo < Tienda.precio4) precioMaximo = Tienda.precio4;
		
		return precioMaximo;
	}
	
	
	void mostrarPromediosMaximosMinimos(
			double gramajePromedio, double gramajeMinimo, double gramajeMaximo,
			double blancuraPromedio, double blancuraMinima, double blancuraMaxima,
			double precioPromedio, double precioMinimo, double precioMaximo) {
		
		txtS.setText("");
		imprimir("PROMEDIO, MÁXIMOS Y MÍNIMOS");
		imprimir("\nGramaje promedio\t: " + gramajePromedio + "g/m²");
		imprimir("Gramaje mínimo\t\t: " + gramajeMinimo + "g/m²");
		imprimir("Gramaje máximo\t\t: " + gramajeMaximo + "g/m²");
		
		imprimir("\nBlancura promedio\t: " + blancuraPromedio);
		imprimir("Blancura mínima\t\t: " + blancuraMinima);
		imprimir("Blancura máxima\t\t: " + blancuraMaxima);
		
		imprimir("\nPrecio promedio\t\t: " + precioPromedio);
		imprimir("Precio mínimo\t\t: " + precioMinimo);
		imprimir("Precio máximo\t\t: " + precioMaximo);
	}
	
	// Imprime una línea de texto incluyendo un salto de línea al final
	void imprimir(String cadena) {
		txtS.append(cadena + "\n");
	}
}
