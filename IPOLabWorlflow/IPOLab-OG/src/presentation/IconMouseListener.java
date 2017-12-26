package presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class IconMouseListener extends MouseAdapter {
	
	JLabel label;
	
	public IconMouseListener(JLabel l) {
		this.label = l;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		label.setEnabled(false);
	}
	
	public void mouseExited(MouseEvent e) {
		label.setEnabled(true);
	}
	
}
