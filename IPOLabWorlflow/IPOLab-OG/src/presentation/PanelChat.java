package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelChat extends JPanel {
	private final JTextArea txtaChat = new JTextArea();
	private final JTextArea txtaMensajee = new JTextArea();
	private final JButton btnEnviarMensaje = new JButton(MessagesProjectOSInter.getString("PanelChat.btnEnviarMensaje.text")); //$NON-NLS-1$
	private final JScrollPane scrollPaneMensajes = new JScrollPane();
	
	private String usuarioLogIn;
	private final JButton btnAdjuntar = new JButton("");
	/**
	 * Create the panel.
	 */
	public PanelChat(String usuarioLogIn) {
		this.usuarioLogIn = usuarioLogIn;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{28, 224, 59, 46, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 0, 45, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_scrollPaneMensajes = new GridBagConstraints();
		gbc_scrollPaneMensajes.gridwidth = 3;
		gbc_scrollPaneMensajes.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneMensajes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneMensajes.gridx = 1;
		gbc_scrollPaneMensajes.gridy = 1;
		add(scrollPaneMensajes, gbc_scrollPaneMensajes);
		txtaChat.setEditable(false);
		txtaChat.setLineWrap(true);
		scrollPaneMensajes.setViewportView(txtaChat);
		
		GridBagConstraints gbc_txtaMensajee = new GridBagConstraints();
		gbc_txtaMensajee.insets = new Insets(0, 0, 5, 5);
		gbc_txtaMensajee.fill = GridBagConstraints.BOTH;
		gbc_txtaMensajee.gridx = 1;
		gbc_txtaMensajee.gridy = 2;
		txtaMensajee.setLineWrap(true);
		add(txtaMensajee, gbc_txtaMensajee);
		
		GridBagConstraints gbc_btnEnviarMensaje = new GridBagConstraints();
		gbc_btnEnviarMensaje.fill = GridBagConstraints.BOTH;
		gbc_btnEnviarMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnviarMensaje.gridx = 2;
		gbc_btnEnviarMensaje.gridy = 2;
		btnEnviarMensaje.addActionListener(new BtnEnviarMensajeActionListener());
		add(btnEnviarMensaje, gbc_btnEnviarMensaje);
		
		GridBagConstraints gbc_btnAdjuntar = new GridBagConstraints();
		gbc_btnAdjuntar.fill = GridBagConstraints.VERTICAL;
		gbc_btnAdjuntar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdjuntar.gridx = 3;
		gbc_btnAdjuntar.gridy = 2;
		btnAdjuntar.setIcon(new ImageIcon(PanelChat.class.getResource("/presentation/Icons/note.png")));
		btnAdjuntar.setEnabled(false);
		add(btnAdjuntar, gbc_btnAdjuntar);

	}

	private class BtnEnviarMensajeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(!txtaMensajee.getText().equals("")) {
				txtaChat.setText(txtaChat.getText() + "\n" + usuarioLogIn + ": " + txtaMensajee.getText());
				txtaMensajee.setText("");
			}
		}
	}
}
