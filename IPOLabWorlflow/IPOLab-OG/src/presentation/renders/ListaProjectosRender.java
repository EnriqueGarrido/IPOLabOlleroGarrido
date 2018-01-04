package presentation.renders;

import javax.swing.*;

import dominio.Proyecto;
import persistencia.Storage;

import java.awt.*;
import java.sql.SQLException;
import java.util.Iterator;

@SuppressWarnings("serial")
public class ListaProjectosRender extends DefaultListCellRenderer {

	private DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean hasFocus) {
		JLabel render = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		Object obj = list.getModel().getElementAt(index);
		render.setIcon(new ImageIcon(ListaProjectosRender.class.getResource(readIcon(obj))));

		if (isSelected)
			render.setBackground(new Color(250, 250, 100));
		return render;
	}

	private String readIcon(Object obj) {
		String iconpath = "";
		Proyecto p = new Proyecto(obj.toString());
		Iterator<Proyecto> it = Storage.getInstance().getListaProyectos().iterator();
		while (it.hasNext()) {
			p = it.next();
			if (obj.toString().equals(p.getNombre()))
				break;
		}
		iconpath = p.getIcono();
		return iconpath;

	}

}
