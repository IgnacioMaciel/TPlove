package InterfazGrafica;

import juegoTP.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPartida extends JFrame {

	private JPanel contentPane;
	private SpringLayout sl_contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PantallaPartida(Partida partida) {
		
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Jugador 3");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 32, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -269, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jugador 2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 40, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -430, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Jugador 1");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -21, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Jugador 4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 335, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, -10, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_3);
		
		JLabel mazo = new JLabel("mazo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, mazo, 319, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, mazo, -301, SpringLayout.EAST, contentPane);
		contentPane.add(mazo);
		
		partida.setPantalla(this);
		partida.jugarPartida();
		

	}
	
	public void habilitarJugador() {
		
	}
	
	public void ponerMazo() {
		JLabel mazo = new JLabel("mazo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, mazo, 319, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, mazo, -301, SpringLayout.EAST, contentPane);
		contentPane.add(mazo);
	}
}
