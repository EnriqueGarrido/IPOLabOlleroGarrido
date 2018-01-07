package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTree;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import dominio.Proyecto;
import dominio.Subtarea;
import dominio.Tarea;
import persistencia.Storage;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class PanelTareas extends JPanel {
	private final JTree arbolTareas = new JTree();
	private final JLabel lblAddTarea = new JLabel("");
	private final JLabel lblRemoveTarea = new JLabel("");
	private final PanelInformacionTarea pnlInformacionTareas = new PanelInformacionTarea();

	/**
	 * Create the panel.
	 */
	public PanelTareas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 203, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		arbolTareas.addMouseListener(new ArbolTareasMouseListener());
		scrollPane.setViewportView(arbolTareas);
		arbolTareas.addTreeSelectionListener(new ArbolTareasTreeSelectionListener());
		arbolTareas.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Proyecto") {
			{
			}
		}));
		arbolTareas.setCellRenderer(new RenderArbolTareas());

		GridBagConstraints gbc_pnlInformacionTareas = new GridBagConstraints();
		gbc_pnlInformacionTareas.insets = new Insets(0, 0, 5, 0);
		gbc_pnlInformacionTareas.fill = GridBagConstraints.BOTH;
		gbc_pnlInformacionTareas.gridx = 2;
		gbc_pnlInformacionTareas.gridy = 0;
		add(pnlInformacionTareas, gbc_pnlInformacionTareas);

		GridBagConstraints gbc_lblAddTarea = new GridBagConstraints();
		gbc_lblAddTarea.anchor = GridBagConstraints.EAST;
		gbc_lblAddTarea.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddTarea.gridx = 0;
		gbc_lblAddTarea.gridy = 1;
		lblAddTarea.addMouseListener(new LblAddTareaMouseListener());
		lblAddTarea.setIcon(new ImageIcon(PanelTareas.class.getResource("/presentation/Icons/addition-sign.png")));
		lblAddTarea.addMouseListener(new IconMouseListener(lblAddTarea));
		add(lblAddTarea, gbc_lblAddTarea);

		GridBagConstraints gbc_lblRemoveTarea = new GridBagConstraints();
		gbc_lblRemoveTarea.anchor = GridBagConstraints.WEST;
		gbc_lblRemoveTarea.insets = new Insets(0, 0, 0, 5);
		gbc_lblRemoveTarea.gridx = 1;
		gbc_lblRemoveTarea.gridy = 1;
		lblRemoveTarea.addMouseListener(new LblRemoveTareaMouseListener());
		lblRemoveTarea.setIcon(new ImageIcon(PanelTareas.class.getResource("/presentation/Icons/trash-can.png")));
		lblRemoveTarea.addMouseListener(new IconMouseListener(lblRemoveTarea));
		add(lblRemoveTarea, gbc_lblRemoveTarea);
		pnlInformacionTareas.setPTar(this);
	}

	public void cargarArbol(Proyecto p) {
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(p.getNombre());
		DefaultTreeModel model = new DefaultTreeModel(parent);
		try {
			Iterator<Tarea> itTareas = p.getTareas().iterator();
			while (itTareas.hasNext()) {
				int index = 0;
				Tarea t = itTareas.next();
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(t);
				model.insertNodeInto(node, parent, index);
				index++;
				Iterator<Subtarea> itSubtarea = t.getSubtareas().iterator();
				while (itSubtarea.hasNext()) {
					int subindex = 0;
					Subtarea s = itSubtarea.next();
					DefaultMutableTreeNode subnode = new DefaultMutableTreeNode(s);
					model.insertNodeInto(subnode, node, subindex);
					subindex++;
				}
			}
			pnlInformacionTareas.clearFields();
			arbolTareas.setModel(model);
		} catch (NullPointerException e1) {
			model = new DefaultTreeModel(new DefaultMutableTreeNode("Proyecto"));
			arbolTareas.setModel(model);
		} catch (Exception e1) {
		}
	}

	private DefaultMutableTreeNode tareaSeleccionada;
	private final JScrollPane scrollPane = new JScrollPane();

	public PanelTareas getpTar() {
		return this;
	}

	private class ArbolTareasTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent arg0) {
			if (((DefaultMutableTreeNode) (arg0.getPath().getLastPathComponent())).getUserObject()
					.getClass() == Tarea.class) {
				Tarea t = (Tarea) (((DefaultMutableTreeNode) (arg0.getPath().getLastPathComponent())).getUserObject());
				tareaSeleccionada = (DefaultMutableTreeNode) (arg0.getPath().getLastPathComponent());
				pnlInformacionTareas.setInformacionTarea(t);
			} else if (((DefaultMutableTreeNode) (arg0.getPath().getLastPathComponent())).getUserObject()
					.getClass() == Subtarea.class) {
				// FrameSubtarea fs = new FrameSubtarea();
				// Subtarea s = (Subtarea) (((DefaultMutableTreeNode)
				// (arg0.getPath().getLastPathComponent()))
				// .getUserObject());
				// fs.setPTar(getpTar());
				// fs.setInformacionSubtarea(s);
				tareaSeleccionada = (DefaultMutableTreeNode) (arg0.getPath().getLastPathComponent());
			} else if (((DefaultMutableTreeNode) (arg0.getPath().getLastPathComponent())).getUserObject()
					.getClass() == String.class) {
				pnlInformacionTareas.clearFields();
			}
			try {
				arbolTareas.setCellRenderer(new RenderArbolTareas());
			} catch (Exception e) {
			}
		}
	}

	public Tarea getTareaSelecionada() {
		return (Tarea) tareaSeleccionada.getUserObject();
	}

	public void addSubtareaToTree(Subtarea s) {
		DefaultTreeModel model = (DefaultTreeModel) arbolTareas.getModel();
		DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(s);
		model.insertNodeInto(newChild, tareaSeleccionada, 0);
	}

	public void reloadArbol() {
		((DefaultTreeModel) arbolTareas.getModel()).reload();
	}

	private class LblAddTareaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// Añadir nueva tarea
			try {
				DefaultTreeModel model = (DefaultTreeModel) arbolTareas.getModel();
				Proyecto p = findProject((String) ((DefaultMutableTreeNode) model.getRoot()).getUserObject());
				Tarea t = new Tarea("Nueva Tarea");
				p.getTareas().add(t);
				DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(t);
				model.insertNodeInto(newChild, (MutableTreeNode) model.getRoot(),
						((DefaultMutableTreeNode) model.getRoot()).getChildCount());
				((DefaultTreeModel) arbolTareas.getModel()).reload();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}

		private Proyecto findProject(String nombre) {
			Iterator<Proyecto> it = Storage.getInstance().getListaProyectos().iterator();
			while (it.hasNext()) {
				Proyecto p = it.next();
				if (p.getNombre().equals(nombre))
					return p;
			}
			return null;
		}
	}

	private class LblRemoveTareaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {
				DefaultTreeModel model = (DefaultTreeModel) arbolTareas.getModel();
				model.removeNodeFromParent(tareaSeleccionada);
				((DefaultTreeModel) arbolTareas.getModel()).reload();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
	}

	private class ArbolTareasMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getClickCount() == 2) {
				try {
					Subtarea s = (Subtarea) tareaSeleccionada.getUserObject();
					FrameSubtarea fs = new FrameSubtarea();
					fs.setPTar(getpTar());
					fs.setInformacionSubtarea(s);
				} catch (Exception e1) {
				}
			}
		}
	}
}
