package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;

public class Login extends JFrame implements ActionListener {
	// Se usa la propiedad Undecorated para quitar la barra de título
	
	// Declaración de variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnIniciarSesion;
	private JButton btnSalir;
	private JPasswordField txtPassword;
	private JLabel lblFondo;
	private JLabel lblIconoUsuario;
	private JLabel label;
	private JLabel lblMiniatura;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JProgressBar pbBarraProgreso;
	private Timer timer;
	
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
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/iconoVentanaLogin.png")));
		setUndecorated(true);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Ingreso al Sistema");
		setBounds(100, 100, 547, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(255, 255, 153));
		txtUsuario.setToolTipText("Ingrese su nombre de usuario.");
		txtUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.addActionListener(this);
		
		lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setIcon(new ImageIcon(Login.class.getResource("/img/iconoUsuarioPeque\u00F1o.png")));
		lblIconoUsuario.setBounds(189, 155, 32, 31);
		contentPane.add(lblIconoUsuario);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/iconoPasswordPeque\u00F1o.png")));
		label.setBounds(189, 197, 32, 31);
		contentPane.add(label);
		
		lblMiniatura = new JLabel("");
		lblMiniatura.setBackground(Color.WHITE);
		lblMiniatura.setIcon(new ImageIcon(Login.class.getResource("/img/iconoLoginChico.png")));
		lblMiniatura.setBounds(31, 144, 128, 143);
		contentPane.add(lblMiniatura);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/textoAcceso.png")));
		lblNewLabel.setBounds(188, 103, 317, 46);
		contentPane.add(lblNewLabel);
		txtUsuario.setBounds(242, 155, 249, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnIniciarSesion = new JButton("Ingresar");
		btnIniciarSesion.setToolTipText("Pulse aqu\u00ED para ingresar al sistema luego de haber introducido su nombre de usuario y contrase\u00F1a.");
		btnIniciarSesion.setIcon(new ImageIcon(Login.class.getResource("/img/iconoLoginPeque\u00F1o.png")));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIniciarSesion.setForeground(Color.BLACK);
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setBounds(242, 241, 124, 46);
		contentPane.add(btnIniciarSesion);
		
		btnSalir = new JButton("Salir");
		btnSalir.setToolTipText("Pulse aqu\u00ED para salir de la ventana de acceso al sistema.");
		btnSalir.setIcon(new ImageIcon(Login.class.getResource("/img/iconoBtnSalirPeque\u00F1o.png")));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(376, 241, 119, 46);
		contentPane.add(btnSalir);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(new Color(255, 255, 153));
		txtPassword.setToolTipText("Ingrese su contrase\u00F1a.");
		txtPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(242, 197, 249, 31);
		contentPane.add(txtPassword);
		
		pbBarraProgreso = new JProgressBar();
		pbBarraProgreso.setForeground(new Color(0, 153, 204));
		pbBarraProgreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		pbBarraProgreso.setStringPainted(true);
		pbBarraProgreso.setVisible(false);
		pbBarraProgreso.setBounds(41, 298, 450, 27);
		contentPane.add(pbBarraProgreso);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/img/fondoLogin.png")));
		lblFondo.setForeground(Color.YELLOW);
		lblFondo.setBounds(0, 0, 547, 337);
		contentPane.add(lblFondo);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/img/logoLogin.png")));
		lblLogo.setBounds(68, 0, 456, 133);
		contentPane.add(lblLogo);
		txtPassword.addActionListener(this);
		
		setLocationRelativeTo(null); // Centra la ventana
	}
	
