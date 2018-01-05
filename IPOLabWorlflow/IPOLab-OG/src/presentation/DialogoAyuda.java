package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.awt.Color;
import java.awt.Font;

public class DialogoAyuda {

	private JFrame frame;
	private final JPanel panelDialogo = new JPanel();
	private final JLabel DialogoLabel = new JLabel("Toda la ayuda que necesites la podr\u00E1s encontrar en el siguiente enlace:");
	private final JLabel lblInformation = new JLabel("https://github.com/adrian-ollero/IPOLabOlleroGarrido/wiki\r\n");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoAyuda window = new DialogoAyuda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DialogoAyuda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 370, 139);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panelDialogo, BorderLayout.CENTER);
		panelDialogo.setLayout(null);
		DialogoLabel.setBounds(10, 24, 352, 23);
		
		panelDialogo.add(DialogoLabel);
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInformation.setForeground(Color.BLUE);
		lblInformation.addMouseListener(new LblInformationMouseListener());
		lblInformation.setBounds(35, 48, 298, 51);
		panelDialogo.add(lblInformation);
	}

	private class LblInformationMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {
				if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
				desktop.browse(new URI("https://github.com/adrian-ollero/IPOLabOlleroGarrido/wiki"));
				}
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
			lblInformation.setForeground(Color.magenta);
		}
	}
}
