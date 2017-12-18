package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.JList;

public class PanelInformacionUsuario extends JPanel {
	private final JLabel lblNombre = new JLabel("Nombre:");
	private final JLabel lblRol = new JLabel("Rol:");
	private final JLabel lblConocimientos = new JLabel("Conocimientos:");
	private final JLabel lblContacto = new JLabel("Contacto:");
	private final JLabel lblTareas = new JLabel("Tareas:");
	private final JTextField txtNombre = new JTextField();
	private final JTextField txtRol = new JTextField();
	private final JTextField txtConocimientos = new JTextField();
	private final JTextField txtContacto = new JTextField();
	private final JLabel lblFoto = new JLabel("");
	private final JList listTareas = new JList();

	/**
	 * Create the panel.
	 */
	public PanelInformacionUsuario() {
		txtContacto.setColumns(10);
		txtRol.setColumns(10);
		txtNombre.setColumns(10);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 144, 0, 80, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		add(txtNombre, gbc_txtNombre);
		
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.fill = GridBagConstraints.VERTICAL;
		gbc_lblFoto.gridheight = 4;
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridx = 4;
		gbc_lblFoto.gridy = 1;
		lblFoto.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblFoto.setIcon(new ImageIcon(PanelInformacionUsuario.class.getResource("/presentation/Icons/user-silhouette.png")));
		add(lblFoto, gbc_lblFoto);
		
		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.anchor = GridBagConstraints.EAST;
		gbc_lblRol.insets = new Insets(0, 0, 5, 5);
		gbc_lblRol.gridx = 1;
		gbc_lblRol.gridy = 2;
		add(lblRol, gbc_lblRol);
		
		GridBagConstraints gbc_txtRol = new GridBagConstraints();
		gbc_txtRol.insets = new Insets(0, 0, 5, 5);
		gbc_txtRol.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRol.gridx = 2;
		gbc_txtRol.gridy = 2;
		add(txtRol, gbc_txtRol);
		
		GridBagConstraints gbc_lblConocimientos = new GridBagConstraints();
		gbc_lblConocimientos.anchor = GridBagConstraints.EAST;
		gbc_lblConocimientos.insets = new Insets(0, 0, 5, 5);
		gbc_lblConocimientos.gridx = 1;
		gbc_lblConocimientos.gridy = 3;
		add(lblConocimientos, gbc_lblConocimientos);
		txtConocimientos.setColumns(10);
		
		GridBagConstraints gbc_txtConocimientos = new GridBagConstraints();
		gbc_txtConocimientos.insets = new Insets(0, 0, 5, 5);
		gbc_txtConocimientos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConocimientos.gridx = 2;
		gbc_txtConocimientos.gridy = 3;
		add(txtConocimientos, gbc_txtConocimientos);
		
		GridBagConstraints gbc_lblContacto = new GridBagConstraints();
		gbc_lblContacto.anchor = GridBagConstraints.EAST;
		gbc_lblContacto.insets = new Insets(0, 0, 5, 5);
		gbc_lblContacto.gridx = 1;
		gbc_lblContacto.gridy = 4;
		add(lblContacto, gbc_lblContacto);
		
		GridBagConstraints gbc_txtContacto = new GridBagConstraints();
		gbc_txtContacto.insets = new Insets(0, 0, 5, 5);
		gbc_txtContacto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContacto.gridx = 2;
		gbc_txtContacto.gridy = 4;
		add(txtContacto, gbc_txtContacto);
		
		GridBagConstraints gbc_lblTareas = new GridBagConstraints();
		gbc_lblTareas.anchor = GridBagConstraints.EAST;
		gbc_lblTareas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTareas.gridx = 1;
		gbc_lblTareas.gridy = 5;
		add(lblTareas, gbc_lblTareas);
		
		GridBagConstraints gbc_listTareas = new GridBagConstraints();
		gbc_listTareas.gridwidth = 4;
		gbc_listTareas.insets = new Insets(0, 0, 5, 5);
		gbc_listTareas.fill = GridBagConstraints.BOTH;
		gbc_listTareas.gridx = 1;
		gbc_listTareas.gridy = 6;
		add(listTareas, gbc_listTareas);

	}

}
