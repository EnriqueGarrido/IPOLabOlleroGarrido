package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private final JLabel lblConfig = new JLabel("");
	private JPasswordField passwordField;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/presentation/Icons/icon.png")));
		setTitle("ProjectOS (Login)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 101, 66, -23, 67, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{27, 21, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon(LogIn.class.getResource("/presentation/Icons/logox64.png")));
		lblPhoto.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.gridwidth = 2;
		gbc_lblPhoto.fill = GridBagConstraints.VERTICAL;
		gbc_lblPhoto.gridheight = 3;
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 0;
		gbc_lblPhoto.gridy = 1;
		panel.add(lblPhoto, gbc_lblPhoto);
		
		GridBagConstraints gbc_lblConfig = new GridBagConstraints();
		gbc_lblConfig.anchor = GridBagConstraints.EAST;
		gbc_lblConfig.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfig.gridx = 4;
		gbc_lblConfig.gridy = 1;
		lblConfig.setIcon(new ImageIcon(LogIn.class.getResource("/presentation/Icons/gear (1).png")));
		panel.add(lblConfig, gbc_lblConfig);
		
		JLabel lblHelp = new JLabel("");
		lblHelp.setIcon(new ImageIcon(LogIn.class.getResource("/presentation/Icons/question (2).png")));
		GridBagConstraints gbc_lblHelp = new GridBagConstraints();
		gbc_lblHelp.anchor = GridBagConstraints.EAST;
		gbc_lblHelp.insets = new Insets(0, 0, 5, 5);
		gbc_lblHelp.gridx = 5;
		gbc_lblHelp.gridy = 1;
		panel.add(lblHelp, gbc_lblHelp);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 2;
		gbc_lblUsuario.gridy = 2;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 3;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 3;
		gbc_txtUsuario.gridy = 2;
		panel.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.gridx = 2;
		gbc_lblContrasea.gridy = 3;
		panel.add(lblContrasea, gbc_lblContrasea);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 3;
		panel.add(passwordField, gbc_passwordField);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.EAST;
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 4;
		gbc_btnLogin.gridy = 4;
		panel.add(btnLogin, gbc_btnLogin);
		////ygsadfygdsf
	}

}
