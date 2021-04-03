

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;

public class DialogoAcercaDe extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JSeparator separator;
	private JLabel lblAutores;
	private JLabel lblGuisadoMenaLuis;
	private JButton btnCerrar;
	private JLabel lblViteMayauteEduardo;

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoAcercaDe dialog = new DialogoAcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoAcercaDe() {
		setModal(true);
		setResizable(false);
		setTitle("Acerca de tienda");
		setBounds(100, 100, 536, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTienda.setBounds(209, 11, 86, 20);
		contentPanel.add(lblTienda);
		
		separator = new JSeparator();
		separator.setBounds(20, 42, 487, 24);
		contentPanel.add(separator);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAutores.setBounds(242, 97, 53, 16);
		contentPanel.add(lblAutores);
		
		lblGuisadoMenaLuis = new JLabel("Guisado Mena Luis Alberto");
		lblGuisadoMenaLuis.setBounds(205, 124, 126, 14);
		contentPanel.add(lblGuisadoMenaLuis);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(232, 326, 89, 23);
		contentPanel.add(btnCerrar);
		
		lblViteMayauteEduardo = new JLabel("Vite Mayaute Eduardo");
		lblViteMayauteEduardo.setBounds(205, 145, 126, 14);
		contentPanel.add(lblViteMayauteEduardo);
		
	}
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	// Procesa la pulsación del botón Cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
}
