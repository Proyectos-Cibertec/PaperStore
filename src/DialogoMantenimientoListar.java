import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class DialogoMantenimientoListar extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaraci�n de variables
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoMantenimientoListar dialog = new DialogoMantenimientoListar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoMantenimientoListar() {
		setModal(true);
		setResizable(false);
		setTitle("Listar papeles");
		setBounds(100, 100, 642, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 616, 281);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Consolas", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setBounds(214, 303, 89, 23);
		btnCerrar.addActionListener(this);
		contentPanel.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.setBounds(326, 303, 89, 23);
		btnListar.addActionListener(this);
		contentPanel.add(btnListar);
		
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	// Procesa la pulsaci�n del bot�n Cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // Cierra el cuadro de di�logo
	}
	
	// Procesa la pulsaci�n del bot�n Listar
	protected void actionPerformedBtnListar(ActionEvent e) {
		mostrarResultados();
	}
	
	// Muestra los resultados solicitados
	void mostrarResultados() {
		txtS.setText("");
		imprimir("LISTADO DE PAPELES");
		imprimir("\n---------------------------------");
		listarPapelesMarca(0); // Imprime el listado de la marca de papel 0
		imprimir("---------------------------------");
		listarPapelesMarca(1); // Imprime el listado de la marca de papel 1
		imprimir("---------------------------------");
		listarPapelesMarca(2); // Imprime el listado de la marca de papel 2
		imprimir("---------------------------------");
		listarPapelesMarca(3); // Imprime el listado de la marca de papel 3
		imprimir("---------------------------------");
		listarPapelesMarca(4); // Imprime el listado de la marca de papel 4
		imprimir("---------------------------------");
	}
	
	// Muestra los datos de una marca de papel determinada por su argumento
	void listarPapelesMarca(int marca) {
		switch (marca) {
			case 0:
				imprimir("Marca\t\t: " + Tienda.marca0);
				imprimir("Dimensiones\t: " + Tienda.dimensiones0);
				imprimir("Gramaje\t\t: " + Tienda.gramaje0);
				imprimir("Blancura\t: " + Tienda.blancura0);
				imprimir("Precio\t\t: " + "S/. " + Tienda.precio0);
				break;
				
			case 1:
				imprimir("Marca\t\t: " + Tienda.marca1);
				imprimir("Dimensiones\t: " + Tienda.dimensiones1);
				imprimir("Gramaje\t\t: " + Tienda.gramaje1);
				imprimir("Blancura\t: " + Tienda.blancura1);
				imprimir("Precio\t\t: " + "S/. " + Tienda.precio1);
				
				break;
				
			case 2:
				imprimir("Marca\t\t: " + Tienda.marca2);
				imprimir("Dimensiones\t: " + Tienda.dimensiones2);
				imprimir("Gramaje\t\t: " + Tienda.gramaje2);
				imprimir("Blancura\t: " + Tienda.blancura2);
				imprimir("Precio\t\t: " + "S/. " + Tienda.precio2);
				break;
				
			case 3:
				imprimir("Marca\t\t: " + Tienda.marca3);
				imprimir("Dimensiones\t: " + Tienda.dimensiones3);
				imprimir("Gramaje\t\t: " + Tienda.gramaje3);
				imprimir("Blancura\t: " + Tienda.blancura3);
				imprimir("Precio\t\t: " + "S/. " + Tienda.precio3);
				break;
				
			default:
				imprimir("Marca\t\t: " + Tienda.marca4);
				imprimir("Dimensiones\t: " + Tienda.dimensiones4);
				imprimir("Gramaje\t\t: " + Tienda.gramaje4);
				imprimir("Blancura\t: " + Tienda.blancura4);
				imprimir("Precio\t\t: " + "S/. " + Tienda.precio4);
		}
	}

	// Imprime una l�nea de texto incluyendo un salto de l�nea al final
	void imprimir(String cadena) {
		txtS.append(cadena + "\n");
	}
}
