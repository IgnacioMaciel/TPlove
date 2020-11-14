package juegoTP;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import InterfazGrafica.PantallaPartida;

public class Principe extends Carta {

	public Principe() {
		super("Principe", 5,
				"El jugador elige otro jugador (incluso a sí mismo) para descartar su mano y robar una carta nueva. Si la Princesa es descartada de esta manera, el jugador que la descartó es eliminado de la ronda");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m,
			PantallaPartida pantallaPartida) {

		ArrayList<Jugador> jugadoresElegibles = new ArrayList<Jugador>();

		for (Jugador jug : listaJugadores) {
			if (jug.getEstado().compareTo("Jugando") == 0) {
				jugadoresElegibles.add(jug);
			}
		}

		Object[] opciones = new String[jugadoresElegibles.size()];

		int i = 0;

		for (Jugador jug : jugadoresElegibles) {
			opciones[i] = jugadoresElegibles.get(i).getNombre();
			i++;
		}

		JComboBox combo = new JComboBox(opciones);

		JOptionPane.showMessageDialog(null, combo, "A quien deseas elegir?", JOptionPane.QUESTION_MESSAGE);

		int numJugadorElegido = combo.getSelectedIndex();

		String nombreJugadorElegido = (String) opciones[numJugadorElegido];

		Jugador jugadorElegido = null;

		for (Jugador jug : listaJugadores) {
			if (jug.getNombre() == nombreJugadorElegido) {
				jugadorElegido = jug;
			}
		}

		int numJugador = 0;

		if (m.getCantidadCartas() != 0) {

			if (jugadorElegido.getNombre().compareTo(jugador.getNombre()) != 0) {
				JOptionPane.showMessageDialog(pantallaPartida, "El jugador " + jugadorElegido.getNombre()
						+ " descarta la carta " + jugadorElegido.getManoDeCartas().getMano().get(0).getNombre());
				if (jugadorElegido.getCartaMano().getNombre().compareTo("Princesa") == 0) {
					JOptionPane.showMessageDialog(pantallaPartida,
							"El jugador " + jugadorElegido.getNombre() + " quedo Fuera de Ronda!");
					jugadorElegido.setEstado("Fuera de Ronda");
				} else {
					jugadorElegido.agarrarCarta(m);
				}
			} else {
				if (jugadorElegido.getManoDeCartas().getCarta(1).getNombre().compareTo("Principe") == 0) {

					JOptionPane.showMessageDialog(pantallaPartida, "El jugador " + jugadorElegido.getNombre()
							+ " descarta la carta " + jugadorElegido.getManoDeCartas().getMano().get(1).getNombre());
					if (jugadorElegido.getManoDeCartas().sacarCarta(1).getNombre().compareTo("Princesa") == 0) {
						JOptionPane.showMessageDialog(pantallaPartida,
								"El jugador " + jugadorElegido.getNombre() + " quedo Fuera de Ronda!");
						jugadorElegido.setEstado("Fuera de Ronda");
					} else {
						JOptionPane.showMessageDialog(pantallaPartida,
								"El jugador " + jugadorElegido.getNombre() + " agarro una nueva carta");
						jugadorElegido.agarrarCarta(m);
					}
				} else {
					JOptionPane.showMessageDialog(pantallaPartida, "El jugador " + jugadorElegido.getNombre()
							+ " descarta la carta " + jugadorElegido.getManoDeCartas().getMano().get(0).getNombre());
					if (jugadorElegido.getManoDeCartas().sacarCarta(0).getNombre().compareTo("Princesa") == 0) {
						JOptionPane.showMessageDialog(pantallaPartida,
								"El jugador " + jugadorElegido.getNombre() + " quedo Fuera de Ronda!");
						jugadorElegido.setEstado("Fuera de Ronda");
					} else {
						JOptionPane.showMessageDialog(pantallaPartida,
								"El jugador " + jugadorElegido.getNombre() + " agarro una nueva carta");
						jugadorElegido.agarrarCarta(m);
					}
				}
			}
		} else

		{
			JOptionPane.showMessageDialog(pantallaPartida, "El Mazo esta Vacio.");
		}
	}

	@Override
	public String getDescripcion() {
		return super.getDescripcion();
	}

}
