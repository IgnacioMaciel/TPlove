package InterfazGrafica;

import juegoTP.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import InterfazGrafica.PantallaPartida.FondoPartida;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPartida extends JFrame {

	private JPanel contentPane;
	private SpringLayout sl_contentPane;
	FondoPartida fondo = new FondoPartida();
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PantallaPartida(Partida partida, int cantidadJugadores) {
		
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new FondoPartida();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Jugador 3");
		lblNewLabel.setForeground(Color.white);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 50, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -270, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jugador 2");
		lblNewLabel_1.setForeground(Color.white);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 155, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -455, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Jugador 1");
		lblNewLabel_2.setForeground(Color.white);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, -15, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Jugador 4");
		lblNewLabel_3.setForeground(Color.white);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 400, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, -55, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_3);
		
		JLabel mazo = new JLabel("mazo");
		mazo.setForeground(Color.white);
		sl_contentPane.putConstraint(SpringLayout.NORTH, mazo, 319, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, mazo, -301, SpringLayout.EAST, contentPane);
		contentPane.add(mazo);
		
	//	partida.setPantalla(this);
	//	partida.jugarPartida();
		

	}
	
	public void habilitarJugador() {
		
	}
	
	public void ponerMazo() {
		JLabel mazo = new JLabel("mazo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, mazo, 319, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, mazo, -301, SpringLayout.EAST, contentPane);
		contentPane.add(mazo);
	}
	
	class FondoPartida extends JPanel{
		private Image imagen;
		public void paint(Graphics g) {
		//	if(cantidadJugadores==2)
			imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg")).getImage(); 
			g.drawImage(imagen, 0, 0, getWidth(),getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}
	}
}
