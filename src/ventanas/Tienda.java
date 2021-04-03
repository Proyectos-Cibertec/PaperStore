package ventanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import librerias.FechaHora;

import javax.swing.ImageIcon;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Tienda extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracin;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmMantenimientoConsultar;
	private JMenuItem mntmMantenimientoModificar;
	private JMenuItem mntmMantenimientoListar;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfiguracionDescuentos;
	private JMenuItem mntmConfiguracionObsequio;
	private JMenuItem mntmConfiguracionOptima;
	private JMenuItem mntmConfiguracionPremio;
	private JMenuItem mntmAcercaDeTienda;

	// Datos mínimos de la primera marca
	public static String marca0 = "Class Bond";
	public static String dimensiones0 = "21.6 x 28.0 cm";
	public static double gramaje0 = 74.8;
	public static double blancura0 = 90.2;
	public static double precio0 = 12.0;
	
	// Datos mínimos de la segunda marca
	public static String marca1 = "Copy Premium";
	public static String dimensiones1 = "21.6 x 27.9 cm";
	public static double gramaje1 = 74.3;
	public static double blancura1 = 90.0;
	public static double precio1 = 11.5;
	
	// Datos mínimos de la tercera marca
	public static String marca2 = "Master Bond";
	public static String dimensiones2 = "21.6 x 28.0 cm";
	public static double gramaje2 = 74.4;
	public static double blancura2 = 90.3;
	public static double precio2 = 13.0;
	
	// Datos mínimos de la cuarta marca
	public static String marca3 = "Vision Bond";
	public static String dimensiones3 = "21.6 x 27.9 cm";
	public static double gramaje3 = 74.5;
	public static double blancura3 = 96.1;
	public static double precio3 = 14.5;
	
	// Datos mínimos de la quinta marca
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
	
	// Cantidad total óptima de resmas vendidas
	public static int cantidadTotalOptima = 50;
	
	// Cantidad mínima de resmas adquiridas para obtener el obsequio
	public static int cantidadObsequiable = 6;
	
	// Obsequio
	public static String obsequio = "Un lapicero";
	
	// Número de cliente que recibe el premio sorpresa
	public static int numeroClienteSorpresa = 5;
	
	// Premio sorpresa
	public static String premioSorpresa = "Un chocolate";
	
	// Otras variables
	public static int cantidadVentas = 0; // Contabiliza la cantidad de ventas del día
	
	// Contadores del número ventas efectuadas por marca
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
	
	
	// Tipos de usuarios y sus privilegios
	public static final int ADMINISTRADOR = 0;
	public static final int VENDEDOR = 1;
	
	// Variable que almacena el tipo de privilegio del usuario que está haciendo uso del sistema
	public static int tipoPrivilegio;
	
	// Nombres de usuario y contraseñas de Administradores
	public static String adminUsuario0  = "luis";
	public static String adminPassword0 = "guisado";
	public static String adminUsuario1  = "eduardo";
	public static String adminPassword1 = "mayaute";
	
	// Nombres de usuario y contraseñas de Vendedores 
	public static String vendedorUsuario0 = "alberto";
	public static String vendedorPassword0 = "mena";
	private JPanel panelContenido;
	private JPanel panelBarraEstado;
	private JMenuBar barraEstado;
	private JMenuItem mntmTipoUsuario;
	private JLabel lblLogo;
	private JMenuItem mntmFechaHora;
	private JMenuItem mntmDerechosReservados;
	private JLabel lblFondo;
	private JLabel lblClassBond;
	private JLabel lblCopyPaper;
	private JLabel lblMasterBond;
	private JLabel lblVisionBond;
	private JLabel lblCopyPremium;
	private JLabel lblDistribuidora;
	private JLabel lblDireccion;
	private JLabel lblRedesSociales;
	private JLabel lblFacebook;
	private JLabel lblTwitter;
	private JLabel lblYoutube;
	private JMenuItem mntmNewMenuItem;
	private JSeparator separator;
	private JLabel lblManual;
	private JLabel lblIconoManualUsuario;
	private JToolBar herramientasMantenimiento;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnListar;
	private JButton btnVender;
	private JButton btnGenerarReportes;
	private JButton btnConfigurarDescuentos;
	private JButton btnConfigurarObsequio;
	private JButton btnConfigurarOptima;
	private JButton btnPremioSorpresa;
	private JButton btnManualUsuario;
	private JButton btnAyuda;
	private JToolBar herramientasVentas;
	private JToolBar herramientasConfiguracion;
	private JToolBar herramientasAyuda;
	
	// Lanza la aplicación
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tienda.class.getResource("/img/iconoPrincipal.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("PAPER'S STORE - Distruibuidora de papel");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 645, 431);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmSalir.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemSalir.png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnMantenimiento);
		
		mntmMantenimientoConsultar = new JMenuItem("Consultar papel");
		mntmMantenimientoConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmMantenimientoConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmMantenimientoConsultar.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemConsultarPapel.png")));
		mntmMantenimientoConsultar.addActionListener(this);
		mnMantenimiento.add(mntmMantenimientoConsultar);
		
		mntmMantenimientoModificar = new JMenuItem("Modificar papel");
		mntmMantenimientoModificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmMantenimientoModificar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmMantenimientoModificar.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemModificarPapel.png")));
		mntmMantenimientoModificar.addActionListener(this);
		mnMantenimiento.add(mntmMantenimientoModificar);
		
		mntmMantenimientoListar = new JMenuItem("Listar papeles");
		mntmMantenimientoListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmMantenimientoListar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmMantenimientoListar.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemListarPapel.png")));
		mntmMantenimientoListar.addActionListener(this);
		mnMantenimiento.add(mntmMantenimientoListar);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmVender.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmVender.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemVender.png")));
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmGenerarReportes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmGenerarReportes.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemGenerarReporte.png")));
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracin = new JMenu("Configuraci\u00F3n");
		mnConfiguracin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnConfiguracin);
		
		mntmConfiguracionDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfiguracionDescuentos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmConfiguracionDescuentos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmConfiguracionDescuentos.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemDescuento.png")));
		mntmConfiguracionDescuentos.addActionListener(this);
		mnConfiguracin.add(mntmConfiguracionDescuentos);
		
		mntmConfiguracionObsequio = new JMenuItem("Configurar obsequio");
		mntmConfiguracionObsequio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmConfiguracionObsequio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmConfiguracionObsequio.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemObsequio.png")));
		mntmConfiguracionObsequio.addActionListener(this);
		mnConfiguracin.add(mntmConfiguracionObsequio);
		
		mntmConfiguracionOptima = new JMenuItem("Configurar cantidad \u00F3ptima de resmas vendidas");
		mntmConfiguracionOptima.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmConfiguracionOptima.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmConfiguracionOptima.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemOptima.png")));
		mntmConfiguracionOptima.addActionListener(this);
		mnConfiguracin.add(mntmConfiguracionOptima);
		
		mntmConfiguracionPremio = new JMenuItem("Configurar premio sorpresa");
		mntmConfiguracionPremio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmConfiguracionPremio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmConfiguracionPremio.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemSorpresa.png")));
		mntmConfiguracionPremio.addActionListener(this);
		mnConfiguracin.add(mntmConfiguracionPremio);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAcercaDeTienda.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmAcercaDeTienda.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemAbout.png")));
		mntmAcercaDeTienda.addActionListener(this);
		
		mntmNewMenuItem = new JMenuItem("Manual del usuario");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemManualUsuario.png")));
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAyuda.add(mntmNewMenuItem);
		
		separator = new JSeparator();
		mnAyuda.add(separator);
		mnAyuda.add(mntmAcercaDeTienda);
		
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panelContenido = new JPanel();
		panelContenido.setBounds(0, 41, 1596, 743);
		panelContenido.setBackground(new Color(255, 255, 204));
		getContentPane().add(panelContenido);
		panelContenido.setLayout(null);
		
		lblClassBond = new JLabel("");
		lblClassBond.setIcon(new ImageIcon(Tienda.class.getResource("/img/class_bond.png")));
		lblClassBond.setBounds(315, 401, 168, 275);
		panelContenido.add(lblClassBond);
		
		lblCopyPaper = new JLabel("");
		lblCopyPaper.setIcon(new ImageIcon(Tienda.class.getResource("/img/copy_paper.png")));
		lblCopyPaper.setBounds(1237, 457, 336, 250);
		panelContenido.add(lblCopyPaper);
		
		lblMasterBond = new JLabel("");
		lblMasterBond.setIcon(new ImageIcon(Tienda.class.getResource("/img/master_bond.png")));
		lblMasterBond.setBounds(572, 359, 226, 348);
		panelContenido.add(lblMasterBond);
		
		lblVisionBond = new JLabel("");
		lblVisionBond.setIcon(new ImageIcon(Tienda.class.getResource("/img/vision_bond.png")));
		lblVisionBond.setBounds(955, 359, 252, 371);
		panelContenido.add(lblVisionBond);
		
		lblCopyPremium = new JLabel("");
		lblCopyPremium.setIcon(new ImageIcon(Tienda.class.getResource("/img/copy_premium.png")));
		lblCopyPremium.setBounds(27, 371, 187, 309);
		panelContenido.add(lblCopyPremium);
		
		lblDistribuidora = new JLabel("");
		lblDistribuidora.setIcon(new ImageIcon(Tienda.class.getResource("/img/distruibuidora.png")));
		lblDistribuidora.setBounds(393, 186, 389, 48);
		panelContenido.add(lblDistribuidora);
		
		lblDireccion = new JLabel("AV. PR\u00D3CERES DE LA INDEPENDENCIA CDRA 20 - SJL");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDireccion.setBounds(342, 245, 500, 14);
		panelContenido.add(lblDireccion);
		
		lblRedesSociales = new JLabel("REDES SOCIALES");
		lblRedesSociales.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedesSociales.setForeground(new Color(51, 102, 204));
		lblRedesSociales.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRedesSociales.setBounds(1284, 245, 267, 29);
		panelContenido.add(lblRedesSociales);
		
		lblFacebook = new JLabel("");
		lblFacebook.addMouseListener(this);
		lblFacebook.setIcon(new ImageIcon(Tienda.class.getResource("/img/rs_facebook.png")));
		lblFacebook.setBounds(1284, 285, 64, 64);
		panelContenido.add(lblFacebook);
		
		lblTwitter = new JLabel("");
		lblTwitter.addMouseListener(this);
		lblTwitter.setIcon(new ImageIcon(Tienda.class.getResource("/img/rs_twitter.png")));
		lblTwitter.setBounds(1387, 285, 64, 64);
		panelContenido.add(lblTwitter);
		
		lblYoutube = new JLabel("");
		lblYoutube.addMouseListener(this);
		lblYoutube.setIcon(new ImageIcon(Tienda.class.getResource("/img/rs_youtube.png")));
		lblYoutube.setBounds(1487, 285, 64, 64);
		panelContenido.add(lblYoutube);
		
		lblManual = new JLabel("MANUAL DEL USUARIO");
		lblManual.setHorizontalAlignment(SwingConstants.CENTER);
		lblManual.setForeground(new Color(51, 102, 204));
		lblManual.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblManual.setBounds(1284, 49, 267, 29);
		panelContenido.add(lblManual);
		
		lblIconoManualUsuario = new JLabel("");
		lblIconoManualUsuario.addMouseListener(this);
		lblIconoManualUsuario.setIcon(new ImageIcon(Tienda.class.getResource("/img/iconoManualUsuario.png")));
		lblIconoManualUsuario.setBounds(1360, 82, 140, 128);
		panelContenido.add(lblIconoManualUsuario);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Tienda.class.getResource("/img/logoLogin2.png")));
		lblLogo.setBounds(-14, -12, 856, 282);
		panelContenido.add(lblLogo);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Tienda.class.getResource("/img/fondoPrincipal.png")));
		lblFondo.setBounds(0, -43, 1596, 817);
		panelContenido.add(lblFondo);
		
		herramientasMantenimiento = new JToolBar();
		herramientasMantenimiento.setBounds(0, 0, 139, 41);
		getContentPane().add(herramientasMantenimiento);
		
		btnConsultar = new JButton("");
		btnConsultar.setToolTipText("Consultar papel");
		btnConsultar.addActionListener(this);
		btnConsultar.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemConsultarPapel.png")));
		herramientasMantenimiento.add(btnConsultar);
		
		btnModificar = new JButton("");
		btnModificar.setToolTipText("Modificar Papel");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemModificarPapel.png")));
		herramientasMantenimiento.add(btnModificar);
		
		btnListar = new JButton("");
		btnListar.setToolTipText("Listar papel");
		btnListar.addActionListener(this);
		btnListar.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemListarPapel.png")));
		herramientasMantenimiento.add(btnListar);
		
		herramientasVentas = new JToolBar();
		herramientasVentas.setBounds(138, 2, 91, 39);
		getContentPane().add(herramientasVentas);
		
		btnVender = new JButton("");
		btnVender.setToolTipText("Vender");
		btnVender.addActionListener(this);
		herramientasVentas.add(btnVender);
		btnVender.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemVender.png")));
		
		btnGenerarReportes = new JButton("");
		btnGenerarReportes.setToolTipText("Generar reportes");
		btnGenerarReportes.addActionListener(this);
		herramientasVentas.add(btnGenerarReportes);
		btnGenerarReportes.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemGenerarReporte.png")));
		
		herramientasConfiguracion = new JToolBar();
		herramientasConfiguracion.setBounds(226, 2, 169, 41);
		getContentPane().add(herramientasConfiguracion);
		
		btnConfigurarDescuentos = new JButton("");
		btnConfigurarDescuentos.setToolTipText("Configurar descuentos");
		btnConfigurarDescuentos.addActionListener(this);
		herramientasConfiguracion.add(btnConfigurarDescuentos);
		btnConfigurarDescuentos.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemDescuento.png")));
		
		btnConfigurarObsequio = new JButton("");
		btnConfigurarObsequio.setToolTipText("Configurar obsequio");
		btnConfigurarObsequio.addActionListener(this);
		herramientasConfiguracion.add(btnConfigurarObsequio);
		btnConfigurarObsequio.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemObsequio.png")));
		
		btnConfigurarOptima = new JButton("");
		btnConfigurarOptima.setToolTipText("Configurar cantidad \u00F3ptima de resmas vendidas");
		btnConfigurarOptima.addActionListener(this);
		herramientasConfiguracion.add(btnConfigurarOptima);
		btnConfigurarOptima.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemOptima.png")));
		
		btnPremioSorpresa = new JButton("");
		btnPremioSorpresa.setToolTipText("Configurar premio sorpresa");
		btnPremioSorpresa.addActionListener(this);
		herramientasConfiguracion.add(btnPremioSorpresa);
		btnPremioSorpresa.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemSorpresa.png")));
		
		herramientasAyuda = new JToolBar();
		herramientasAyuda.setBounds(399, 0, 91, 41);
		getContentPane().add(herramientasAyuda);
		
		btnManualUsuario = new JButton("");
		btnManualUsuario.setToolTipText("Manual del usuario");
		btnManualUsuario.addActionListener(this);
		herramientasAyuda.add(btnManualUsuario);
		btnManualUsuario.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemManualUsuario.png")));
		
		btnAyuda = new JButton("");
		btnAyuda.setToolTipText("Acerca de Tienda");
		btnAyuda.addActionListener(this);
		herramientasAyuda.add(btnAyuda);
		btnAyuda.setIcon(new ImageIcon(Tienda.class.getResource("/img/itemAbout.png")));
		
		panelBarraEstado = new JPanel();
		panelBarraEstado.setBounds(0, 784, 1596, 32);
		panelBarraEstado.setBackground(Color.PINK);
		getContentPane().add(panelBarraEstado);
		panelBarraEstado.setLayout(new BorderLayout(0, 0));
		
		barraEstado = new JMenuBar();
		barraEstado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		panelBarraEstado.add(barraEstado, BorderLayout.NORTH);
		
		mntmTipoUsuario = new JMenuItem("Tipo de usuario:");
		mntmTipoUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTipoUsuario.setIcon(new ImageIcon(Tienda.class.getResource("/img/iconoUsuarioBarraEstado.png")));
		mntmTipoUsuario.setForeground(new Color(0, 0, 102));
		mntmTipoUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		barraEstado.add(mntmTipoUsuario);
		
		mntmDerechosReservados = new JMenuItem("Derechos Reservados 2016 - Tienda v1.0");
		mntmDerechosReservados.setHorizontalAlignment(SwingConstants.LEFT);
		mntmDerechosReservados.setIcon(new ImageIcon(Tienda.class.getResource("/img/iconoCopyright.png")));
		mntmDerechosReservados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		barraEstado.add(mntmDerechosReservados);
		
		mntmFechaHora = new JMenuItem("Fecha y hora");
		mntmFechaHora.setHorizontalAlignment(SwingConstants.LEFT);
		mntmFechaHora.setIcon(new ImageIcon(Tienda.class.getResource("/img/iconoFechaHora.png")));
		mntmFechaHora.setFont(new Font("Segoe UI", Font.BOLD, 14));
		barraEstado.add(mntmFechaHora);
		
		iniciaReloj(mntmFechaHora);
		configurarPrivilegios();
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAyuda) {
			actionPerformedBtnAyuda(e);
		}
		if (e.getSource() == btnManualUsuario) {
			actionPerformedBtnManualUsuario(e);
		}
		if (e.getSource() == btnPremioSorpresa) {
			actionPerformedBtnPremioSorpresa(e);
		}
		if (e.getSource() == btnConfigurarOptima) {
			actionPerformedBtnConfigurarOptima(e);
		}
		if (e.getSource() == btnConfigurarObsequio) {
			actionPerformedBtnConfigurarObsequio(e);
		}
		if (e.getSource() == btnConfigurarDescuentos) {
			actionPerformedBtnConfigurarDescuentos(e);
		}
		if (e.getSource() == btnGenerarReportes) {
			actionPerformedBtnGenerarReportes(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmConfiguracionPremio) {
			actionPerformedMntmConfigurarPremioSorpresa(e);
		}
		if (e.getSource() == mntmConfiguracionOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		if (e.getSource() == mntmConfiguracionObsequio) {
			actionPerformedMntmConfigurarObsequio(e);
		}
		if (e.getSource() == mntmConfiguracionDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmMantenimientoListar) {
			actionPerformedMntmListarPapeles(e);
		}
		if (e.getSource() == mntmMantenimientoModificar) {
			actionPerformedMntmModificarPapel(e);
		}
		if (e.getSource() == mntmMantenimientoConsultar) {
			actionPerformedMntmConsultarPapel(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
	// Procesa la pulsación del menú item Salir
	protected void actionPerformedMntmSalir(ActionEvent e) {
		
		// Pide la confirmación del usuario para salir
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir del programa?", 
				"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
		
		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	protected void actionPerformedMntmConsultarPapel(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoMantenimientoConsultar dmc = new DialogoMantenimientoConsultar();
		
		// Centra el cuadro de diálogo en la Tienda
		dmc.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dmc.setVisible(true);
	}
	
	protected void actionPerformedMntmModificarPapel(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoMantenimientoModificar dmm = new DialogoMantenimientoModificar();
		
		// Centra el cuadro de diálogo en la Tienda
		dmm.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dmm.setVisible(true);
	}
	
	protected void actionPerformedMntmListarPapeles(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoMantenimientoListar dml = new DialogoMantenimientoListar();
		
		// Centra el cuadro de diálogo en la Tienda
		dml.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dml.setVisible(true);
	}
	
	protected void actionPerformedMntmVender(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoVentasVender dvv = new DialogoVentasVender();
		
		// Centra el cuadro de diálogo en la Tienda
		dvv.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dvv.setVisible(true);
	}
	
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoVentasGenerarReportes dvgr = new DialogoVentasGenerarReportes();
		
		// Centra el cuadro de diálogo en la Tienda
		dvgr.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dvgr.setVisible(true);
	}
	
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoConfiguracionDescuentos dcd = new DialogoConfiguracionDescuentos();
		
		// Centra el cuadro de diálogo en la Tienda
		dcd.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dcd.setVisible(true);
	}
	
	protected void actionPerformedMntmConfigurarObsequio(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoConfiguracionObsequio dco = new DialogoConfiguracionObsequio();
		
		// Centra el cuadro de diálogo en la Tienda
		dco.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dco.setVisible(true);
	}
	
	protected void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoConfiguracionOptima dco = new DialogoConfiguracionOptima();
		
		// Centra el cuadro de diálogo en la Tienda
		dco.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dco.setVisible(true);
	}
	
	protected void actionPerformedMntmConfigurarPremioSorpresa(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoConfiguracionPremioSorpresa dcps = new DialogoConfiguracionPremioSorpresa();
		
		// Centra el cuadro de diálogo en la Tienda
		dcps.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dcps.setVisible(true);
	}
	
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoAcercaDe dad = new DialogoAcercaDe();
		
		// Centra el cuadro de diálogo en la Tienda
		dad.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dad.setVisible(true);
	}
	
	// Deshabilita ciertos menús o menú items, de acuerdo al privilegio del usuario que inicia sesión
	void configurarPrivilegios() {
		if (Tienda.tipoPrivilegio == Tienda.VENDEDOR) {
			mntmMantenimientoModificar.setEnabled(false);
			mntmConfiguracionDescuentos.setEnabled(false);
			mntmConfiguracionObsequio.setEnabled(false);
			mntmConfiguracionOptima.setEnabled(false);
			mntmConfiguracionPremio.setEnabled(false);
			
			mntmMantenimientoModificar.setToolTipText(
					"Solo un administrador puede modificar los datos de las marcas de papel");
			mntmConfiguracionDescuentos.setToolTipText(
					"Solo un administrador puede configurar los porcentajes de descuento");
			mntmConfiguracionObsequio.setToolTipText(
					"Solo un administrador puede configurar el obsequio");
			mntmConfiguracionOptima.setToolTipText(
					"Solo un administrador puede configurar la cantidad óptima de resmas vendidas");
			mntmConfiguracionPremio.setToolTipText(
					"Solo un administrador puede configurar el premio sorpresa");
			
			mntmTipoUsuario.setText("Tipo de usuario: VENDEDOR");
		} else {
			mntmTipoUsuario.setText("Tipo de usuario: ADMINISTRADOR");
		}
	}
	
	void iniciaReloj(JMenuItem mntmFechaHora) {
		FechaHora fechaHora = new FechaHora(mntmFechaHora);
		fechaHora.actualiza();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblIconoManualUsuario) {
			mouseClickedLblIconoManualUsuario(e);
		}
		if (e.getSource() == lblYoutube) {
			mouseClickedLblYoutube(e);
		}
		if (e.getSource() == lblTwitter) {
			mouseClickedLblTwitter(e);
		}
		if (e.getSource() == lblFacebook) {
			mouseClickedLblFacebook(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	
	public void mouseExited(MouseEvent e) {
	}
	
	public void mousePressed(MouseEvent e) {
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	
	// Procesa la acción de haber echo un click en la etiqueta que tiene como imagen el ícono de Facebook
	protected void mouseClickedLblFacebook(MouseEvent e) {
		try {
		    Desktop.getDesktop().browse(new URL("https://www.facebook.com/Papersstore").toURI());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	// Procesa la acción de haber echo un click en la etiqueta que tiene como imagen el ícono de Twitter
	protected void mouseClickedLblTwitter(MouseEvent e) {
		try {
		    Desktop.getDesktop().browse(new URL("https://twitter.com/Papers_Store").toURI());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	// Procesa la acción de haber echo un click en la etiqueta que tiene como imagen el ícono de Youtube
	protected void mouseClickedLblYoutube(MouseEvent e) {
		try {
		    Desktop.getDesktop().browse(new URL("https://www.youtube.com/channel/UCPw6YbpRWXHs5o2i22JGX7w").toURI());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		try {
		    Desktop.getDesktop().browse(new URL("https://drive.google.com/file/d/0B5PJu2VRH1WzaE5mY1MyYzFnYm8/view?usp=sharing").toURI());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	protected void mouseClickedLblIconoManualUsuario(MouseEvent e) {
		try {
		    Desktop.getDesktop().browse(new URL("https://drive.google.com/file/d/0B5PJu2VRH1WzaE5mY1MyYzFnYm8/view?usp=sharing").toURI());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoMantenimientoConsultar dmc = new DialogoMantenimientoConsultar();
		
		// Centra el cuadro de diálogo en la Tienda
		dmc.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dmc.setVisible(true);
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoMantenimientoModificar dmm = new DialogoMantenimientoModificar();
		
		// Centra el cuadro de diálogo en la Tienda
		dmm.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dmm.setVisible(true);
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoMantenimientoListar dml = new DialogoMantenimientoListar();
		
		// Centra el cuadro de diálogo en la Tienda
		dml.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dml.setVisible(true);
	}
	
	protected void actionPerformedBtnVender(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoVentasVender dvv = new DialogoVentasVender();
		
		// Centra el cuadro de diálogo en la Tienda
		dvv.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dvv.setVisible(true);
	}
	
	protected void actionPerformedBtnGenerarReportes(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoVentasGenerarReportes dvgr = new DialogoVentasGenerarReportes();
		
		// Centra el cuadro de diálogo en la Tienda
		dvgr.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dvgr.setVisible(true);
	}
	
	protected void actionPerformedBtnConfigurarDescuentos(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoConfiguracionDescuentos dcd = new DialogoConfiguracionDescuentos();
		
		// Centra el cuadro de diálogo en la Tienda
		dcd.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dcd.setVisible(true);
	}
	
	protected void actionPerformedBtnConfigurarObsequio(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoConfiguracionObsequio dco = new DialogoConfiguracionObsequio();
		
		// Centra el cuadro de diálogo en la Tienda
		dco.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dco.setVisible(true);
	}
	
	protected void actionPerformedBtnConfigurarOptima(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoConfiguracionOptima dco = new DialogoConfiguracionOptima();
		
		// Centra el cuadro de diálogo en la Tienda
		dco.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dco.setVisible(true);
	}
	
	protected void actionPerformedBtnPremioSorpresa(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoConfiguracionPremioSorpresa dcps = new DialogoConfiguracionPremioSorpresa();
		
		// Centra el cuadro de diálogo en la Tienda
		dcps.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dcps.setVisible(true);
	}
	
	protected void actionPerformedBtnManualUsuario(ActionEvent e) {
		try {
		    Desktop.getDesktop().browse(new URL("https://drive.google.com/file/d/0B5PJu2VRH1WzaE5mY1MyYzFnYm8/view?usp=sharing").toURI());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	protected void actionPerformedBtnAyuda(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoAcercaDe dad = new DialogoAcercaDe();
		
		// Centra el cuadro de diálogo en la Tienda
		dad.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dad.setVisible(true);
	}
}