	// Contabiliza el # de intentos de logeo
	int contador;
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtUsuario) {
			actionPerformedTxtUsuario(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnIniciarSesion || e.getSource() == txtPassword) {
			actionPerformedBtnIniciarSecion(e);
		}
	}
	
	// Procesa la pulsación del botón Iniciar Sesión
	protected void actionPerformedBtnIniciarSecion(ActionEvent e) {
		iniciarSesion();
	}
	
	// Inicia sesión en el sistema
	void iniciarSesion() {
		String usuario;
		String password;
		boolean esCorrecto; // Variable que permite saber si los credenciales son correctos
		
		usuario = getUsuario();
		password = getPassword();
		
		// Detecta cuando se ingresa un usuario y/o password en blanco
		if (usuario.length() == 0 && password.length() == 0) {
			mensajeError("No debe dejar en blanco el nombre de usuario y contraseña", "Datos incorrectos");
			txtUsuario.requestFocus();
			return;
			
		} else if (usuario.length() == 0) {
			mensajeError("No debe dejar en blanco el nombre de usuario", "Dato incorrecto");
			txtUsuario.requestFocus();
			return;
			
		} else if (password.length() == 0) {
			mensajeError("No debe dejar en blanco la contraseña", "Dato incorrecto");
			txtPassword.requestFocus();
			return;
		}
		
		esCorrecto = login(usuario, password); // Verifica que se pueda ingresar al Sistema
		
		// Verifica que no se haya pasado el límite de intentos fallidos
		if (contador == 3 && !esCorrecto) {
			mensajeError("Ha sobrepasado el límite de intentos fallidos. Comuníquese con el Administrador del Sistema", 
					"Error de inicio de sesión");
			System.exit(0);
		}
		
		if (esCorrecto) {
			
			// Se inicia el efecto de carga en la barra de progreso y luego se abre el programa principal
			cargarPrograma();
			
		} else {
			mensajeError("No puede iniciar sesión. " + 
					"El usuario y/o contraseña que ha ingresado es incorrecto. Intente nuevamente.\n" + 
					"Verifique la tecla Bloq Mayus. Recuerde que luego de 3 intentos fallidos el programa " + 
					"se cerrará.", "Error de inicio de sesión");
			txtUsuario.setText("");
			txtPassword.setText("");
			txtUsuario.requestFocus();
		}
	}
	
	String getUsuario() {
		return txtUsuario.getText();
	}
	
	String getPassword() {
		String password;
		
		password = new String(txtPassword.getPassword());
		
		return password;
	}
	
	// Verifica que el usuario y contraseña sean correctos
	boolean login(String usuario, String password) {
		boolean esCorrecto;
		contador++; // Cuenta las veces que un usuario intenta logearse al sistema
		
		// Valida si el usuario y contraseña existen
		if (usuario.equals(Tienda.adminUsuario0) && password.equals(Tienda.adminPassword0) ||
			usuario.equals(Tienda.adminUsuario1) && password.equals(Tienda.adminPassword1)) {
			Tienda.tipoPrivilegio = Tienda.ADMINISTRADOR; // Asigna el tipo de privilegio de Administrador
			esCorrecto = true;
			
		} else if (usuario.equals(Tienda.vendedorUsuario0) && password.equals(Tienda.vendedorPassword0)) {
			Tienda.tipoPrivilegio = Tienda.VENDEDOR; // Asigna el tipo de privilegio de Vendedor
			esCorrecto = true;
			
		} else { // El usuario y/o password no existen
			esCorrecto = false;
		}
		
		return esCorrecto;
	}
	
	protected void actionPerformedBtnSalir(ActionEvent e) {
		salir();
	}
	
	// Método que pide la usuario que confirme en caso que desee salir de la ventana de Login
	void salir() {
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
		
		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	// Muestra un mensaje de error en la pantalla con un mensaje y título específico
	void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	// Procesa el efecto de pulsar ENTER en el cuadro de texto txtUsuario
	protected void actionPerformedTxtUsuario(ActionEvent e) {
		txtPassword.requestFocus();
	}
	
	// Inicia el efecto de carga en la barra de progreso y luego se abre el programa principal
	void cargarPrograma() {
		pbBarraProgreso.setVisible(true);
		pbBarraProgreso.setValue(0);
		
		// Se deshabilita los cuadros de texto y los botones
		txtUsuario.setEnabled(false);
		txtPassword.setEnabled(false);
		btnIniciarSesion.setEnabled(false);
		btnSalir.setEnabled(false);
		
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pbBarraProgreso.getValue() < 100) {
					pbBarraProgreso.setValue(pbBarraProgreso.getValue() + 1);
					
				} else {
					timer.stop();
					cargarProgramaPrincipal(); // Abre el programa principal
				}
			}
		});
		timer.start();
	}
	
	// Carga el programa principal
	void cargarProgramaPrincipal() {
		
		// Declara y crea el JFrame Tienda
		Tienda tienda = new Tienda();
		
		// Finaliza la ventana de Login
		this.dispose();
		
		JOptionPane.showMessageDialog(this, "Bienvenido al Sistema");
		
		// Hace visible el JFrame Tienda
		tienda.setVisible(true);
	}
}
