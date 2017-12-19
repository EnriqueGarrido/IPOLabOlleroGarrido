package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class EditorImagenes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorImagenes frame = new EditorImagenes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditorImagenes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBarraHerramientas = new JPanel();
		contentPane.add(pnlBarraHerramientas, BorderLayout.NORTH);
		GridBagLayout gbl_pnlBarraHerramientas = new GridBagLayout();
		gbl_pnlBarraHerramientas.columnWidths = new int[]{87, 0};
		gbl_pnlBarraHerramientas.rowHeights = new int[]{16, 0};
		gbl_pnlBarraHerramientas.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlBarraHerramientas.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlBarraHerramientas.setLayout(gbl_pnlBarraHerramientas);
		
		JToolBar toolBarEtiquetas = new JToolBar();
		GridBagConstraints gbc_toolBarEtiquetas = new GridBagConstraints();
		gbc_toolBarEtiquetas.anchor = GridBagConstraints.NORTHWEST;
		gbc_toolBarEtiquetas.gridx = 0;
		gbc_toolBarEtiquetas.gridy = 0;
		pnlBarraHerramientas.add(toolBarEtiquetas, gbc_toolBarEtiquetas);
	}

}
