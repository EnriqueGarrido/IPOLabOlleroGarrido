package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTree;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class PanelTareas extends JPanel {
	private final JTree arbolTareas = new JTree();
	private final JLabel lblAddTarea = new JLabel("");
	private final JLabel lblRemoveTarea = new JLabel("");
	private final JPanel pnlInformacionTareas = new PanelInformacionTarea();

	/**
	 * Create the panel.
	 */
	public PanelTareas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{178, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_arbolTareas = new GridBagConstraints();
		gbc_arbolTareas.gridwidth = 2;
		gbc_arbolTareas.insets = new Insets(0, 0, 5, 5);
		gbc_arbolTareas.fill = GridBagConstraints.BOTH;
		gbc_arbolTareas.gridx = 0;
		gbc_arbolTareas.gridy = 0;
		arbolTareas.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Proyecto de Ejemplo") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Tarea de tipo 1");
						node_1.add(new DefaultMutableTreeNode("subtarea-1-1"));
						node_1.add(new DefaultMutableTreeNode("subtarea-1-2"));
						node_1.add(new DefaultMutableTreeNode("subtarea-1-3"));
						node_1.add(new DefaultMutableTreeNode("subtarea-1-3"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Tarea de tipo 2");
						node_1.add(new DefaultMutableTreeNode("subtarea-2-1"));
						node_1.add(new DefaultMutableTreeNode("subtarea-2-2"));
						node_1.add(new DefaultMutableTreeNode("subtarea-2-3"));
						node_1.add(new DefaultMutableTreeNode("subtarea-2-4"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Tarea de tipo 3");
						node_1.add(new DefaultMutableTreeNode("subtarea-3-1"));
						node_1.add(new DefaultMutableTreeNode("subtarea-3-2"));
						node_1.add(new DefaultMutableTreeNode("rsubtarea-3-3"));
						node_1.add(new DefaultMutableTreeNode("subtarea-3-4"));
					add(node_1);
				}
			}
		));
		add(arbolTareas, gbc_arbolTareas);
		
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
		lblAddTarea.setIcon(new ImageIcon(PanelTareas.class.getResource("/presentation/Icons/addition-sign.png")));
		lblAddTarea.addMouseListener(new IconMouseListener(lblAddTarea));
		add(lblAddTarea, gbc_lblAddTarea);
		
		GridBagConstraints gbc_lblRemoveTarea = new GridBagConstraints();
		gbc_lblRemoveTarea.anchor = GridBagConstraints.WEST;
		gbc_lblRemoveTarea.insets = new Insets(0, 0, 0, 5);
		gbc_lblRemoveTarea.gridx = 1;
		gbc_lblRemoveTarea.gridy = 1;
		lblRemoveTarea.setIcon(new ImageIcon(PanelTareas.class.getResource("/presentation/Icons/trash-can.png")));
		lblRemoveTarea.addMouseListener(new IconMouseListener(lblRemoveTarea));
		add(lblRemoveTarea, gbc_lblRemoveTarea);

	}

}
