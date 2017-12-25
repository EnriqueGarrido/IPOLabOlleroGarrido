package presentation.renders;

import java.awt.Dimension;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ComboBox_projectIcon extends JComboBox{
	
	public ComboBox_projectIcon(int itemNum) {
		Dimension d = new Dimension(206,26);
        this.setSize(d);
        this.setPreferredSize(d);
        for( int i=0; i<itemNum; i++)
        {
            this.addItem(i);
        }    
        this.setVisible(true);
	}

}
