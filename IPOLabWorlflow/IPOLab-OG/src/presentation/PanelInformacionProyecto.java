package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentation.renders.ComboBox_projectIcon;
import presentation.renders.ComboBox_projectIcon_render;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelInformacionProyecto extends JPanel {
	private final JLabel lblNombre = new JLabel("Nombre:");
	private final JTextField txtNombre = new JTextField();
	private final JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
	private final JFormattedTextField ftxtFechaInicial = new JFormattedTextField();
	private final JLabel lblFechaFinal = new JLabel("Fecha Final:");
	private final JFormattedTextField ftxtFechaFinal = new JFormattedTextField();
	private final JCheckBox chboxFechaFinal = new JCheckBox("Establecer Fecha Final");
	private final JLabel lblResponsable = new JLabel("Responsable:");
	private final JComboBox cbResponsable = new JComboBox();
	private final JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
	private final JTextArea txtDescripcion = new JTextArea();
	private final JLabel lblMiembros = new JLabel("Miembros");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tableMiembros = new JTable();
	private final JButton btnGuardar = new JButton("");
	
	private final int numIconos = 10;
	private ArrayList<ImageIcon> iconosProyecto;
	
	private final JComboBox cbIconoProyecto = new ComboBox_projectIcon(numIconos);
	/**
	 * Create the panel.
	 */
	public PanelInformacionProyecto() {
		txtNombre.setColumns(10);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{27, 0, 143, 42, 51, 24, 201, 0, 0};
		gridBagLayout.rowHeights = new int[]{44, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);
		
		GridBagConstraints gbc_cbIconoProyecto = new GridBagConstraints();
		gbc_cbIconoProyecto.anchor = GridBagConstraints.SOUTHWEST;
		gbc_cbIconoProyecto.insets = new Insets(0, 0, 5, 5);
		gbc_cbIconoProyecto.gridx = 4;
		gbc_cbIconoProyecto.gridy = 0;
		add(cbIconoProyecto, gbc_cbIconoProyecto);
		
		GridBagConstraints gbc_lblFechaInicio = new GridBagConstraints();
		gbc_lblFechaInicio.anchor = GridBagConstraints.EAST;
		gbc_lblFechaInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaInicio.gridx = 1;
		gbc_lblFechaInicio.gridy = 1;
		add(lblFechaInicio, gbc_lblFechaInicio);
		
		GridBagConstraints gbc_ftxtFechaInicial = new GridBagConstraints();
		gbc_ftxtFechaInicial.gridwidth = 2;
		gbc_ftxtFechaInicial.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFechaInicial.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFechaInicial.gridx = 2;
		gbc_ftxtFechaInicial.gridy = 1;
		add(ftxtFechaInicial, gbc_ftxtFechaInicial);
		
		GridBagConstraints gbc_lblFechaFinal = new GridBagConstraints();
		gbc_lblFechaFinal.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFinal.gridx = 1;
		gbc_lblFechaFinal.gridy = 2;
		lblFechaFinal.setEnabled(false);
		add(lblFechaFinal, gbc_lblFechaFinal);
		
		GridBagConstraints gbc_ftxtFechaFinal = new GridBagConstraints();
		gbc_ftxtFechaFinal.gridwidth = 2;
		gbc_ftxtFechaFinal.anchor = GridBagConstraints.NORTH;
		gbc_ftxtFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFechaFinal.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFechaFinal.gridx = 2;
		gbc_ftxtFechaFinal.gridy = 2;
		ftxtFechaFinal.setEnabled(false);
		add(ftxtFechaFinal, gbc_ftxtFechaFinal);
		
		GridBagConstraints gbc_lblMiembros = new GridBagConstraints();
		gbc_lblMiembros.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiembros.gridx = 6;
		gbc_lblMiembros.gridy = 2;
		add(lblMiembros, gbc_lblMiembros);
		
		GridBagConstraints gbc_chboxFechaFinal = new GridBagConstraints();
		gbc_chboxFechaFinal.anchor = GridBagConstraints.EAST;
		gbc_chboxFechaFinal.gridwidth = 2;
		gbc_chboxFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_chboxFechaFinal.gridx = 2;
		gbc_chboxFechaFinal.gridy = 3;
		add(chboxFechaFinal, gbc_chboxFechaFinal);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		tableMiembros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S/N", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableMiembros.getColumnModel().getColumn(0).setResizable(false);
		tableMiembros.getColumnModel().getColumn(0).setPreferredWidth(29);
		tableMiembros.getColumnModel().getColumn(1).setResizable(false);
		
		scrollPane.setViewportView(tableMiembros);
		
		GridBagConstraints gbc_lblResponsable = new GridBagConstraints();
		gbc_lblResponsable.anchor = GridBagConstraints.EAST;
		gbc_lblResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsable.gridx = 1;
		gbc_lblResponsable.gridy = 4;
		add(lblResponsable, gbc_lblResponsable);
		
		GridBagConstraints gbc_cbResponsable = new GridBagConstraints();
		gbc_cbResponsable.gridwidth = 2;
		gbc_cbResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_cbResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbResponsable.gridx = 2;
		gbc_cbResponsable.gridy = 4;
		add(cbResponsable, gbc_cbResponsable);
		
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 1;
		gbc_lblDescripcin.gridy = 5;
		add(lblDescripcin, gbc_lblDescripcin);
		
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.gridwidth = 4;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 6;
		add(txtDescripcion, gbc_txtDescripcion);
		
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 5;
		gbc_btnGuardar.gridy = 7;
		btnGuardar.setIcon(new ImageIcon(PanelInformacionProyecto.class.getResource("/presentation/Icons/save.png")));
		add(btnGuardar, gbc_btnGuardar);
		
		crearIconos();
		cbIconoProyecto.setRenderer(new ComboBox_projectIcon_render(iconosProyecto));

	}
	
	private void crearIconos() {
		iconosProyecto =  new ArrayList<ImageIcon>();
		for(int i = 1; i<=numIconos; i++) {
			String pathIcon = "/presentation/Icons/proyecto";
			if(i<=9) pathIcon+="0"+i; else pathIcon+=i;
			pathIcon+=".png";
			System.out.println(pathIcon);
			iconosProyecto.add(new ImageIcon(getClass().getResource(pathIcon)));
		}
	}

}
