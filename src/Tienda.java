import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Tienda extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaraci�n de variables
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracin;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarPapel;
	private JMenuItem mntmModificarPapel;
	private JMenuItem mntmListarPapeles;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequio;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmConfigurarPremioSorpresa;
	private JMenuItem mntmAcercaDeTienda;

	// Datos m�nimos de la primera marca
	public static String marca0 = "Class Bond";
	public static String dimensiones0 = "21.6 x 28.0 cm";
	public static double gramaje0 = 74.8;
	public static double blancura0 = 90.2;
	public static double precio0 = 12.0;
	
	// Datos m�nimos de la segunda marca
	public static String marca1 = "Copy Premium";
	public static String dimensiones1 = "21.6 x 27.9 cm";
	public static double gramaje1 = 74.3;
	public static double blancura1 = 90.0;
	public static double precio1 = 11.5;
	
	// Datos m�nimos de la tercera marca
	public static String marca2 = "Master Bond";
	public static String dimensiones2 = "21.6 x 28.0 cm";
	public static double gramaje2 = 74.4;
	public static double blancura2 = 90.3;
	public static double precio2 = 13.0;
	
	// Datos m�nimos de la cuarta marca
	public static String marca3 = "Vision Bond";
	public static String dimensiones3 = "21.6 x 27.9 cm";
	public static double gramaje3 = 74.5;
	public static double blancura3 = 96.1;
	public static double precio3 = 14.5;
	
	// Datos m�nimos de la quinta marca
	public static String marca4 = "Copy Paper";
	public static String dimensiones4 = "21.6 x 27.9";
	public static double gramaje4 = 75.0;
	public static double blancura4 = 93.9;
	public static double precio4 = 11.0;
	
	// Porcentajes de descuento
	public static double porcentaje1 = 4.0;
	public static double porcentaje2 = 5.5;
	public static double porcentaje3 = 7.0;
	public static double porcentaje4 = 8.5;
	
	// Cantidad total �ptima de resmas vendidas
	public static int cantidadTotalOptima = 50;
	
	// Cantidad m�nima de resmas adquiridas para obtener el obsequio
	public static int cantidadObsequiable = 6;
	
	// Obsequio
	public static String obsequio = "Un lapicero";
	
	// N�mero de cliente que recibe el premio sorpresa
	public static int numeroClienteSorpresa = 5;
	
	// Premio sorpresa
	public static String premioSorpresa = "Un chocolate";
	
	// Otras variables
	public static int cantidadVentas = 0; // Contabiliza la cantidad de ventas del d�a
	
	// Contadores del n�mero ventas efectuadas por marca
	public static int cantidadVentas0 = 0;
	public static int cantidadVentas1 = 0;
	public static int cantidadVentas2 = 0;
	public static int cantidadVentas3 = 0;
	public static int cantidadVentas4 = 0;
	
	// Acumulador de resmas vendidas por marca
	public static int cantidadResmas0 = 0;
	public static int cantidadResmas1 = 0;
	public static int cantidadResmas2 = 0;
	public static int cantidadResmas3 = 0;
	public static int cantidadResmas4 = 0;
	
	// Acumuladores de importe total por marca
	public static double importeTotal0 = 0.0;
	public static double importeTotal1 = 0.0;
	public static double importeTotal2 = 0.0;
	public static double importeTotal3 = 0.0;
	public static double importeTotal4 = 0.0;
	
	// Importe total acumulado general
	public static double importeTotalAcumulado = 0.0;
	
	
	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Tienda() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 431);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarPapel = new JMenuItem("Consultar papel");
		mntmConsultarPapel.addActionListener(this);
		mnMantenimiento.add(mntmConsultarPapel);
		
		mntmModificarPapel = new JMenuItem("Modificar papel");
		mntmModificarPapel.addActionListener(this);
		mnMantenimiento.add(mntmModificarPapel);
		
		mntmListarPapeles = new JMenuItem("Listar papeles");
		mntmListarPapeles.addActionListener(this);
		mnMantenimiento.add(mntmListarPapeles);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracin);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequio = new JMenuItem("Configurar obsequio");
		mntmConfigurarObsequio.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarObsequio);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad \u00F3ptima de resmas vendidas");
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarPremioSorpresa = new JMenuItem("Configurar premio sorpresa");
		mntmConfigurarPremioSorpresa.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarPremioSorpresa);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null); // Centra la ventana
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmConfigurarPremioSorpresa) {
			actionPerformedMntmConfigurarPremioSorpresa(e);
		}
		if (e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		if (e.getSource() == mntmConfigurarObsequio) {
			actionPerformedMntmConfigurarObsequio(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListarPapeles) {
			actionPerformedMntmListarPapeles(e);
		}
		if (e.getSource() == mntmModificarPapel) {
			actionPerformedMntmModificarPapel(e);
		}
		if (e.getSource() == mntmConsultarPapel) {
			actionPerformedMntmConsultarPapel(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
	// Procesa la pulsaci�n del men� item Salir
	protected void actionPerformedMntmSalir(ActionEvent e) {
		
		// Pide la confirmaci�n del usuario para salir
		int respuesta = JOptionPane.showConfirmDialog(this, "�Seguro que desea salir del programa?", 
				"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
		
		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	protected void actionPerformedMntmConsultarPapel(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoMantenimientoConsultar dmc = new DialogoMantenimientoConsultar();
		
		// Centra el cuadro de di�logo en la Tienda
		dmc.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dmc.setVisible(true);
	}
	
	protected void actionPerformedMntmModificarPapel(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoMantenimientoModificar dmm = new DialogoMantenimientoModificar();
		
		// Centra el cuadro de di�logo en la Tienda
		dmm.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dmm.setVisible(true);
	}
	
	protected void actionPerformedMntmListarPapeles(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoMantenimientoListar dml = new DialogoMantenimientoListar();
		
		// Centra el cuadro de di�logo en la Tienda
		dml.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dml.setVisible(true);
	}
	
	protected void actionPerformedMntmVender(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoVentasVender dvv = new DialogoVentasVender();
		
		// Centra el cuadro de di�logo en la Tienda
		dvv.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dvv.setVisible(true);
	}
	
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoVentasGenerarReportes dvgr = new DialogoVentasGenerarReportes();
		
		// Centra el cuadro de di�logo en la Tienda
		dvgr.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dvgr.setVisible(true);
	}
	
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoConfiguracionDescuentos dcd = new DialogoConfiguracionDescuentos();
		
		// Centra el cuadro de di�logo en la Tienda
		dcd.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dcd.setVisible(true);
	}
	
	protected void actionPerformedMntmConfigurarObsequio(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoConfiguracionObsequio dco = new DialogoConfiguracionObsequio();
		
		// Centra el cuadro de di�logo en la Tienda
		dco.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dco.setVisible(true);
	}
	
	protected void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoConfiguracionOptima dco = new DialogoConfiguracionOptima();
		
		// Centra el cuadro de di�logo en la Tienda
		dco.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dco.setVisible(true);	
	}
	
	protected void actionPerformedMntmConfigurarPremioSorpresa(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoConfiguracionPremioSorpresa dcps = new DialogoConfiguracionPremioSorpresa();
		
		// Centra el cuadro de di�logo en la Tienda
		dcps.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dcps.setVisible(true);
	}
	
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DialogoAcercaDe dad = new DialogoAcercaDe();
		
		// Centra el cuadro de di�logo en la Tienda
		dad.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dad.setVisible(true);
	}
}
