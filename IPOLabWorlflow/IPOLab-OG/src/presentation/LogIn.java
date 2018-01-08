package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.AuthenticationException;
import dominio.Usuario;
import persistencia.Storage;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private final JLabel lblConfig = new JLabel(MessagesProjectOSInter.getString("LogIn.0")); //$NON-NLS-1$
	private JPasswordField passwordField;
	JLabel lblInformacion = new JLabel(MessagesProjectOSInter.getString("LogIn.1")); //$NON-NLS-1$
	JPanel pnlInformacion = new JPanel();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource(MessagesProjectOSInter.getString("LogIn.2")))); //$NON-NLS-1$
		setTitle(MessagesProjectOSInter.getString("LogIn.3")); //$NON-NLS-1$
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 101, 66, 23, 0, 32, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{27, 21, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblPhoto = new JLabel(MessagesProjectOSInter.getString("LogIn.4")); //$NON-NLS-1$
		lblPhoto.setIcon(new ImageIcon(LogIn.class.getResource(MessagesProjectOSInter.getString("LogIn.5")))); //$NON-NLS-1$
		lblPhoto.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.gridwidth = 2;
		gbc_lblPhoto.fill = GridBagConstraints.VERTICAL;
		gbc_lblPhoto.gridheight = 3;
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 0;
		gbc_lblPhoto.gridy = 1;
		panel.add(lblPhoto, gbc_lblPhoto);
		
		JLabel lblIngles = new JLabel(MessagesProjectOSInter.getString("LogIn.6")); //$NON-NLS-1$
		lblIngles.addMouseListener(new LblInglesMouseListener());
		lblIngles.setIcon(new ImageIcon(LogIn.class.getResource(MessagesProjectOSInter.getString("LogIn.7")))); //$NON-NLS-1$
		GridBagConstraints gbc_lblIngles = new GridBagConstraints();
		gbc_lblIngles.anchor = GridBagConstraints.EAST;
		gbc_lblIngles.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngles.gridx = 3;
		gbc_lblIngles.gridy = 1;
		panel.add(lblIngles, gbc_lblIngles);
		
		JLabel lblEspaña = new JLabel(MessagesProjectOSInter.getString("LogIn.8")); //$NON-NLS-1$
		lblEspaña.addMouseListener(new LblEspañaMouseListener());
		lblEspaña.setIcon(new ImageIcon(LogIn.class.getResource(MessagesProjectOSInter.getString("LogIn.9")))); //$NON-NLS-1$
		GridBagConstraints gbc_lblEspaña = new GridBagConstraints();
		gbc_lblEspaña.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspaña.gridx = 4;
		gbc_lblEspaña.gridy = 1;
		panel.add(lblEspaña, gbc_lblEspaña);
		
		GridBagConstraints gbc_lblConfig = new GridBagConstraints();
		gbc_lblConfig.anchor = GridBagConstraints.EAST;
		gbc_lblConfig.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfig.gridx = 5;
		gbc_lblConfig.gridy = 1;
		lblConfig.addMouseListener(new LblConfigMouseListener());
		lblConfig.setIcon(new ImageIcon(LogIn.class.getResource(MessagesProjectOSInter.getString("LogIn.10")))); //$NON-NLS-1$
		panel.add(lblConfig, gbc_lblConfig);
		
		JLabel lblHelp = new JLabel(MessagesProjectOSInter.getString("LogIn.11")); //$NON-NLS-1$
		lblHelp.addMouseListener(new LblHelpMouseListener());
		lblHelp.setIcon(new ImageIcon(LogIn.class.getResource(MessagesProjectOSInter.getString("LogIn.12")))); //$NON-NLS-1$
		GridBagConstraints gbc_lblHelp = new GridBagConstraints();
		gbc_lblHelp.anchor = GridBagConstraints.EAST;
		gbc_lblHelp.insets = new Insets(0, 0, 5, 5);
		gbc_lblHelp.gridx = 6;
		gbc_lblHelp.gridy = 1;
		panel.add(lblHelp, gbc_lblHelp);
		
		JLabel lblUsuario = new JLabel(MessagesProjectOSInter.getString("LogIn.lblUsuario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 2;
		gbc_lblUsuario.gridy = 2;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new TxtUsuarioMouseListener());
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 4;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 3;
		gbc_txtUsuario.gridy = 2;
		panel.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel(MessagesProjectOSInter.getString("LogIn.lblContrasea.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.gridx = 2;
		gbc_lblContrasea.gridy = 3;
		panel.add(lblContrasea, gbc_lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new PasswordFieldActionListener());
		passwordField.addMouseListener(new TxtUsuarioMouseListener());
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 4;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 3;
		panel.add(passwordField, gbc_passwordField);
		
		JButton btnLogin = new JButton(MessagesProjectOSInter.getString("LogIn.13")); //$NON-NLS-1$
		btnLogin.addActionListener(new BtnLoginActionListener());
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.EAST;
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 5;
		gbc_btnLogin.gridy = 4;
		panel.add(btnLogin, gbc_btnLogin);
		
		contentPane.add(pnlInformacion, BorderLayout.SOUTH);
		
		pnlInformacion.add(lblInformacion);
	}
	
	///// Listeners ////
	private class BtnLoginActionListener implements ActionListener {
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent arg0) {
			Storage st = Storage.getInstance();
			try {
				String passReal =MessagesProjectOSInter.getString("LogIn.14"); //$NON-NLS-1$
				int i;
				for(i = 0; i<st.getListaUsuarios().size(); i++) {
					if(st.getListaUsuarios().get(i).getDNI().equals(txtUsuario.getText())) {
						passReal = st.getListaUsuarios().get(i).getPassword();
						break;
					}
				}
				if(!passReal.equals(String.valueOf(passwordField.getPassword()))) throw new AuthenticationException();
				ProjectOS projectos = new ProjectOS(st.getListaUsuarios().get(i));
				dispose();
			}catch(AuthenticationException authE) {
				lblInformacion.setText(MessagesProjectOSInter.getString("LogIn.TituloErrorPane")); //$NON-NLS-1$
				lblInformacion.setForeground(Color.RED);
				passwordField.setBackground(Color.RED);
				txtUsuario.setBackground(Color.RED);
			}
		}
	}
	private class TxtUsuarioMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			passwordField.setText(MessagesProjectOSInter.getString("LogIn.16")); //$NON-NLS-1$
			txtUsuario.setBackground(Color.WHITE);
			passwordField.setBackground(Color.WHITE);
		}
	}
	private class PasswordFieldActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			BtnLoginActionListener listener = new BtnLoginActionListener();
			listener.actionPerformed(null);
		}
	}
	private class LblInglesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			MessagesProjectOSInter.setIdioma("inglés"); //$NON-NLS-1$
			LogIn ventana = new LogIn();
			ventana.setVisible(true);
			dispose();

		}
	}
	private class LblConfigMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ConfiguracionVentana cv = new ConfiguracionVentana();
		}
	}
	private class LblHelpMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			DialogoAyuda da = new DialogoAyuda();
		}
	}
	private class LblEspañaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			MessagesProjectOSInter.setIdioma("es"); //$NON-NLS-1$
			LogIn ventana = new LogIn();
			ventana.setVisible(true);
			dispose();
		}
	}

	
}
