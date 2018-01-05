package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import dominio.Proyecto;
import dominio.Usuario;
import persistencia.Storage;
import presentation.renders.ListaProjectosRender;
import presentation.renders.ComboResponsablesRender;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProjectOS extends JFrame {

	private static JFrame frmProyectos;
	private final JTabbedPane pnlTabMain = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel pnlUser = new JPanel();
	private final JPanel pnlAjustes = new JPanel();
	private final JPanel pnlProjects = new JPanel();
	private final JPanel pnlUsers = new JPanel();
	private final JLabel lblProyectos = new JLabel("Proyectos:");
	private final JLabel lblAddProjectIcon = new JLabel("");
	private final JLabel lblRemoveProjectIcon = new JLabel("");
	private final JScrollPane scrollPaneProjects = new JScrollPane();
	private final JList listProjects = new JList();
	private final JTabbedPane pnlTabSmall = new JTabbedPane(JTabbedPane.TOP);
	private PanelInformacionProyecto pnlInformacionProjectos = new PanelInformacionProyecto();;
	private final JPanel pnlTareas = new PanelTareas();
	private final JLabel lblAyuda = new JLabel("");
	private final JLabel lblAjustes = new JLabel("");
	private final JLabel lblLogo = new JLabel("");
	private final JLabel lblUsuario = new JLabel("");
	private final JLabel lblNombreUsuarioLogin = new JLabel("Alvario Noli");
	private final JLabel lblUsuarios = new JLabel("Usuarios:");
	private final JLabel lblAddUser = new JLabel("");
	private final JLabel lblRemoveUser = new JLabel("");
	private final PanelInformacionUsuario pnlInformacionUsuarios = new PanelInformacionUsuario();
	private final JPanel pnlChat = new PanelChat(lblNombreUsuarioLogin.getText());
	private final JScrollPane scrollPaneUsers = new JScrollPane();
	private final JList listUsuarios = new JList();
	private final JLabel lblltimaConexin = new JLabel("\u00DAltima conexi\u00F3n:");
	private final JLabel lblHora = new JLabel("hora");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectOS window = new ProjectOS();
					frmProyectos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjectOS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProyectos = new JFrame();
		frmProyectos.setIconImage(
				Toolkit.getDefaultToolkit().getImage(ProjectOS.class.getResource("/presentation/Icons/icon.png")));
		frmProyectos.setTitle("ProyectOS");
		frmProyectos.setBounds(100, 100, 1125, 753);
		frmProyectos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyectos.getContentPane().setLayout(new BorderLayout(0, 0));

		frmProyectos.getContentPane().add(pnlTabMain, BorderLayout.CENTER);

		pnlTabMain.addTab("Proyectos",
				new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/business-presentation.png")),
				pnlProjects, null);
		GridBagLayout gbl_pnlProjects = new GridBagLayout();
		gbl_pnlProjects.columnWidths = new int[] { 10, 0, 175, 0, 0, 0, 0, 0 };
		gbl_pnlProjects.rowHeights = new int[] { 8, 0, 0, 5, 0 };
		gbl_pnlProjects.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnlProjects.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		pnlProjects.setLayout(gbl_pnlProjects);

		GridBagConstraints gbc_lblProyectos = new GridBagConstraints();
		gbc_lblProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProyectos.gridx = 1;
		gbc_lblProyectos.gridy = 1;
		pnlProjects.add(lblProyectos, gbc_lblProyectos);

		GridBagConstraints gbc_lblAddProjectIcon = new GridBagConstraints();
		gbc_lblAddProjectIcon.anchor = GridBagConstraints.EAST;
		gbc_lblAddProjectIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddProjectIcon.gridx = 2;
		gbc_lblAddProjectIcon.gridy = 1;
		lblAddProjectIcon.addMouseListener(new LblAddProjectIconMouseListener());
		lblAddProjectIcon.addMouseListener(new IconMouseListener(lblAddProjectIcon));
		lblAddProjectIcon.setIcon(new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/addition-sign.png")));
		pnlProjects.add(lblAddProjectIcon, gbc_lblAddProjectIcon);

		GridBagConstraints gbc_lblRemoveProjectIcon = new GridBagConstraints();
		gbc_lblRemoveProjectIcon.anchor = GridBagConstraints.WEST;
		gbc_lblRemoveProjectIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemoveProjectIcon.gridx = 3;
		gbc_lblRemoveProjectIcon.gridy = 1;
		lblRemoveProjectIcon.addMouseListener(new IconMouseListener(lblRemoveProjectIcon));
		lblRemoveProjectIcon.addMouseListener(new LblRemoveProjectIconMouseListener());
		lblRemoveProjectIcon.setIcon(new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/trash-can.png")));
		pnlProjects.add(lblRemoveProjectIcon, gbc_lblRemoveProjectIcon);

		GridBagConstraints gbc_scrollPaneProjects = new GridBagConstraints();
		gbc_scrollPaneProjects.gridwidth = 3;
		gbc_scrollPaneProjects.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneProjects.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneProjects.gridx = 1;
		gbc_scrollPaneProjects.gridy = 2;
		pnlProjects.add(scrollPaneProjects, gbc_scrollPaneProjects);
		listProjects.addListSelectionListener(new ListProjectsListSelectionListener());

		scrollPaneProjects.setViewportView(listProjects);

		GridBagConstraints gbc_pnlTabSmall = new GridBagConstraints();
		gbc_pnlTabSmall.insets = new Insets(0, 0, 5, 5);
		gbc_pnlTabSmall.fill = GridBagConstraints.BOTH;
		gbc_pnlTabSmall.gridx = 5;
		gbc_pnlTabSmall.gridy = 2;
		pnlProjects.add(pnlTabSmall, gbc_pnlTabSmall);

		pnlTabSmall.addTab("Informaci\u00F3n", null, pnlInformacionProjectos, null);

		pnlTabSmall.addTab("Tareas", null, pnlTareas, null);

		pnlTabMain.addTab("Usuarios",
				new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/multiple-users-silhouette.png")),
				pnlUsers, null);
		GridBagLayout gbl_pnlUsers = new GridBagLayout();
		gbl_pnlUsers.columnWidths = new int[] { 10, 0, 144, 0, 2, 236, 0, 244, 0, 0 };
		gbl_pnlUsers.rowHeights = new int[] { 36, 0, 0, 0 };
		gbl_pnlUsers.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnlUsers.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		pnlUsers.setLayout(gbl_pnlUsers);

		GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
		gbc_lblUsuarios.anchor = GridBagConstraints.SOUTH;
		gbc_lblUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuarios.gridx = 1;
		gbc_lblUsuarios.gridy = 0;
		pnlUsers.add(lblUsuarios, gbc_lblUsuarios);

		GridBagConstraints gbc_lblAddUser = new GridBagConstraints();
		gbc_lblAddUser.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblAddUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddUser.gridx = 2;
		gbc_lblAddUser.gridy = 0;
		lblAddUser.setIcon(new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/addition-sign.png")));
		lblAddUser.addMouseListener(new IconMouseListener(lblAddUser));
		pnlUsers.add(lblAddUser, gbc_lblAddUser);

		GridBagConstraints gbc_lblRemoveUser = new GridBagConstraints();
		gbc_lblRemoveUser.anchor = GridBagConstraints.SOUTH;
		gbc_lblRemoveUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemoveUser.gridx = 3;
		gbc_lblRemoveUser.gridy = 0;
		lblRemoveUser.setIcon(new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/trash-can.png")));
		lblRemoveUser.addMouseListener(new IconMouseListener(lblRemoveUser));
		pnlUsers.add(lblRemoveUser, gbc_lblRemoveUser);

		GridBagConstraints gbc_scrollPaneUsers = new GridBagConstraints();
		gbc_scrollPaneUsers.gridwidth = 3;
		gbc_scrollPaneUsers.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneUsers.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneUsers.gridx = 1;
		gbc_scrollPaneUsers.gridy = 1;
		pnlUsers.add(scrollPaneUsers, gbc_scrollPaneUsers);
		listUsuarios.addListSelectionListener(new ListUsuariosListSelectionListener());

		scrollPaneUsers.setViewportView(listUsuarios);

		GridBagConstraints gbc_pnlInformacionUsuarios = new GridBagConstraints();
		gbc_pnlInformacionUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_pnlInformacionUsuarios.fill = GridBagConstraints.BOTH;
		gbc_pnlInformacionUsuarios.gridx = 5;
		gbc_pnlInformacionUsuarios.gridy = 1;
		pnlUsers.add(pnlInformacionUsuarios, gbc_pnlInformacionUsuarios);

		GridBagConstraints gbc_pnlChat = new GridBagConstraints();
		gbc_pnlChat.insets = new Insets(0, 0, 5, 5);
		gbc_pnlChat.fill = GridBagConstraints.BOTH;
		gbc_pnlChat.gridx = 7;
		gbc_pnlChat.gridy = 1;
		pnlChat.setBorder(
				new TitledBorder(null, "Mensajes con ...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlUsers.add(pnlChat, gbc_pnlChat);

		frmProyectos.getContentPane().add(pnlUser, BorderLayout.NORTH);
		GridBagLayout gbl_pnlUser = new GridBagLayout();
		gbl_pnlUser.columnWidths = new int[] { 0, 0, 31, 0 };
		gbl_pnlUser.rowHeights = new int[] { 23, 0, 0 };
		gbl_pnlUser.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlUser.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pnlUser.setLayout(gbl_pnlUser);

		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 0;
		pnlUser.add(lblNombreUsuarioLogin, gbc_lblNombre);

		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsuario.gridx = 2;
		gbc_lblUsuario.gridy = 0;
		lblUsuario.setIcon(new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/user.png")));
		pnlUser.add(lblUsuario, gbc_lblUsuario);

		GridBagConstraints gbc_lblltimaConexin = new GridBagConstraints();
		gbc_lblltimaConexin.anchor = GridBagConstraints.EAST;
		gbc_lblltimaConexin.insets = new Insets(0, 0, 0, 5);
		gbc_lblltimaConexin.gridx = 0;
		gbc_lblltimaConexin.gridy = 1;
		pnlUser.add(lblltimaConexin, gbc_lblltimaConexin);

		GridBagConstraints gbc_lblHora = new GridBagConstraints();
		gbc_lblHora.gridwidth = 2;
		gbc_lblHora.anchor = GridBagConstraints.WEST;
		gbc_lblHora.gridx = 1;
		gbc_lblHora.gridy = 1;
		pnlUser.add(lblHora, gbc_lblHora);
		setHora();

		frmProyectos.getContentPane().add(pnlAjustes, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlAjustes = new GridBagLayout();
		gbl_pnlAjustes.columnWidths = new int[] { 57, 0, 0, 96, 0 };
		gbl_pnlAjustes.rowHeights = new int[] { 0, 0 };
		gbl_pnlAjustes.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnlAjustes.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pnlAjustes.setLayout(gbl_pnlAjustes);

		GridBagConstraints gbc_lblAyuda = new GridBagConstraints();
		gbc_lblAyuda.anchor = GridBagConstraints.EAST;
		gbc_lblAyuda.insets = new Insets(0, 0, 0, 5);
		gbc_lblAyuda.gridx = 0;
		gbc_lblAyuda.gridy = 0;
		lblAyuda.setIcon(new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/question (2).png")));
		lblAyuda.addMouseListener(new IconMouseListener(lblAyuda));
		pnlAjustes.add(lblAyuda, gbc_lblAyuda);

		GridBagConstraints gbc_lblAjustes = new GridBagConstraints();
		gbc_lblAjustes.anchor = GridBagConstraints.WEST;
		gbc_lblAjustes.insets = new Insets(0, 0, 0, 5);
		gbc_lblAjustes.gridx = 1;
		gbc_lblAjustes.gridy = 0;
		lblAjustes.setIcon(new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/gear (1).png")));
		lblAjustes.addMouseListener(new IconMouseListener(lblAjustes));
		pnlAjustes.add(lblAjustes, gbc_lblAjustes);

		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.anchor = GridBagConstraints.WEST;
		gbc_lblLogo.gridx = 3;
		gbc_lblLogo.gridy = 0;
		lblLogo.setIcon(new ImageIcon(ProjectOS.class.getResource("/presentation/Icons/logox32.png")));
		pnlAjustes.add(lblLogo, gbc_lblLogo);
		pnlInformacionProjectos.setProOS(this);
		///////////// Metodos de carga //////////////
		loadProyectos();
		loadUsuarios();
		////////////////////////////////////////////
		frmProyectos.setVisible(true);
	}

	public void setHora() {
		Random rd = new Random(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		int hora = (cal.get(Calendar.HOUR_OF_DAY));
		int minutos = cal.get(Calendar.MINUTE);
		hora = Math.abs((hora - rd.nextInt()) % 24);
		minutos = Math.abs((minutos - rd.nextInt()) % 60);
		String hoyayer = (cal.get(Calendar.HOUR_OF_DAY) <= hora && cal.get(Calendar.MINUTE) < minutos) ? "Ayer" : "Hoy";
		lblHora.setText(
				hoyayer + " a las " + ((hora < 10) ? "0" : "") + hora + ":" + ((minutos < 10) ? "0" : "") + minutos);
	}

	public String getUsuarioLogin() {
		return lblNombreUsuarioLogin.getText();
	}

	@SuppressWarnings("unchecked")
	public void loadProyectos() {
		Storage st = Storage.getInstance();
		Iterator<Proyecto> it = st.getListaProyectos().iterator();
		DefaultListModel<Proyecto> modeloProyectos = new DefaultListModel<Proyecto>();
		while (it.hasNext()) {
			Proyecto proyectoLeido = it.next();
			modeloProyectos.addElement(proyectoLeido);
		}
		listProjects.setModel(modeloProyectos);
		listProjects.setCellRenderer(new ListaProjectosRender());
	}

	@SuppressWarnings("unchecked")
	private void loadUsuarios() {
			Storage st = Storage.getInstance();
			Iterator<Usuario> it = st.getListaUsuarios().iterator();
			DefaultListModel<String> modeloUsuarios = new DefaultListModel<String>();
			ArrayList<String> listaResponsables = new ArrayList<String>();
			while (it.hasNext()) {
				Usuario usuarioLeido = it.next();
				modeloUsuarios.addElement(usuarioLeido.getDNI());
				listaResponsables.add(usuarioLeido.getNombre());
			}
			listUsuarios.setModel(modeloUsuarios);
			// ComboResponsablesRender render = new
			// ComboResponsablesRender(listaResponsables);
			//////////////// COMENTARIO RENDER /////////////////////////
			// pnlInformacionProjectos.getCbResponsable().setRenderer(render);
			////////////////////////////////////////////////////////////
	}
	
	public JList getlistProjects() {
		return listProjects;
	}

	private class ListProjectsListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			Storage st = Storage.getInstance();
			Iterator<Proyecto> itp = st.getListaProyectos().iterator();
			Proyecto p = null;
			while(itp.hasNext()) {
				p = itp.next();
				if(listProjects.getSelectedValue().toString().equals(p.getNombre())) 
					break;
			}
			pnlInformacionProjectos.setInformacionProyecto(p);
		}
	}

	private class ListUsuariosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			Storage st = Storage.getInstance();
			Iterator<Usuario> itu = st.getListaUsuarios().iterator();
			Usuario u = null;
			while(itu.hasNext()) {
				u = itu.next();
				if(listUsuarios.getSelectedValue().toString().equals(u.getDNI()))
					break;
			}
			pnlInformacionUsuarios.setInformacionUsuario(u);
		}
	}

	// Código para añadir un nuevo proyecto
	private class LblAddProjectIconMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			Proyecto p = new Proyecto();
			p.setNombre("Proyecto"+listProjects.getModel().getSize());
			p.setIcono("/presentation/Icons/proyecto01.png");
			pnlInformacionProjectos.setInformacionProyecto(p);
			Storage.getInstance().getListaProyectos().add(p);
			try {
				loadProyectos();
			}catch(Exception e) {
			}
		}
	}
	
	private class LblRemoveProjectIconMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {
				Storage.getInstance().getListaProyectos().remove(listProjects.getSelectedIndex());
				pnlInformacionProjectos.clearFields();
				loadProyectos();
			}catch(Exception e) {
			}
		}
	}
	
	

}
