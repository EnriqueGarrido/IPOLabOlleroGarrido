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
	private final JButton btnGuardar = new JButton("Guardar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguracionVentana frame = new ConfiguracionVentana();
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
	public ConfiguracionVentana() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{64, 106, 0, 0, 105, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 57, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_lblIdioma = new GridBagConstraints();
		gbc_lblIdioma.anchor = GridBagConstraints.EAST;
		gbc_lblIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdioma.gridx = 0;
		gbc_lblIdioma.gridy = 1;
		contentPane.add(lblIdioma, gbc_lblIdioma);
		
		GridBagConstraints gbc_cbIdioma = new GridBagConstraints();
		gbc_cbIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_cbIdioma.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbIdioma.gridx = 1;
		gbc_cbIdioma.gridy = 1;
		cbIdioma.setModel(new DefaultComboBoxModel(new String[] {"Espa\u00F1ol", "English"}));
		cbIdioma.setSelectedIndex(0);
		contentPane.add(cbIdioma, gbc_cbIdioma);
		
		GridBagConstraints gbc_lblTamaoDeFuente = new GridBagConstraints();
		gbc_lblTamaoDeFuente.anchor = GridBagConstraints.EAST;
		gbc_lblTamaoDeFuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTamaoDeFuente.gridx = 3;
		gbc_lblTamaoDeFuente.gridy = 1;
		contentPane.add(lblTamaoDeFuente, gbc_lblTamaoDeFuente);
		
		GridBagConstraints gbc_cbTamano = new GridBagConstraints();
		gbc_cbTamano.insets = new Insets(0, 0, 5, 5);
		gbc_cbTamano.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTamano.gridx = 4;
		gbc_cbTamano.gridy = 1;
		cbTamano.setModel(new DefaultComboBoxModel(new String[] {"Peque\u00F1o", "Mediano", "Grande"}));
		contentPane.add(cbTamano, gbc_cbTamano);
		
		GridBagConstraints gbc_lblFuente = new GridBagConstraints();
		gbc_lblFuente.anchor = GridBagConstraints.EAST;
		gbc_lblFuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuente.gridx = 0;
		gbc_lblFuente.gridy = 3;
		contentPane.add(lblFuente, gbc_lblFuente);
		
		GridBagConstraints gbc_cbFuente = new GridBagConstraints();
		gbc_cbFuente.insets = new Insets(0, 0, 5, 5);
		gbc_cbFuente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbFuente.gridx = 1;
		gbc_cbFuente.gridy = 3;
		cbFuente.setModel(new DefaultComboBoxModel(new String[] {"Tahoma", "Arial", "Calibri", "Time New Roman"}));
		contentPane.add(cbFuente, gbc_cbFuente);
		
		GridBagConstraints gbc_lblLayout = new GridBagConstraints();
		gbc_lblLayout.anchor = GridBagConstraints.EAST;
		gbc_lblLayout.insets = new Insets(0, 0, 5, 5);
		gbc_lblLayout.gridx = 3;
		gbc_lblLayout.gridy = 3;
		lblLayout.setEnabled(false);
		contentPane.add(lblLayout, gbc_lblLayout);
		
		GridBagConstraints gbc_cbLayout = new GridBagConstraints();
		gbc_cbLayout.insets = new Insets(0, 0, 5, 5);
		gbc_cbLayout.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbLayout.gridx = 4;
		gbc_cbLayout.gridy = 3;
		cbLayout.setEnabled(false);
		cbLayout.setModel(new DefaultComboBoxModel(new String[] {"Gridbag"}));
		contentPane.add(cbLayout, gbc_cbLayout);
		
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 4;
		gbc_btnGuardar.gridy = 4;
		contentPane.add(btnGuardar, gbc_btnGuardar);
	}

}
