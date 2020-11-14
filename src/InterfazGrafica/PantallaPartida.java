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
import juegoTP.Guardia;
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
	private JButton botonDescarte;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		try {
			FondoPartida fondo = new FondoPartida(ImageIO.read(new File("Imagenes\\fondo.jpg")));
			JPanel panel = (JPanel) this.getContentPane();
			panel.setBorder(fondo);

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		LabelJugador1 = new JLabel(partida.getJugadores().get(0).getNombre());
		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador1, 609, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador1, -425, SpringLayout.EAST, contentPane);
		LabelJugador1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelJugador1.setForeground(Color.WHITE);
		contentPane.add(LabelJugador1);

		LabelJugador2 = new JLabel(partida.getJugadores().get(1).getNombre());
		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador2, 181, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador2, 0, SpringLayout.EAST, LabelJugador1);
		LabelJugador2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelJugador2.setForeground(Color.WHITE);
		contentPane.add(LabelJugador2);

		LabelJugador3 = new JLabel("Jugador 3");
		sl_contentPane.putConstraint(SpringLayout.WEST, LabelJugador3, 122, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, LabelJugador3, -278, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador3, 198, SpringLayout.WEST, contentPane);
		LabelJugador3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelJugador3.setVerticalAlignment(SwingConstants.TOP);
		LabelJugador3.setForeground(Color.WHITE);
		contentPane.add(LabelJugador3);
		if (partida.getJugadores().size() > 2) {
			LabelJugador3.setText(partida.getJugadores().get(2).getNombre());
		} else {
			LabelJugador3.setVisible(false);
		}

		LabelJugador4 = new JLabel("Jugador 4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador4, 0, SpringLayout.NORTH, LabelJugador3);
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador4, -115, SpringLayout.EAST, contentPane);
		LabelJugador4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelJugador4.setForeground(Color.WHITE);
		contentPane.add(LabelJugador4);
		if (partida.getJugadores().size() > 3) {
			LabelJugador4.setText(partida.getJugadores().get(3).getNombre());
		} else {
			LabelJugador4.setVisible(false);
		}

		botonCarta2Jugador1 = new JButton("Carta2Jugador1");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2Jugador1, -70, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta2Jugador1, -337, SpringLayout.EAST, contentPane);

		contentPane.add(botonCarta2Jugador1);

		labelRonda = new JLabel("Ronda x");
		labelRonda.setForeground(Color.WHITE);
		labelRonda.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(labelRonda);

		botonCarta1Jugador1 = new JButton("Carta1Jugador1");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1Jugador1, -70, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2Jugador1, 0, SpringLayout.NORTH, botonCarta1Jugador1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1Jugador1, 252, SpringLayout.SOUTH, LabelJugador2);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta1Jugador1, -471, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1Jugador1, 471, SpringLayout.WEST, contentPane);
		botonCarta1Jugador1.setBackground(Color.WHITE);
		contentPane.add(botonCarta1Jugador1);

		botonCarta1Jugador2 = new JButton("Carta1Jugador2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelRonda, 0, SpringLayout.NORTH, botonCarta1Jugador2);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelRonda, -254, SpringLayout.WEST, botonCarta1Jugador2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1Jugador2, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1Jugador2, 471, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1Jugador2, -6, SpringLayout.NORTH, LabelJugador2);
		contentPane.add(botonCarta1Jugador2);

		botonCarta2Jugador2 = new JButton("Carta2Jugador2");
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2Jugador2, 605, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta2Jugador2, -334, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta1Jugador2, -11, SpringLayout.WEST, botonCarta2Jugador2);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2Jugador1, 0, SpringLayout.WEST, botonCarta2Jugador2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2Jugador2, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2Jugador2, -6, SpringLayout.NORTH, LabelJugador2);
		contentPane.add(botonCarta2Jugador2);

		partida.setPantalla(this);
		partida.comenzarPartida();
		partida.darCarta(0);

		botonCarta1Jugador3 = new JButton("Carta1Jugador3");
		sl_contentPane.putConstraint(SpringLayout.WEST, labelRonda, 0, SpringLayout.WEST, botonCarta1Jugador3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelRonda, -148, SpringLayout.NORTH, botonCarta1Jugador3);

		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador3, 6, SpringLayout.SOUTH, botonCarta1Jugador3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1Jugador3, 210, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1Jugador3, -313, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1Jugador3, 32, SpringLayout.WEST, contentPane);
		contentPane.add(botonCarta1Jugador3);

		botonCarta2Jugador3 = new JButton("Carta2Jugador3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2Jugador3, 0, SpringLayout.NORTH, botonCarta1Jugador3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2Jugador3, -6, SpringLayout.NORTH, LabelJugador3);
		contentPane.add(botonCarta2Jugador3);

		botonCarta1Jugador4 = new JButton("Carta1Jugador4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1Jugador4, 0, SpringLayout.NORTH, botonCarta1Jugador3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1Jugador4, -6, SpringLayout.NORTH, LabelJugador4);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta1Jugador4, -155, SpringLayout.EAST, contentPane);
		contentPane.add(botonCarta1Jugador4);

		botonCarta2Jugador4 = new JButton("Carta2Jugador4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2Jugador4, 0, SpringLayout.NORTH, botonCarta1Jugador3);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2Jugador4, 9, SpringLayout.EAST, botonCarta1Jugador4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2Jugador4, -313, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta2Jugador4, -23, SpringLayout.EAST, contentPane);
		contentPane.add(botonCarta2Jugador4);

		botonMazo = new JButton("Mazo");
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1Jugador4, 114, SpringLayout.EAST, botonMazo);
		botonMazo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (partida.getJugadores().get(partida.getRonda().getTurnoDeJugador())
						.agarrarCarta(partida.getRonda().getMazo())) {
					switch (partida.getRonda().getTurnoDeJugador()) {
					case 0:
						actualizarLabelJugador1(partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()));
						pantallaPartida.mostrarCartasJugador1(
								partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()).getManoDeCartas());
						break;
					case 1:
						actualizarLabelJugador2(partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()));
						pantallaPartida.mostrarCartasJugador2(
								partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()).getManoDeCartas());
						break;

					case 2:
						actualizarLabelJugador3(partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()));
						pantallaPartida.mostrarCartasJugador3(
								partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()).getManoDeCartas());
						break;
					case 3:
						actualizarLabelJugador4(partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()));
						pantallaPartida.mostrarCartasJugador4(
								partida.getJugadores().get(partida.getRonda().getTurnoDeJugador()).getManoDeCartas());
						break;

					default:
						break;
					}
				}
			}

		});
		contentPane.add(botonMazo);

		botonDescarte = new JButton("Vacio");
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta2Jugador3, -180, SpringLayout.WEST, botonDescarte);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonMazo, 63, SpringLayout.NORTH, botonDescarte);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonMazo, 19, SpringLayout.EAST, botonDescarte);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonDescarte, 35, SpringLayout.SOUTH, LabelJugador2);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonDescarte, 0, SpringLayout.WEST, botonCarta1Jugador1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonDescarte, 0, SpringLayout.SOUTH, LabelJugador4);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonDescarte, 0, SpringLayout.EAST, botonCarta1Jugador1);
		contentPane.add(botonDescarte);
		botonCarta1Jugador1.setVisible(false);
		botonCarta2Jugador1.setVisible(false);
		botonCarta1Jugador2.setVisible(false);
		botonCarta2Jugador2.setVisible(false);
		botonCarta1Jugador3.setVisible(false);
		botonCarta2Jugador3.setVisible(false);
		botonCarta1Jugador4.setVisible(false);
		botonCarta2Jugador4.setVisible(false);

		botonCarta1Jugador1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(0, 1);
				botonCarta1Jugador1.setVisible(false);
				botonCarta2Jugador1.setVisible(false);

			}
		});

		botonCarta2Jugador1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(0, 2);
				botonCarta1Jugador1.setVisible(false);
				botonCarta2Jugador1.setVisible(false);

			}
		});

		botonCarta1Jugador2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(1, 1);
				botonCarta1Jugador2.setVisible(false);
				botonCarta2Jugador2.setVisible(false);
			}
		});

		botonCarta2Jugador2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(1, 2);
				botonCarta1Jugador2.setVisible(false);
				botonCarta2Jugador2.setVisible(false);
			}
		});

		botonCarta1Jugador3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(2, 1);
				botonCarta1Jugador2.setVisible(false);
				botonCarta2Jugador2.setVisible(false);
			}
		});

		botonCarta2Jugador3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(2, 2);
				botonCarta1Jugador2.setVisible(false);
				botonCarta2Jugador2.setVisible(false);
			}
		});

		botonCarta1Jugador4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(3, 1);
				botonCarta1Jugador2.setVisible(false);
				botonCarta2Jugador2.setVisible(false);
			}
		});

		botonCarta2Jugador4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaPartida.jugarCarta(3, 2);
				botonCarta1Jugador2.setVisible(false);
				botonCarta2Jugador2.setVisible(false);
			}
		});

	}

	public void jugarCarta(int nroJugador, int nroCarta) {

		Jugador atacante = partida.getJugadores().get(nroJugador);
		Jugador jugadorAtacado = null;

		Carta cartaSeleccionada = atacante.getManoDeCartas().getCarta(nroCarta);

		if (atacante.getManoDeCartas().estaCarta(new Condesa()) && (atacante.getManoDeCartas().estaCarta(new Principe())
				|| atacante.getManoDeCartas().estaCarta(new Rey()))) {

			JOptionPane.showMessageDialog(this, "Solo Puede Jugar Condesa");

			if (partida.getJugadores().get(nroJugador).getManoDeCartas().getCarta(1).getNombre()
					.compareTo("Condesa") == 0) {
				cartaSeleccionada = atacante.getManoDeCartas().sacarCarta(0);
				partida.getRonda().getDescarte().agregarCarta(cartaSeleccionada);

			} else {
				cartaSeleccionada = atacante.getManoDeCartas().sacarCarta(1);
				partida.getRonda().getDescarte().agregarCarta(cartaSeleccionada);
			}

		} else {
			JOptionPane.showMessageDialog(this, cartaSeleccionada.getDescripcion());

			if (atacante.getEstado() == "Inmune") {
				atacante.setEstado("Jugando");
			}

			partida.getRonda().getDescarte().agregarCarta(atacante.getManoDeCartas().sacarCarta(nroCarta - 1));

			cartaSeleccionada.activarEfecto(atacante, partida.getJugadores(), partida.getRonda().getMazo(), this);

		}

		botonDescarte.setText(cartaSeleccionada.getNombre());
		atacante.sumarTiradas();
		if (partida.getRonda().verificarFinDeRonda()) {
			JOptionPane.showMessageDialog(this,
					"Ronda finalizada, el ganador es " + partida.getRonda().getGanador().getNombre());
			partida.setNroRonda(1);
			if (partida.verificarFinPartida()) {
				JOptionPane.showMessageDialog(this,
						"Partida finalizada, el ganador es " + partida.getGanador().getNombre());

			} else {
				JOptionPane.showMessageDialog(this, "Ronda " + partida.getNroRonda());
				labelRonda.setText("Ronda " + partida.getNroRonda());
				botonDescarte.setText("Vacio");
				partida.getRonda().resetRonda();
			}
		} else {
			partida.getRonda().pasarTurno();
		}

	}

	public Partida getPartida() {
		return partida;
	}

	private void actualizarLabelJugador1(Jugador jugador) {

		botonCarta1Jugador1.setText(jugador.getManoDeCartas().getCarta(1).getNombre());
		botonCarta2Jugador1.setText(jugador.getManoDeCartas().getCarta(2).getNombre());
	}

	private void actualizarLabelJugador2(Jugador jugador) {

		botonCarta1Jugador2.setText(jugador.getManoDeCartas().getCarta(1).getNombre());
		botonCarta2Jugador2.setText(jugador.getManoDeCartas().getCarta(2).getNombre());
	}

	private void actualizarLabelJugador3(Jugador jugador) {

		botonCarta1Jugador3.setText(jugador.getManoDeCartas().getCarta(1).getNombre());
		botonCarta2Jugador3.setText(jugador.getManoDeCartas().getCarta(2).getNombre());

	}

	private void actualizarLabelJugador4(Jugador jugador) {

		botonCarta1Jugador4.setText(jugador.getManoDeCartas().getCarta(1).getNombre());
		botonCarta2Jugador4.setText(jugador.getManoDeCartas().getCarta(2).getNombre());

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
