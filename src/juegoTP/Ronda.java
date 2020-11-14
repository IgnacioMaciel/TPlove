package juegoTP;

import java.util.ArrayList;

public class Ronda extends Observable {
	private ArrayList<Jugador> jugadoresActivos;
	private int turnoDeJugador;
	private int finRonda;
	private Mazo mazo;
	private Descarte descarte;
	private Jugador ganador;

	/*
	 * Inicializa la ronda con la lista de jugadores proveniente del partido, el
	 * jugador que empieza la ronda y una instancia de Mazo.
	 */
	public Ronda(ArrayList<Jugador> jugadores) {
		this.jugadoresActivos = new ArrayList<Jugador>(jugadores);
		turnoDeJugador = 0;
		finRonda = jugadores.size();
		mazo = new Mazo();
		descarte = new Descarte();
		ganador = null;
	}

	public boolean verificarFinDeRonda() {

		ArrayList<Jugador> jugadoresElegibles = new ArrayList<Jugador>();
		int cartaMayorValor = 0;

		for (Jugador jug : jugadoresActivos) { /// METE EN UN VECTOR A LOS JUGADORES SELECCIONABLES

			if (jug.getEstado().compareTo("Jugando") == 0 || jug.getEstado().compareTo("Inmune") == 0) {

				jugadoresElegibles.add(jug);
			}
		}

		if (jugadoresElegibles.size() == 1) {
			jugadoresElegibles.get(0).setPuntaje(1);
			ganador = jugadoresElegibles.get(0);
			return true;
		} else {
			if (mazo.getCantidadCartas() == 0) {
				
				for(Jugador jug : jugadoresActivos) {
					if(jug.getManoDeCartas().getCarta(0).getPuntajeFuerza() >= cartaMayorValor) {
						cartaMayorValor= jug.getManoDeCartas().getCarta(0).getPuntajeFuerza();
						jugadoresElegibles.add(jug);
					}
				}
				if(jugadoresElegibles.size()==1) {
					jugadoresElegibles.get(0).setPuntaje(1);
					ganador = jugadoresElegibles.get(0);
				}else {
					int mayorCartasTiradas = 0;
					Jugador ganadorRonda= null;
					for (Jugador jugador : jugadoresElegibles) {
						if(jugador.getCartasTiradas() >= cartaMayorValor) {
							cartaMayorValor= jugador.getCartasTiradas();
							ganadorRonda = jugador;
						}
					}
					ganadorRonda.setPuntaje(1);
					ganador = ganadorRonda;
				}
				
				return true;
			}
		}
		return false;
	}

	public Jugador getGanador() {
		return ganador;
	}

	public void pasarTurno() {
		if (turnoDeJugador == finRonda - 1)
			turnoDeJugador = 0;
		else
			turnoDeJugador++;
	}

	public Mazo getMazo() {
		return mazo;
	}

	public Descarte getDescarte() {
		return descarte;
	}
	
	public void resetRonda() {
		for (Jugador jugador : jugadoresActivos) {
			jugador.setEstado("Jugando");
			jugador.resetCantCartasTiradas();
		}
		
		mazo = new Mazo();
		descarte = new Descarte();
		turnoDeJugador = 0;
	}
	
	public int getTurnoDeJugador() {
		return turnoDeJugador;
	}

}