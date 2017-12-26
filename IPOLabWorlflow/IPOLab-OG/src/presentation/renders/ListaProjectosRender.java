package presentation.renders;

import javax.swing.*;

import dominio.Proyecto;

import java.awt.*;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class ListaProjectosRender extends DefaultListCellRenderer{
	
	private DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
		JLabel render = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		Object obj = list.getModel().getElementAt(index);
		render.setIcon(new ImageIcon(ListaProjectosRender.class.getResource(readIcon(obj))));
			
		if(isSelected) render.setBackground(new Color(250, 250, 100));
		return render;
	}
	
	private String readIcon(Object obj) {
		String iconpath = "";
		Proyecto p = new Proyecto(obj.toString());
		try {
			p.readIcon();
			iconpath = p.getIcono();
			return iconpath;
			
		} catch (SQLException e) {
			System.out.println("Error leyendo iconos en el render de la lista de proyectos");
			e.printStackTrace();
			return null;
		}
	}

}
