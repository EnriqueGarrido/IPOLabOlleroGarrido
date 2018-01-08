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
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAyuda {

	private JFrame frame;
	private final JPanel panelDialogo = new JPanel();
	private final JLabel DialogoLabel = new JLabel(
	MessagesProjectOSInter.getString("DialogoAyuda.DialogoLabel.text")); //$NON-NLS-1$
	private final JLabel lblInformation = new JLabel("https://github.com/adrian-ollero/IPOLabOlleroGarrido/wiki\r\n");
	private final JPanel buttonPane = new JPanel();
	private final JButton okButton = new JButton("OK");

	public DialogoAyuda() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(400, 200));
		frame.setResizable(false);
		frame.setBounds(100, 100, 418, 190);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		frame.getContentPane().add(panelDialogo, BorderLayout.CENTER);
		panelDialogo.setLayout(null);
		DialogoLabel.setBounds(20, 41, 410, 23);

		panelDialogo.add(DialogoLabel);
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInformation.setForeground(Color.BLUE);
		lblInformation.addMouseListener(new LblInformationMouseListener());
		lblInformation.setBounds(47, 64, 298, 51);
		panelDialogo.add(lblInformation);
		
		frame.getContentPane().add(buttonPane, BorderLayout.SOUTH);
		okButton.addActionListener(new OkButtonActionListener());
		
		buttonPane.add(okButton);
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
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	}
}
