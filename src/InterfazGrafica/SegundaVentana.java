package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Component;

import juegoTP.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import InterfazGrafica.PantallaInicio.FondoPartida;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class SegundaVentana extends PantallaInicio {

	private JPanel contentPane;
	private JFrame pantalla1;
	private String jugador;
	private JTextField textField_nombreJugador;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SegundaVentana frame = new
	 * SegundaVentana(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public SegundaVentana(JFrame p1, String jug) {

		jugador = jug;
		p1.setVisible(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		 try {
				FondoPartida fondo = new FondoPartida(ImageIO.read(new File("Imagenes\\menu.jpg")));
				JPanel panel = (JPanel) this.getContentPane();
				panel.setBorder(fondo);

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		
		JButton botonCrearPartida = new JButton("Crear partida");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCrearPartida, -24, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCrearPartida, -31, SpringLayout.EAST, contentPane);

		contentPane.add(botonCrearPartida);

		JLabel lblNewLabel = new JLabel("Cantidad de corazones para ganar");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 39, SpringLayout.WEST, contentPane);
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);

		JComboBox comboCantidadCorazones = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboCantidadCorazones, 41, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboCantidadCorazones, 56, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboCantidadCorazones);
		comboCantidadCorazones.setModel(new DefaultComboBoxModel(new String[] { "2", "3", "4", "5" }));
		contentPane.add(comboCantidadCorazones);

		textField_nombreJugador = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_nombreJugador, 35, SpringLayout.SOUTH, comboCantidadCorazones);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_nombreJugador, 0, SpringLayout.EAST, comboCantidadCorazones);
		contentPane.add(textField_nombreJugador);
		textField_nombreJugador.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Ingrese nombre de jugador");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, textField_nombreJugador);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_1.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1);

		JButton botonAgregarJugador = new JButton("Agregar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonAgregarJugador, 97, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonAgregarJugador, 45, SpringLayout.EAST, textField_nombreJugador);

		ArrayList jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador(jugador));
		contentPane.add(botonAgregarJugador);

		JLabel lblNewLabel_2 = new JLabel("Indicar primer jugador de la ronda");
		lblNewLabel_2.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 51, SpringLayout.SOUTH, textField_nombreJugador);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);

		JComboBox comboListaJugadores = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboListaJugadores, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboListaJugadores, 25, SpringLayout.EAST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboListaJugadores, -196, SpringLayout.EAST, contentPane);
		contentPane.add(comboListaJugadores);

		JLabel lblNewLabel_3 = new JLabel("Sentido de ronda");
		lblNewLabel_3.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_3);

		JComboBox comboSentidoRonda = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboSentidoRonda, 44, SpringLayout.SOUTH, comboListaJugadores);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboSentidoRonda, 37, SpringLayout.EAST, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, comboSentidoRonda);
		comboSentidoRonda.setModel(new DefaultComboBoxModel(new String[] { "Horario", "Antihorario" }));
		contentPane.add(comboSentidoRonda);

		DefaultComboBoxModel combo = new DefaultComboBoxModel(new String[4]);
		comboListaJugadores.setModel(combo);
		combo.insertElementAt(jugador, jugadores.size());
		
		JFrame segundaVentana = this;
		
		botonAgregarJugador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textField_nombreJugador.getText().length() != 0) {
					if (jugadores.size() < 4) {
						jugadores.add(new Jugador(textField_nombreJugador.getText()));

						combo.insertElementAt(textField_nombreJugador.getText(), jugadores.size());

					}
					else {
						JOptionPane.showMessageDialog(segundaVentana, "Limite de jugadores alcanzado");
					}
				} else {
					JOptionPane.showMessageDialog(segundaVentana, "Campo vacio");
				}
				textField_nombreJugador.setText("");
			}
		});

		JFrame pantallaInicio = this;

		botonCrearPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				
				if (jugadores.size() > 0) {
					if ((String) comboListaJugadores.getSelectedItem() != null
							&& ((String) comboListaJugadores.getSelectedItem()).length() != 0) {

						Partida partida = new Partida(
								Integer.parseInt(comboCantidadCorazones.getSelectedItem().toString()),
								new Jugador(jugador));
						for (Object object : jugadores) {
							partida.agregarJugador((Jugador) object);
						}
						jugadores.add(new Jugador(jugador));
						
						
						partida.configurarPartida(
								(Jugador) jugadores.get(combo.getIndexOf((String) combo.getSelectedItem())-1),
								(String) comboSentidoRonda.getSelectedItem());
						pantallaInicio.setVisible(false);
						PantallaPartida pantallaPar = new PantallaPartida(partida);
					} else {
						JOptionPane.showMessageDialog(segundaVentana, "No se eligio jugador para iniciar ronda");
					}

				} else {
					JOptionPane.showMessageDialog(segundaVentana, "No se llego a la cantidad minima de jugadores");
				}
			}
		});

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
