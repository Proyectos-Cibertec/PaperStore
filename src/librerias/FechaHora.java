package librerias;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JMenuItem;

public class FechaHora implements Runnable {
	private JMenuItem mntmFechaHora;
	Thread hilo;
	
	public FechaHora(JMenuItem mntmFechaHora) {
		this.mntmFechaHora = mntmFechaHora;
		hilo = new Thread(this);
		hilo.start();
	}

	public void run() {
		Thread ct = Thread.currentThread();
		while (ct == hilo) {
			try {
				actualiza();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void actualiza() {
		Date fechaActual = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		String strFechaActual = df.format(fechaActual);
		
		df = new SimpleDateFormat("hh:mm:ss a");
		String strHoraActual = df.format(fechaActual);
		
		mntmFechaHora.setText(strFechaActual + " - " + strHoraActual);
	}
}
