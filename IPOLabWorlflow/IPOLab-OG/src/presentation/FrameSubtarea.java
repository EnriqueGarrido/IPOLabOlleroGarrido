package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Subtarea;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrameSubtarea extends JFrame {

	private JPanel contentPane;
	private final JLabel lblSubtarea = new JLabel("Subtarea:");
	private final JTextField txtSubtarea = new JTextField();
	private final JLabel lblDetalles = new JLabel("Detalles:");
	private final JTextArea txtaDetalles = new JTextArea();
	private final JButton btnSave = new JButton("Guardar");

	private Subtarea subtarea;
	private PanelTareas pTar;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FrameSubtarea frame = new FrameSubtarea();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public FrameSubtarea() {
		setTitle("Detalles de la subtarea");
		txtSubtarea.setColumns(10);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 385, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 48, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		GridBagConstraints gbc_lblSubtarea = new GridBagConstraints();
		gbc_lblSubtarea.anchor = GridBagConstraints.EAST;
		gbc_lblSubtarea.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubtarea.gridx = 1;
		gbc_lblSubtarea.gridy = 1;
		contentPane.add(lblSubtarea, gbc_lblSubtarea);

		GridBagConstraints gbc_txtSubtarea = new GridBagConstraints();
		gbc_txtSubtarea.gridwidth = 2;
		gbc_txtSubtarea.insets = new Insets(0, 0, 5, 5);
		gbc_txtSubtarea.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSubtarea.gridx = 2;
		gbc_txtSubtarea.gridy = 1;
		contentPane.add(txtSubtarea, gbc_txtSubtarea);

		GridBagConstraints gbc_lblDetalles = new GridBagConstraints();
		gbc_lblDetalles.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetalles.gridx = 1;
		gbc_lblDetalles.gridy = 2;
		contentPane.add(lblDetalles, gbc_lblDetalles);

		GridBagConstraints gbc_txtaDetalles = new GridBagConstraints();
		gbc_txtaDetalles.gridwidth = 3;
		gbc_txtaDetalles.insets = new Insets(0, 0, 5, 5);
		gbc_txtaDetalles.fill = GridBagConstraints.BOTH;
		gbc_txtaDetalles.gridx = 1;
		gbc_txtaDetalles.gridy = 3;
		txtaDetalles.setLineWrap(true);
		contentPane.add(txtaDetalles, gbc_txtaDetalles);

		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 4;
		btnSave.addActionListener(new BtnSaveActionListener());
		btnSave.setIcon(new ImageIcon(FrameSubtarea.class.getResource("/presentation/Icons/save.png")));
		contentPane.add(btnSave, gbc_btnSave);
		setVisible(true);
	}

	public static void initialize() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSubtarea frame = new FrameSubtarea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setInformacionSubtarea(Subtarea s) {
		if (!s.getNombre().equals("Nueva Subtarea"))
			txtSubtarea.setEditable(false);
		this.subtarea = s;
		txtSubtarea.setText(s.getNombre());
		txtaDetalles.setText(s.getDescripcion());
	}

	private class BtnSaveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			txtSubtarea.setEditable(false);
			subtarea.setNombre(txtSubtarea.getText());
			subtarea.setDescripcion(txtaDetalles.getText());
			pTar.reloadArbol();
		}
	}
	
	public void setPTar(PanelTareas tar) {
		this.pTar = tar;
	}
}
