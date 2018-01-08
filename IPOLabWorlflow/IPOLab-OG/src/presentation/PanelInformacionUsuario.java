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
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import dominio.Proyecto;
import dominio.Usuario;
import persistencia.Storage;
import presentation.renders.ListaProjectosRender;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInformacionUsuario extends JPanel {
	private final JLabel lblNombre = new JLabel("Nombre:");
	private final JLabel lblRol = new JLabel("Rol:");
	private final JLabel lblConocimientos = new JLabel("Conocimientos:");
	private final JLabel lblContacto = new JLabel("Contacto:");
	private final JLabel lblProyectos = new JLabel("Proyectos:");
	private final JTextField txtNombre = new JTextField();
	private final JTextField txtRol = new JTextField();
	private final JTextField txtConocimientos = new JTextField();
	private final JTextField txtContacto = new JTextField();
	private final JLabel lblFoto = new JLabel("");
	private final JList listTareas = new JList();
	private final JScrollPane scrollPaneTareasUsuario = new JScrollPane();
	private final JLabel lblDni = new JLabel("DNI:");
	private JFormattedTextField ftxtDNI = null;
	private final JButton btnGuardar = new JButton("");

	private ProjectOS proOS;
	private PanelInformacionProyecto pinfPro;

	/**
	 * Create the panel.
	 */
	public PanelInformacionUsuario() {
		txtContacto.setColumns(10);
		txtRol.setColumns(10);
		txtNombre.setColumns(10);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 144, 0, 80, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
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
		gbc_lblFoto.gridheight = 5;
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridx = 4;
		gbc_lblFoto.gridy = 1;
		lblFoto.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblFoto.setIcon(
				new ImageIcon(PanelInformacionUsuario.class.getResource("/presentation/Icons/user-silhouette.png")));
		add(lblFoto, gbc_lblFoto);

		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 2;
		add(lblDni, gbc_lblDni);

		GridBagConstraints gbc_ftxtDNI = new GridBagConstraints();
		gbc_ftxtDNI.anchor = GridBagConstraints.NORTH;
		gbc_ftxtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtDNI.gridx = 2;
		gbc_ftxtDNI.gridy = 2;
		try {
			MaskFormatter formatoDNI = new MaskFormatter("########U");
			formatoDNI.setPlaceholderCharacter('#');
			ftxtDNI = new JFormattedTextField(formatoDNI);
			add(ftxtDNI, gbc_ftxtDNI);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.anchor = GridBagConstraints.EAST;
		gbc_lblRol.insets = new Insets(0, 0, 5, 5);
		gbc_lblRol.gridx = 1;
		gbc_lblRol.gridy = 3;
		add(lblRol, gbc_lblRol);

		GridBagConstraints gbc_txtRol = new GridBagConstraints();
		gbc_txtRol.insets = new Insets(0, 0, 5, 5);
		gbc_txtRol.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRol.gridx = 2;
		gbc_txtRol.gridy = 3;
		add(txtRol, gbc_txtRol);

		GridBagConstraints gbc_lblConocimientos = new GridBagConstraints();
		gbc_lblConocimientos.anchor = GridBagConstraints.EAST;
		gbc_lblConocimientos.insets = new Insets(0, 0, 5, 5);
		gbc_lblConocimientos.gridx = 1;
		gbc_lblConocimientos.gridy = 4;
		add(lblConocimientos, gbc_lblConocimientos);
		txtConocimientos.setColumns(10);

		GridBagConstraints gbc_txtConocimientos = new GridBagConstraints();
		gbc_txtConocimientos.insets = new Insets(0, 0, 5, 5);
		gbc_txtConocimientos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConocimientos.gridx = 2;
		gbc_txtConocimientos.gridy = 4;
		add(txtConocimientos, gbc_txtConocimientos);

		GridBagConstraints gbc_lblContacto = new GridBagConstraints();
		gbc_lblContacto.anchor = GridBagConstraints.EAST;
		gbc_lblContacto.insets = new Insets(0, 0, 5, 5);
		gbc_lblContacto.gridx = 1;
		gbc_lblContacto.gridy = 5;
		add(lblContacto, gbc_lblContacto);

		GridBagConstraints gbc_txtContacto = new GridBagConstraints();
		gbc_txtContacto.insets = new Insets(0, 0, 5, 5);
		gbc_txtContacto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContacto.gridx = 2;
		gbc_txtContacto.gridy = 5;
		add(txtContacto, gbc_txtContacto);

		GridBagConstraints gbc_lblProyectos = new GridBagConstraints();
		gbc_lblProyectos.anchor = GridBagConstraints.EAST;
		gbc_lblProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProyectos.gridx = 1;
		gbc_lblProyectos.gridy = 6;
		add(lblProyectos, gbc_lblProyectos);

		GridBagConstraints gbc_scrollPaneTareasUsuario = new GridBagConstraints();
		gbc_scrollPaneTareasUsuario.gridwidth = 4;
		gbc_scrollPaneTareasUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneTareasUsuario.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTareasUsuario.gridx = 1;
		gbc_scrollPaneTareasUsuario.gridy = 7;
		add(scrollPaneTareasUsuario, gbc_scrollPaneTareasUsuario);
		scrollPaneTareasUsuario.setViewportView(listTareas);

		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.NORTH;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 4;
		gbc_btnGuardar.gridy = 8;
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		btnGuardar.setIcon(new ImageIcon(PanelInformacionUsuario.class.getResource("/presentation/Icons/save.png")));
		add(btnGuardar, gbc_btnGuardar);

	}

	public void setProos(ProjectOS proOS) {
		this.proOS = proOS;
	}

	public void setpinfPro(PanelInformacionProyecto p) {
		this.pinfPro = p;
	}

	public void clearFields() {
		txtConocimientos.setText("");
		txtContacto.setText("");
		txtNombre.setText("");
		txtRol.setText("");
		ftxtDNI.setText("");
	}

	public void setInformacionUsuario(Usuario u) {
		txtNombre.setText(u.getNombre());
		txtConocimientos.setText(u.getConocimientos());
		txtContacto.setText(u.getContacto());
		txtRol.setText(u.getRol());
		ftxtDNI.setText(u.getDNI());
		loadProyectos(u);
	}

	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				int index = proOS.getListUsuarios().getSelectedIndex();
				Usuario u = Storage.getInstance().getListaUsuarios().get(index);
				u.setConocimientos(txtConocimientos.getText());
				u.setContacto(txtContacto.getText());
				u.setDNI(ftxtDNI.getText());
				u.setNombre(txtNombre.getText());
				u.setRol(txtRol.getText());
				pinfPro.reloadMiembros();
				pinfPro.setComboResponsable();
				proOS.loadUsuarios();
			} catch (Exception ex) {
			}
			}
	}

	public void loadProyectos(Usuario u) {
		Storage st = Storage.getInstance();
		Iterator<Proyecto> it = st.getListaProyectos().iterator();
		// Iterator<Usuario> it1 = st.getListaUsuarios().iterator();
		DefaultListModel<Proyecto> modeloProyectos = new DefaultListModel<Proyecto>();
		while (it.hasNext()) {
			Proyecto proyectoLeido = it.next();
			ArrayList<Usuario> usuarios = proyectoLeido.getMiembros();
			if (usuarios.contains(u)) {
				modeloProyectos.addElement(proyectoLeido);
			}
		}
		listTareas.setModel(modeloProyectos);
		listTareas.setCellRenderer(new ListaProjectosRender());
	}
}
