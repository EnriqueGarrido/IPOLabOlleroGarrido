package presentation.renders;

import java.awt.Component;
import javax.swing.tree.TreeCellRenderer;
import java.awt.Component;
import javax.swing.*;
import javax.swing.tree.*;

public class arbolTareas_render extends DefaultTreeCellRenderer {

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
			String c = (String)(nodo.getUserObject());
			switch (c)
			{
			case "Primer Hito":
			setIcon(new ImageIcon(arbolTareas_render.class.getResource("inicio.png")));
			break;
			case "Segundo Hito":
			setIcon(new ImageIcon(arbolTareas_render.class.getResource("ayuda.png")));
			break;
			case "Tercer Hito":
			setIcon(new ImageIcon(arbolTareas_render.class.getResource("adjunto.png")));
			break;
			default:
			setIcon(new ImageIcon(arbolTareas_render.class.getResource("pantalla.png")));
			break;
			}
			return this;
			}
	}
