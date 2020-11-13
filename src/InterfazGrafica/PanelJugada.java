package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juegoTP.Jugador;

public class PanelJugada extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8935022892651340592L;
	
	private JLabel carta;
	
	public PanelJugada(Jugador jugador) {
		super();
		setPreferredSize(new Dimension(500,100));
		carta = new JLabel();
		this.setLayout(new GridLayout(1,5));
		this.setOpaque(true);
		this.setVisible(true);

		JLabel cartaImagen = new JLabel();
		cartaImagen.setBackground(Color.GRAY);
		cartaImagen.setOpaque(false);
		cartaImagen.setVisible(true);
		
		ImageIcon newIcon;

		ImageIcon img = new ImageIcon("Imagenes/"+jugador.getManoDeCartas().getMano().get(0).getNombre()+".png");
		Image img2 = img.getImage();
		Image newimg = img2.getScaledInstance(62, 91,  java.awt.Image.SCALE_SMOOTH);
		newIcon = new ImageIcon(newimg);
		}
		
		cartaImagen.setIcon(newIcon);
		cartaImagen.setPreferredSize(new Dimension(62,91));
		cartaImagen.revalidate();
		cartaImagen.setOpaque(false);
		cartaImagen.repaint();
		
	}
}
