package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;

public class PanelInformacionTarea extends JPanel {
	private final JLabel lblNombre = new JLabel("Nombre:");
	private final JTextField txtNombre = new JTextField();
	private final JLabel lblFechaIn = new JLabel("Feha Inicial:");
	private final JLabel lblFechaFinal = new JLabel("Fecha Final:");
	private final JLabel lblPrioridad = new JLabel("Prioridad:");
	private final JSlider sliderPrioridad = new JSlider();
	private final JLabel lblResponsable = new JLabel("Responsable:");
	private final JComboBox comboBoxResponsable = new JComboBox();
	private final JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
	private final JTextArea txtAreaDescripcion = new JTextArea();
	private final JLabel lblMiembros = new JLabel("Miembros:");
	private final JScrollPane scrollPaneMiembtos = new JScrollPane();
	private final JTable tableMiembros = new JTable();
	private final JButton btnAadirSubtarea = new JButton("A\u00F1adir Subtarea");
	private final JButton btnGuardar = new JButton("");
	private final JFormattedTextField ftxtFechaFinal = new JFormattedTextField();
	private final JFormattedTextField ftxtFechaInicial = new JFormattedTextField();
	private final JLabel lblEditorImagen = new JLabel("Editor Imagen:");
	private final JScrollPane scrollPaneImagen = new JScrollPane();
	private final JPanel pnlImagen = new JPanel();
	private final JLabel lblAddImagen = new JLabel("");
	private final JLabel lblEditImagen = new JLabel("");

	/**
	 * Create the panel.
	 */
	public PanelInformacionTarea() {
		txtNombre.setColumns(10);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 66, 116, 0, 0, 0, 0, 24, 0, 0};
		gridBagLayout.rowHeights = new int[]{41, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);
		
		GridBagConstraints gbc_lblMiembros = new GridBagConstraints();
		gbc_lblMiembros.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiembros.gridx = 5;
		gbc_lblMiembros.gridy = 0;
		add(lblMiembros, gbc_lblMiembros);
		
		GridBagConstraints gbc_lblFechaIn = new GridBagConstraints();
		gbc_lblFechaIn.anchor = GridBagConstraints.EAST;
		gbc_lblFechaIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaIn.gridx = 1;
		gbc_lblFechaIn.gridy = 1;
		add(lblFechaIn, gbc_lblFechaIn);
		
		GridBagConstraints gbc_ftxtFechaInicial = new GridBagConstraints();
		gbc_ftxtFechaInicial.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFechaInicial.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFechaInicial.gridx = 2;
		gbc_ftxtFechaInicial.gridy = 1;
		add(ftxtFechaInicial, gbc_ftxtFechaInicial);
		
		GridBagConstraints gbc_scrollPaneMiembtos = new GridBagConstraints();
		gbc_scrollPaneMiembtos.gridheight = 4;
		gbc_scrollPaneMiembtos.gridwidth = 3;
		gbc_scrollPaneMiembtos.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneMiembtos.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneMiembtos.gridx = 5;
		gbc_scrollPaneMiembtos.gridy = 1;
		add(scrollPaneMiembtos, gbc_scrollPaneMiembtos);
		
		scrollPaneMiembtos.setViewportView(tableMiembros);
		
		GridBagConstraints gbc_lblFechaFinal = new GridBagConstraints();
		gbc_lblFechaFinal.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFinal.gridx = 1;
		gbc_lblFechaFinal.gridy = 2;
		add(lblFechaFinal, gbc_lblFechaFinal);
		
		GridBagConstraints gbc_ftxtFechaFinal = new GridBagConstraints();
		gbc_ftxtFechaFinal.anchor = GridBagConstraints.NORTH;
		gbc_ftxtFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFechaFinal.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFechaFinal.gridx = 2;
		gbc_ftxtFechaFinal.gridy = 2;
		add(ftxtFechaFinal, gbc_ftxtFechaFinal);
		
		GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
		gbc_lblPrioridad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrioridad.gridx = 1;
		gbc_lblPrioridad.gridy = 3;
		add(lblPrioridad, gbc_lblPrioridad);
		
		GridBagConstraints gbc_sliderPrioridad = new GridBagConstraints();
		gbc_sliderPrioridad.insets = new Insets(0, 0, 5, 5);
		gbc_sliderPrioridad.gridx = 2;
		gbc_sliderPrioridad.gridy = 3;
		add(sliderPrioridad, gbc_sliderPrioridad);
		
		GridBagConstraints gbc_lblResponsable = new GridBagConstraints();
		gbc_lblResponsable.anchor = GridBagConstraints.EAST;
		gbc_lblResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsable.gridx = 1;
		gbc_lblResponsable.gridy = 4;
		add(lblResponsable, gbc_lblResponsable);
		
		GridBagConstraints gbc_comboBoxResponsable = new GridBagConstraints();
		gbc_comboBoxResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxResponsable.gridx = 2;
		gbc_comboBoxResponsable.gridy = 4;
		add(comboBoxResponsable, gbc_comboBoxResponsable);
		
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 5;
		add(lblDescripcion, gbc_lblDescripcion);
		
		GridBagConstraints gbc_lblEditorImagen = new GridBagConstraints();
		gbc_lblEditorImagen.anchor = GridBagConstraints.WEST;
		gbc_lblEditorImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditorImagen.gridx = 5;
		gbc_lblEditorImagen.gridy = 5;
		add(lblEditorImagen, gbc_lblEditorImagen);
		
		GridBagConstraints gbc_lblAddImagen = new GridBagConstraints();
		gbc_lblAddImagen.anchor = GridBagConstraints.EAST;
		gbc_lblAddImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddImagen.gridx = 6;
		gbc_lblAddImagen.gridy = 5;
		lblAddImagen.setIcon(new ImageIcon(PanelInformacionTarea.class.getResource("/presentation/Icons/addition-sign.png")));
		add(lblAddImagen, gbc_lblAddImagen);
		
		GridBagConstraints gbc_lblEditImagen = new GridBagConstraints();
		gbc_lblEditImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditImagen.gridx = 7;
		gbc_lblEditImagen.gridy = 5;
		lblEditImagen.setIcon(new ImageIcon(PanelInformacionTarea.class.getResource("/presentation/Icons/pencil-edit-button.png")));
		add(lblEditImagen, gbc_lblEditImagen);
		
		GridBagConstraints gbc_txtAreaDescripcion = new GridBagConstraints();
		gbc_txtAreaDescripcion.gridwidth = 3;
		gbc_txtAreaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtAreaDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtAreaDescripcion.gridx = 1;
		gbc_txtAreaDescripcion.gridy = 6;
		add(txtAreaDescripcion, gbc_txtAreaDescripcion);
		
		GridBagConstraints gbc_scrollPaneImagen = new GridBagConstraints();
		gbc_scrollPaneImagen.gridwidth = 3;
		gbc_scrollPaneImagen.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneImagen.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneImagen.gridx = 5;
		gbc_scrollPaneImagen.gridy = 6;
		add(scrollPaneImagen, gbc_scrollPaneImagen);
		
		scrollPaneImagen.setViewportView(pnlImagen);
		
		GridBagConstraints gbc_btnAadirSubtarea = new GridBagConstraints();
		gbc_btnAadirSubtarea.insets = new Insets(0, 0, 0, 5);
		gbc_btnAadirSubtarea.gridx = 5;
		gbc_btnAadirSubtarea.gridy = 7;
		btnAadirSubtarea.setIcon(new ImageIcon(PanelInformacionTarea.class.getResource("/presentation/Icons/task-complete.png")));
		add(btnAadirSubtarea, gbc_btnAadirSubtarea);
		
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 7;
		btnGuardar.setIcon(new ImageIcon(PanelInformacionTarea.class.getResource("/presentation/Icons/save.png")));
		add(btnGuardar, gbc_btnGuardar);

	}

}
