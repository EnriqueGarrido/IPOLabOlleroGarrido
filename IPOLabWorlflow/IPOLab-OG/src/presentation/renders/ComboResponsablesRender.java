package presentation.renders;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings("rawtypes")
public class ComboResponsablesRender extends JLabel implements ListCellRenderer {

	private String[] items;

	public ComboResponsablesRender(ArrayList<String> items) {
		setOpaque(true);
		this.items = new String[items.size()];
		for(int i = 0; i<this.items.length; i++) {
			this.items[i] = items.get(i);
		}
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocused) {
		int selectedIndex = ((Integer) value).intValue();

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setText(this.items[selectedIndex]);
		return this;
	}
}