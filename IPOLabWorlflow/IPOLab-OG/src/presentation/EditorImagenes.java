package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EditorImagenes extends JFrame {

	private JPanel contentPane;
	private MiAreaDibujo miAreaDibujo;
	private ImageIcon imagen;
	int modo =-1;
	private final int TEXTO=2;
	private final int RECTANGULO=1;
	private Image imagTexto;
	private Image imagRectangulo;
	private Cursor cursorRectangulo;
	private Cursor cursorTexto;
	private Toolkit toolkit;
	private int x,y;
	private JTextField txtTexto= new JTextField();
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
		gbl_pnlBarraHerramientas.columnWidths = new int[]{87, 0, 0, 0};
		gbl_pnlBarraHerramientas.rowHeights = new int[]{16, 0};
		gbl_pnlBarraHerramientas.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBarraHerramientas.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlBarraHerramientas.setLayout(gbl_pnlBarraHerramientas);
		
		JToolBar toolBarEtiquetas = new JToolBar();
		GridBagConstraints gbc_toolBarEtiquetas = new GridBagConstraints();
		gbc_toolBarEtiquetas.insets = new Insets(0, 0, 0, 5);
		gbc_toolBarEtiquetas.anchor = GridBagConstraints.NORTHWEST;
		gbc_toolBarEtiquetas.gridx = 0;
		gbc_toolBarEtiquetas.gridy = 0;
		pnlBarraHerramientas.add(toolBarEtiquetas, gbc_toolBarEtiquetas);
		
		JButton btnCargarMapa = new JButton("Cargar Imagen");
		btnCargarMapa.addActionListener(new BtnCargarMapaActionListener());
		toolBarEtiquetas.add(btnCargarMapa);
		
		JButton BtnRectangulo = new JButton("");
		BtnRectangulo.addActionListener(new BtnRectanguloActionListener());
		BtnRectangulo.setIcon(new ImageIcon(EditorImagenes.class.getResource("/presentation/Icons/rectangulo.png")));
		toolBarEtiquetas.add(BtnRectangulo);
		
		JButton BtnComentario = new JButton("");
		BtnComentario.addActionListener(new BtnComentarioActionListener());
		BtnComentario.setIcon(new ImageIcon(EditorImagenes.class.getResource("/presentation/Icons/aniadirAnotacion.png")));
		toolBarEtiquetas.add(BtnComentario);
		
		JButton btnNewButton_3 = new JButton("New button");
		toolBarEtiquetas.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		toolBarEtiquetas.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		miAreaDibujo = new MiAreaDibujo();
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		miAreaDibujo.setIcon(null);
		scrollPane.setViewportView(miAreaDibujo);
		
		toolkit = Toolkit.getDefaultToolkit();
		imagRectangulo = toolkit.getImage(getClass().getClassLoader().getResource("presentation/Icons/rectangulo.png"));
		imagTexto = toolkit.getImage(getClass().getClassLoader().getResource("presentation/Icons/aniadirAnotacion.png"));
		
		cursorRectangulo = toolkit.createCustomCursor(imagRectangulo,new Point(0,0),"CURSOR_RECTANGULO");
		cursorTexto= toolkit.createCustomCursor(imagTexto,new Point(0,0),"CURSOR_TEXTO");
	}

	private class BtnCargarMapaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(miAreaDibujo);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
			File file = fcAbrir.getSelectedFile();
			imagen = new ImageIcon(file.getAbsolutePath());
			miAreaDibujo.setIcon(imagen);
			}

		}
	}
	private class BtnRectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RECTANGULO;
			miAreaDibujo.setCursor(cursorRectangulo);
		}
	}
	private class BtnComentarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = TEXTO;
			miAreaDibujo.setCursor(cursorTexto);
		}
	}
	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent arg0) {
			x = arg0.getX();
			y = arg0.getY();
			toolkit = toolkit.getDefaultToolkit();
			if (imagen != null) {
				switch (modo) {
				case RECTANGULO:
					miAreaDibujo.addObjetoGrafico(new RectanguloGrafico(x,y,x,y,Color.RED));
					break;
				case TEXTO:
					txtTexto.setBounds(x, y, 200,30);
					txtTexto.setVisible(true);
					txtTexto.requestFocus();
					txtTexto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg) {
					if(!txtTexto.getText().equals(""))
					miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(),Color.BLUE));
					txtTexto.setText("");
					txtTexto.setVisible(false);
					miAreaDibujo.repaint();
					}
					});
					miAreaDibujo.add(txtTexto);
				}
				
			}
		}
	}
	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTANGULO && imagen!=null) {
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
				}
		}
	}
}
