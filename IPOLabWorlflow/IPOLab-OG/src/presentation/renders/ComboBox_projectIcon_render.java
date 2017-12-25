package presentation.renders;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings({ "serial", "rawtypes" })
public class ComboBox_projectIcon_render extends JLabel implements ListCellRenderer {

	private ImageIcon[] items;

	public ComboBox_projectIcon_render(ArrayList<ImageIcon> items) {
		setOpaque(true);
		this.items = new ImageIcon[items.size()];
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

		ImageIcon icon = this.items[selectedIndex];
		setIcon(icon);
		File f = new File(items[selectedIndex].toString());
//		setText(f.getName());
		return this;
	}
}
