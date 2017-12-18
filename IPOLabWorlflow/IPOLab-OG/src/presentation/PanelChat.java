package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PanelChat extends JPanel {
	private final JTextArea txtaChat = new JTextArea();
	private final JTextArea txtaMensajee = new JTextArea();
	private final JButton btnEnviarMensaje = new JButton("Enviar");

	/**
	 * Create the panel.
	 */
	public PanelChat() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{28, 58, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 0, 45, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_txtaChat = new GridBagConstraints();
		gbc_txtaChat.gridwidth = 3;
		gbc_txtaChat.insets = new Insets(0, 0, 5, 5);
		gbc_txtaChat.fill = GridBagConstraints.BOTH;
		gbc_txtaChat.gridx = 1;
		gbc_txtaChat.gridy = 1;
		add(txtaChat, gbc_txtaChat);
		
		GridBagConstraints gbc_txtaMensajee = new GridBagConstraints();
		gbc_txtaMensajee.insets = new Insets(0, 0, 5, 5);
		gbc_txtaMensajee.fill = GridBagConstraints.BOTH;
		gbc_txtaMensajee.gridx = 1;
		gbc_txtaMensajee.gridy = 2;
		add(txtaMensajee, gbc_txtaMensajee);
		
		GridBagConstraints gbc_btnEnviarMensaje = new GridBagConstraints();
		gbc_btnEnviarMensaje.fill = GridBagConstraints.BOTH;
		gbc_btnEnviarMensaje.gridwidth = 2;
		gbc_btnEnviarMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnviarMensaje.gridx = 2;
		gbc_btnEnviarMensaje.gridy = 2;
		add(btnEnviarMensaje, gbc_btnEnviarMensaje);

	}

}
