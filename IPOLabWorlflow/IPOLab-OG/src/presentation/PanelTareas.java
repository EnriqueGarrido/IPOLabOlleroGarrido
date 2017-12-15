package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTree;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanelTareas extends JPanel {
	private final JTree arbolTareas = new JTree();
	private final JLabel lblAddTarea = new JLabel("");
	private final JLabel lblRemoveTarea = new JLabel("");
	private final JPanel panel = new PanelInformacionTarea();

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
		add(arbolTareas, gbc_arbolTareas);
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		GridBagConstraints gbc_lblAddTarea = new GridBagConstraints();
		gbc_lblAddTarea.anchor = GridBagConstraints.EAST;
		gbc_lblAddTarea.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddTarea.gridx = 0;
		gbc_lblAddTarea.gridy = 1;
		lblAddTarea.setIcon(new ImageIcon(PanelTareas.class.getResource("/presentation/Icons/addition-sign.png")));
		add(lblAddTarea, gbc_lblAddTarea);
		
		GridBagConstraints gbc_lblRemoveTarea = new GridBagConstraints();
		gbc_lblRemoveTarea.anchor = GridBagConstraints.WEST;
		gbc_lblRemoveTarea.insets = new Insets(0, 0, 0, 5);
		gbc_lblRemoveTarea.gridx = 1;
		gbc_lblRemoveTarea.gridy = 1;
		lblRemoveTarea.setIcon(new ImageIcon(PanelTareas.class.getResource("/presentation/Icons/trash-can.png")));
		add(lblRemoveTarea, gbc_lblRemoveTarea);

	}

}
