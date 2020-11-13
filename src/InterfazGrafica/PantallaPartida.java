package InterfazGrafica;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import juegoTP.Carta;
import juegoTP.Condesa;
import juegoTP.Descarte;
import juegoTP.Jugador;
import juegoTP.Mano;
import juegoTP.Mazo;
import juegoTP.Partida;
import juegoTP.Principe;
import juegoTP.Rey;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PantallaPartida extends JFrame {

	private JPanel contentPane;
	private SpringLayout sl_contentPane;
	private JButton BotonCarta;
	private HashMap cartas;
	private Partida partida;

	private JLabel labelRonda;
	private JLabel LabelJugador1;
	private JLabel LabelJugador2;
	private JLabel LabelJugador3;
	private JLabel LabelJugador4;

	private JButton botonCarta1Jugador1;
	private JButton botonCarta2Jugador1;
	private JButton botonCarta1Jugador2;
	private JButton botonCarta2Jugador2;
	private JButton botonCarta1Jugador3;
	private JButton botonCarta2Jugador3;
	private JButton botonCarta1Jugador4;
	private JButton botonCarta2Jugador4;
	private JButton botonMazo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PantallaPartida(Partida partida) {

		this.setVisible(true);
		PantallaPartida pantallaPartida = this;
		this.partida = partida;

		cartas = new HashMap<String, JButton>();

		cartas.put("Baron", new JButton("labelBaron"));
		cartas.put("Condesa", new JButton("labelCondesa"));
		cartas.put("Guardia", new JButton("labelGuardia"));
		cartas.put("Mucama", new JButton("labelMucama"));
		cartas.put("Princesa", new JButton("labelPrincesa"));
		cartas.put("Principe", new JButton("labelPrincipe"));
		cartas.put("Rey", new JButton("labelRey"));
		cartas.put("Sacerdote", new JButton("labelSacerdote"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		LabelJugador1 = new JLabel(partida.getJugadores().get(0).getNombre());
		sl_contentPane.putConstraint(SpringLayout.SOUTH, LabelJugador1, -24, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador1, -411, SpringLayout.EAST, contentPane);
		LabelJugador1.setForeground(Color.WHITE);
		contentPane.add(LabelJugador1);

		LabelJugador2 = new JLabel(partida.getJugadores().get(1).getNombre());
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador2, -471, SpringLayout.EAST, contentPane);
		LabelJugador2.setForeground(Color.WHITE);
		contentPane.add(LabelJugador2);

		LabelJugador3 = new JLabel("Jugador 3");
		sl_contentPane.putConstraint(SpringLayout.WEST, LabelJugador3, 131, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, LabelJugador3, -256, SpringLayout.SOUTH, contentPane);
		LabelJugador3.setVerticalAlignment(SwingConstants.TOP);
		LabelJugador3.setForeground(Color.WHITE);
		contentPane.add(LabelJugador3);

		LabelJugador4 = new JLabel("Jugador 4");
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador4, -96, SpringLayout.EAST, contentPane);
		LabelJugador4.setForeground(Color.WHITE);
		contentPane.add(LabelJugador4);

		botonCarta2Jugador1 = new JButton("Carta2Jugador1");
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2Jugador1, 0, SpringLayout.WEST, LabelJugador1);

		try {
			FondoPartida fondo = new FondoPartida(ImageIO.read(new File("Imagenes\\fondo.jpg")));
			JPanel panel = (JPanel) this.getContentPane();
			panel.setBorder(fondo);

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		contentPane.add(botonCarta2Jugador1);

		labelRonda = new JLabel("Ronda x");
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelRonda, 40, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelRonda, 111, SpringLayout.WEST, contentPane);
		labelRonda.setForeground(Color.WHITE);
		labelRonda.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(labelRonda);

		botonCarta1Jugador1 = new JButton("Carta1Jugador1");
		botonCarta1Jugador1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(0, 1);
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1Jugador1, -70, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2Jugador1, 0, SpringLayout.NORTH,
				botonCarta1Jugador1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2Jugador1, 0, SpringLayout.SOUTH,
				botonCarta1Jugador1);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta2Jugador1, 191, SpringLayout.EAST,
				botonCarta1Jugador1);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1Jugador1, 439, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta1Jugador1, -509, SpringLayout.EAST, contentPane);
		botonCarta1Jugador1.setBackground(Color.WHITE);
		contentPane.add(botonCarta1Jugador1);

		botonCarta1Jugador2 = new JButton("Carta1Jugador2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1Jugador2, 60, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1Jugador2, 427, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1Jugador2, -489, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1Jugador1, 255, SpringLayout.SOUTH,
				botonCarta1Jugador2);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelRonda, -136, SpringLayout.WEST, botonCarta1Jugador2);
		contentPane.add(botonCarta1Jugador2);

		botonCarta2Jugador2 = new JButton("Carta2Jugador2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2Jugador2, 62, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2Jugador2, 611, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2Jugador2, -487, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta2Jugador2, -344, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador2, 24, SpringLayout.SOUTH, botonCarta2Jugador2);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta1Jugador2, -35, SpringLayout.WEST,
				botonCarta2Jugador2);
		contentPane.add(botonCarta2Jugador2);

		partida.setPantalla(this);
		partida.comenzarPartida();
		partida.darCarta(0);

		botonCarta1Jugador3 = new JButton("Carta1Jugador3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador3, 41, SpringLayout.SOUTH, botonCarta1Jugador3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelRonda, -285, SpringLayout.NORTH, botonCarta1Jugador3);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1Jugador3, 32, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1Jugador3, -313, SpringLayout.SOUTH, contentPane);
		contentPane.add(botonCarta1Jugador3);

		botonCarta2Jugador3 = new JButton("Carta2Jugador3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2Jugador3, 0, SpringLayout.NORTH,
				botonCarta1Jugador3);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2Jugador3, 16, SpringLayout.EAST,
				botonCarta1Jugador3);
		contentPane.add(botonCarta2Jugador3);

		botonCarta1Jugador4 = new JButton("Carta1Jugador4");
		contentPane.add(botonCarta1Jugador4);

		botonCarta2Jugador4 = new JButton("Carta2Jugador4");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2Jugador4, -316, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador4, 31, SpringLayout.SOUTH, botonCarta2Jugador4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1Jugador4, 0, SpringLayout.NORTH,
				botonCarta2Jugador4);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta1Jugador4, -6, SpringLayout.WEST,
				botonCarta2Jugador4);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2Jugador4, 0, SpringLayout.WEST, LabelJugador4);
		contentPane.add(botonCarta2Jugador4);

		botonMazo = new JButton("Mazo");
		botonMazo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (partida.getJugadores().get(partida.getRonda().getTurnoDeJugador())
						.agarrarCarta(partida.getRonda().getMazo())) {
					switch (partida.getRonda().getTurnoDeJugador()) {
					case 0:
						pantallaPartida.mostrarCartasJugador1(partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()).getManoDeCartas());
						break;
					case 1:
						pantallaPartida.mostrarCartasJugador2(partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()).getManoDeCartas());
						break;

					case 2:
						pantallaPartida.mostrarCartasJugador3(partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()).getManoDeCartas());
						break;
					case 3:
						pantallaPartida.mostrarCartasJugador4(partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()).getManoDeCartas());
						break;

					default:
						break;
					}
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonMazo, -100, SpringLayout.NORTH, botonCarta2Jugador1);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonMazo, -174, SpringLayout.WEST, botonCarta1Jugador4);
		contentPane.add(botonMazo);

		botonCarta1Jugador1.setVisible(false);
		botonCarta2Jugador1.setVisible(false);
		botonCarta1Jugador2.setVisible(false);
		botonCarta2Jugador2.setVisible(false);
		botonCarta1Jugador3.setVisible(false);
		botonCarta2Jugador3.setVisible(false);
		botonCarta1Jugador4.setVisible(false);
		botonCarta2Jugador4.setVisible(false);

	}

	public void jugarCarta(int nroJugador, int nroCarta) {

		if (partida.getJugadores().get(nroJugador).getManoDeCartas().estaCarta(new Condesa())
				&& (partida.getJugadores().get(nroJugador).getManoDeCartas().estaCarta(new Principe())
						|| partida.getJugadores().get(nroJugador).getManoDeCartas().estaCarta(new Rey()))) {

			JOptionPane.showMessageDialog(this, "Solo Puede Jugar Condesa");
			partida.getJugadores().get(nroJugador).jugarCarta(
					partida.getJugadores().get(nroJugador).getManoDeCartas().sacarCondesa(),
					partida.getRonda().getDescarte(), partida.getJugadores(), partida.getRonda().getMazo(),
					partida.getJugadores().get(nroJugador));
		} else {
			partida.getJugadores().get(nroJugador).jugada(nroCarta, partida.getRonda().getMazo(),
					partida.getJugadores(), partida.getRonda().getDescarte());
		}

	}

	public void mostrarCartasJugador1(Mano cartas) {
		botonCarta1Jugador1.setText(cartas.getCarta(1).getNombre());
		botonCarta2Jugador1.setText(cartas.getCarta(2).getNombre());
		botonCarta1Jugador1.setVisible(true);
		botonCarta2Jugador1.setVisible(true);
	}

	public void mostrarCartasJugador2(Mano cartas) {
		botonCarta1Jugador2.setText(cartas.getCarta(1).getNombre());
		botonCarta2Jugador2.setText(cartas.getCarta(2).getNombre());
		botonCarta1Jugador2.setVisible(true);
		botonCarta2Jugador2.setVisible(true);
	}

	public void mostrarCartasJugador3(Mano cartas) {
		botonCarta1Jugador3.setText(cartas.getCarta(1).getNombre());
		botonCarta2Jugador3.setText(cartas.getCarta(2).getNombre());
		botonCarta1Jugador3.setVisible(true);
		botonCarta2Jugador3.setVisible(true);
	}

	public void mostrarCartasJugador4(Mano cartas) {
		botonCarta1Jugador3.setText(cartas.getCarta(1).getNombre());
		botonCarta2Jugador3.setText(cartas.getCarta(2).getNombre());
		botonCarta1Jugador4.setVisible(true);
		botonCarta2Jugador4.setVisible(true);
	}

	public void mostrarRonda(int nroRonda) throws InterruptedException {
		labelRonda.setText("Ronda " + nroRonda);

	}

	public void mazoVacio() {

	}

	class FondoPartida implements Border {

		private BufferedImage mImagen = null;

		public FondoPartida(BufferedImage pImagen) {
			mImagen = pImagen;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			if (mImagen != null) {
				g.drawImage(mImagen, 0, 0, width, height, null);
			}
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(0, 0, 0, 0);
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}
	}
}
