package juegoTP;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import InterfazGrafica.PantallaPartida;

public class Principe extends Carta{

	public Principe() {
		super("Principe", 5, "El jugador elige otro jugador (incluso a sí mismo) para descartar su mano y robar una carta nueva. Si la Princesa es descartada de esta manera, el jugador que la descartó es eliminado de la ronda");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m, PantallaPartida pantallaPartida) {
		
		ArrayList<Jugador> jugadoresElegibles = new ArrayList<Jugador>();

		for (Jugador jug : listaJugadores) { 
			if (jug.getEstado().compareTo("Jugando") == 0) {
				jugadoresElegibles.add(jug);
			}
		}
		
		Object[] opciones = new String[jugadoresElegibles.size()];

		int i=0;

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
		
		int numJugador=0;
		
		if( !m.getMazoVacio()) {
			
			numJugador = pantallaPartida.getTurno() % listaJugadores.size();
			Jugador jug = listaJugadores.get(numJugador);
			
			JOptionPane.showMessageDialog(pantallaPartida, "El jugador " + jugadorElegido.getNombre() + " descarta la carta " + jug.getManoDeCartas().getMano().get(0).getNombre());
			
			jug.jugarCartaEnCampo(numJugador,listaJugadores, m, pantallaPartida, jug, 0);

			jugadorElegido.agarrarCarta(m);
			
			Carta card = jugadorElegido.getManoDeCartas().getMano().get(0);
		
			Image img = null;
			try {
				img = ImageIO.read(new File( "Imagenes\\"+card.getNombre()+ ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(numJugador == 0) {
				pantallaPartida.getCartaVisible1().setIcon(new ImageIcon(img));
				pantallaPartida.getCartaVisible1().setVisible(true);
			}
			else if(numJugador == 1) {
				pantallaPartida.getCartaVisible3().setIcon(new ImageIcon(img));
				pantallaPartida.getCartaVisible3().setVisible(true);
			}
			else if(numJugador == 2) {
				pantallaPartida.getCartaVisible5().setIcon(new ImageIcon(img));
				pantallaPartida.getCartaVisible5().setVisible(true);
			}
			else if(numJugador == 3) {
				pantallaPartida.getCartaVisible7().setIcon(new ImageIcon(img));
				pantallaPartida.getCartaVisible7().setVisible(true);
			}
			
			JOptionPane.showMessageDialog(pantallaPartida, "El jugador " + jugadorElegido.getNombre() + " agarro una nueva carta");
			
			pantallaPartida.ocultarCartasJugador(numJugador, jug);
		}
		else {
			JOptionPane.showMessageDialog(pantallaPartida, "El Mazo esta Vacio.");
		}
		
	}

}
