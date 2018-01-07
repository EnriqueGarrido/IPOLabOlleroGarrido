package presentation;

import java.awt.Component;
import java.util.Iterator;
import java.awt.Component;
import javax.swing.tree.TreeCellRenderer;

import dominio.Proyecto;
import dominio.Subtarea;
import dominio.Tarea;
import persistencia.Storage;

import java.awt.Component;
import javax.swing.*;
import javax.swing.tree.*;

class RenderArbolTareas extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
		if (nodo.getUserObject().getClass() == Tarea.class) {
			setIcon(new ImageIcon(RenderArbolTareas.class.getResource("/presentation/Icons/task2.png")));
		} else if (nodo.getUserObject().getClass() == Subtarea.class) {
			setIcon(new ImageIcon(RenderArbolTareas.class.getResource("/presentation/Icons/subtarea.png")));
		} else if (((String) nodo.getUserObject()).equals("Proyecto")) {
			setIcon(new ImageIcon(RenderArbolTareas.class.getResource("/presentation/Icons/addition-sign.png")));
		} else if (nodo.getUserObject().getClass() == String.class) {
			Iterator<Proyecto> it = Storage.getInstance().getListaProyectos().iterator();
			Proyecto proyecto = null;
			while (it.hasNext()) {
				Proyecto p = it.next();
				if (p.getNombre().equals((String) nodo.getUserObject()))
					proyecto = p;
			}
			String pathIcon = "/presentation/Icons/proyecto";
			if (proyecto.getIcono() < 9)
				pathIcon += "0" + (proyecto.getIcono() + 1);
			else
				pathIcon += (proyecto.getIcono() + 1);
			pathIcon += ".png";
			setIcon(new ImageIcon(RenderArbolTareas.class.getResource(pathIcon)));
		}

		return this;
	}
}