package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dominio.Proyecto;
import dominio.Usuario;
import persistencia.Storage;
import presentation.renders.ComboBox_projectIcon;
import presentation.renders.ComboBox_projectIcon_render;

import javax.swing.JButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PanelInformacionProyecto extends JPanel {
	private final JLabel lblNombre = new JLabel("Nombre:");
	private final JTextField txtNombre = new JTextField();
	private final JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
	private JFormattedTextField ftxtFechaInicial;
	private final JLabel lblFechaFinal = new JLabel("Fecha Final:");
	private JFormattedTextField ftxtFechaFinal;
	private final JLabel lblResponsable = new JLabel("Responsable:");
	private final JLabel lblDescripcin = new JLabel("Descripción");
	private final JTextArea txtDescripcion = new JTextArea();
	private final JLabel lblMiembros = new JLabel("Miembros");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tableMiembros = new JTable();
	private final JButton btnGuardar = new JButton("");

	private final int numIconos = 10;
	private ArrayList<ImageIcon> iconosProyecto;

	private final JComboBox cbIconoProyecto = new ComboBox_projectIcon(numIconos);
	private final JComboBox<String> cbResponsable = new JComboBox<String>();

	// referencia a la ventana principal
	private ProjectOS proOS;
	private final JRadioButton rdbtnPendiente = new JRadioButton("Pendiente");
	private final JRadioButton rdbtnEnRealizacin = new JRadioButton("En realizaci\u00F3n");
	private final JRadioButton rdbtnCompletado = new JRadioButton("Completado");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblEstado = new JLabel("Estado:");

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public PanelInformacionProyecto() {

		txtNombre.setColumns(10);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 27, 0, 81, 42, 30, 24, 201, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 44, 0, 0, 0, 23, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
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
		ftxtFechaInicial = null;
		try {
			MaskFormatter formatoFecha = new MaskFormatter("##/##/####");
			formatoFecha.setPlaceholderCharacter('#');
			ftxtFechaInicial = new JFormattedTextField(formatoFecha);
			add(ftxtFechaInicial, gbc_ftxtFechaInicial);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GridBagConstraints gbc_lblFechaFinal = new GridBagConstraints();
		gbc_lblFechaFinal.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFinal.gridx = 1;
		gbc_lblFechaFinal.gridy = 2;
		add(lblFechaFinal, gbc_lblFechaFinal);

		GridBagConstraints gbc_ftxtFechaFinal = new GridBagConstraints();
		gbc_ftxtFechaFinal.gridwidth = 2;
		gbc_ftxtFechaFinal.anchor = GridBagConstraints.NORTH;
		gbc_ftxtFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFechaFinal.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFechaFinal.gridx = 2;
		gbc_ftxtFechaFinal.gridy = 2;
		ftxtFechaFinal = null;
		try {
			MaskFormatter formatoFecha = new MaskFormatter("##/##/####");
			formatoFecha.setPlaceholderCharacter('#');
			ftxtFechaFinal = new JFormattedTextField(formatoFecha);
			add(ftxtFechaFinal, gbc_ftxtFechaFinal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GridBagConstraints gbc_lblMiembros = new GridBagConstraints();
		gbc_lblMiembros.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiembros.gridx = 6;
		gbc_lblMiembros.gridy = 2;
		add(lblMiembros, gbc_lblMiembros);

		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 3;
		add(lblEstado, gbc_lblEstado);

		GridBagConstraints gbc_rdbtnPendiente = new GridBagConstraints();
		gbc_rdbtnPendiente.anchor = GridBagConstraints.WEST;
		gbc_rdbtnPendiente.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPendiente.gridx = 2;
		gbc_rdbtnPendiente.gridy = 3;
		buttonGroup.add(rdbtnPendiente);
		add(rdbtnPendiente, gbc_rdbtnPendiente);

		GridBagConstraints gbc_rdbtnEnRealizacin = new GridBagConstraints();
		gbc_rdbtnEnRealizacin.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEnRealizacin.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEnRealizacin.gridx = 3;
		gbc_rdbtnEnRealizacin.gridy = 3;
		buttonGroup.add(rdbtnEnRealizacin);
		add(rdbtnEnRealizacin, gbc_rdbtnEnRealizacin);

		GridBagConstraints gbc_rdbtnCompletado = new GridBagConstraints();
		gbc_rdbtnCompletado.gridwidth = 2;
		gbc_rdbtnCompletado.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCompletado.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCompletado.gridx = 4;
		gbc_rdbtnCompletado.gridy = 3;
		buttonGroup.add(rdbtnCompletado);
		add(rdbtnCompletado, gbc_rdbtnCompletado);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		tableMiembros.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "S/N", "Nombre" }) {
			Class[] columnTypes = new Class[] { Boolean.class, String.class };

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
		gbc_lblResponsable.gridy = 5;
		add(lblResponsable, gbc_lblResponsable);

		GridBagConstraints gbc_cbResponsable = new GridBagConstraints();
		gbc_cbResponsable.gridwidth = 2;
		gbc_cbResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_cbResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbResponsable.gridx = 2;
		gbc_cbResponsable.gridy = 5;
		cbResponsable.setModel(new DefaultComboBoxModel(new String[] { "Adri\u00E1n", "Enrique" }));
		add(cbResponsable, gbc_cbResponsable);

		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 1;
		gbc_lblDescripcin.gridy = 6;
		add(lblDescripcin, gbc_lblDescripcin);

		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.gridwidth = 5;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 7;
		txtDescripcion.setLineWrap(true);
		add(txtDescripcion, gbc_txtDescripcion);

		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 5;
		gbc_btnGuardar.gridy = 8;
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		btnGuardar.setIcon(new ImageIcon(PanelInformacionProyecto.class.getResource("/presentation/Icons/save.png")));
		add(btnGuardar, gbc_btnGuardar);

		crearIconos();
		//////////////////// COMENTARIO DEL RENDER //////////////////////
		// cbIconoProyecto.setRenderer(new ComboBox_projectIcon_render(iconosProyecto));

	}

	public void setProOS(ProjectOS proOS) {
		this.proOS = proOS;
	}

	private void crearIconos() {
		iconosProyecto = new ArrayList<ImageIcon>();
		for (int i = 1; i <= numIconos; i++) {
			String pathIcon = "/presentation/Icons/proyecto";
			if (i <= 9)
				pathIcon += "0" + i;
			else
				pathIcon += i;
			pathIcon += ".png";
			iconosProyecto.add(new ImageIcon(getClass().getResource(pathIcon)));
		}
	}

	public void setInformacionProyecto(Proyecto p) {
		txtNombre.setText(p.getNombre());
		ftxtFechaInicial.setText(p.getFechaInicio());
		ftxtFechaFinal.setText(p.getFechaFinal());
		// cbIconoProyecto.setSelectedIndex(proOS.getlistProjects());
		cbResponsable.setSelectedIndex(Storage.getInstance().getListaUsuarios().indexOf(p.getResponsable()));
		txtDescripcion.setText(p.getDescripcion());
		if (p.getEstado() == 0)
			rdbtnPendiente.setSelected(true);
		if (p.getEstado() == 1)
			rdbtnEnRealizacin.setSelected(true);
		if (p.getEstado() == 2)
			rdbtnCompletado.setSelected(true);

	}

	public void clearFields() {
		txtNombre.setText("");
		ftxtFechaInicial.setText("");
		ftxtFechaFinal.setText("");
		txtDescripcion.setText("");
	}

	@SuppressWarnings("unchecked")
	public void setComboResponsables(ComboBoxModel<String> modeloUsuarios) {
		cbResponsable.setModel(modeloUsuarios);

	}

	public JComboBox getCbResponsable() {
		return cbResponsable;
	}

	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				int index = proOS.getlistProjects().getSelectedIndex();
				Proyecto p = Storage.getInstance().getListaProyectos().get(index);
				p.setDescripcion(txtDescripcion.getText());
				p.setFechaFinal(ftxtFechaFinal.getText());
				p.setFechaInicio(ftxtFechaInicial.getText());
				String pathIcon = "/presentation/Icons/proyecto";
				// if (cbIconoProyecto.getSelectedIndex() <= 9)
				// pathIcon += "0" + cbIconoProyecto.getSelectedIndex();
				// else
				// pathIcon += cbIconoProyecto.getSelectedIndex();
				// pathIcon += ".png";
				// p.setIcono(pathIcon);
				p.setNombre(txtNombre.getText());
				if (rdbtnPendiente.isSelected())
					p.setEstado(0);
				if (rdbtnEnRealizacin.isSelected())
					p.setEstado(1);
				if (rdbtnCompletado.isSelected())
					p.setEstado(2);
				// p.setResponsable(Storage.);

				proOS.loadProyectos();
			} catch (Exception e) {
			}
		}
	}
}
