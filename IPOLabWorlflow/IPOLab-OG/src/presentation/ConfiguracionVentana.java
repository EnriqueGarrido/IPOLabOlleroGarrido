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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ConfiguracionVentana extends JFrame {

	private JPanel contentPane;
	private final JLabel lblIdioma = new JLabel("Idioma:");
	private final JComboBox cbIdioma = new JComboBox();
	private final JLabel lblTamaoDeFuente = new JLabel("Tama\u00F1o de Fuente:");
	private final JComboBox cbTamano = new JComboBox();
	private final JLabel lblLayout = new JLabel("Layout:");
	private final JLabel lblFuente = new JLabel("Fuente:");
	private final JComboBox cbFuente = new JComboBox();
	private final JComboBox cbLayout = new JComboBox();
	private final JButton btnAceptar = new JButton("Aceptar");

	/**
	 * Create the frame.
	 */
	public ConfiguracionVentana() {
		setTitle("Configuraci\u00F3n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{64, 106, 0, 0, 105, 0, 0};
		gbl_contentPane.rowHeights = new int[]{71, 39, 57, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_lblIdioma = new GridBagConstraints();
		gbc_lblIdioma.anchor = GridBagConstraints.EAST;
		gbc_lblIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdioma.gridx = 0;
		gbc_lblIdioma.gridy = 0;
		contentPane.add(lblIdioma, gbc_lblIdioma);
		
		GridBagConstraints gbc_cbIdioma = new GridBagConstraints();
		gbc_cbIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_cbIdioma.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbIdioma.gridx = 1;
		gbc_cbIdioma.gridy = 0;
		cbIdioma.setModel(new DefaultComboBoxModel(new String[] {"Espa\u00F1ol", "English"}));
		cbIdioma.setSelectedIndex(0);
		contentPane.add(cbIdioma, gbc_cbIdioma);
		
		GridBagConstraints gbc_lblTamaoDeFuente = new GridBagConstraints();
		gbc_lblTamaoDeFuente.anchor = GridBagConstraints.EAST;
		gbc_lblTamaoDeFuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTamaoDeFuente.gridx = 3;
		gbc_lblTamaoDeFuente.gridy = 0;
		contentPane.add(lblTamaoDeFuente, gbc_lblTamaoDeFuente);
		
		GridBagConstraints gbc_cbTamano = new GridBagConstraints();
		gbc_cbTamano.insets = new Insets(0, 0, 5, 5);
		gbc_cbTamano.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTamano.gridx = 4;
		gbc_cbTamano.gridy = 0;
		cbTamano.setModel(new DefaultComboBoxModel(new String[] {"Peque\u00F1o", "Mediano", "Grande"}));
		contentPane.add(cbTamano, gbc_cbTamano);
		
		GridBagConstraints gbc_lblFuente = new GridBagConstraints();
		gbc_lblFuente.anchor = GridBagConstraints.EAST;
		gbc_lblFuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuente.gridx = 0;
		gbc_lblFuente.gridy = 1;
		lblFuente.setEnabled(false);
		contentPane.add(lblFuente, gbc_lblFuente);
		
		GridBagConstraints gbc_cbFuente = new GridBagConstraints();
		gbc_cbFuente.insets = new Insets(0, 0, 5, 5);
		gbc_cbFuente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbFuente.gridx = 1;
		gbc_cbFuente.gridy = 1;
		cbFuente.setEnabled(false);
		cbFuente.setModel(new DefaultComboBoxModel(new String[] {"Tahoma", "Arial", "Calibri", "Time New Roman"}));
		contentPane.add(cbFuente, gbc_cbFuente);
		
		GridBagConstraints gbc_lblLayout = new GridBagConstraints();
		gbc_lblLayout.anchor = GridBagConstraints.EAST;
		gbc_lblLayout.insets = new Insets(0, 0, 5, 5);
		gbc_lblLayout.gridx = 3;
		gbc_lblLayout.gridy = 1;
		lblLayout.setEnabled(false);
		contentPane.add(lblLayout, gbc_lblLayout);
		
		GridBagConstraints gbc_cbLayout = new GridBagConstraints();
		gbc_cbLayout.insets = new Insets(0, 0, 5, 5);
		gbc_cbLayout.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbLayout.gridx = 4;
		gbc_cbLayout.gridy = 1;
		cbLayout.setEnabled(false);
		cbLayout.setModel(new DefaultComboBoxModel(new String[] {"Gridbag"}));
		contentPane.add(cbLayout, gbc_cbLayout);
		
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 4;
		gbc_btnAceptar.gridy = 2;
		contentPane.add(btnAceptar, gbc_btnAceptar);
		setVisible(true);
	}

}
