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

	public void registrar(Partida partida) {
		registrar(partida);
	}

	public void registrarJugadores(ArrayList<Jugador> jugadores) {
		jugadoresActivos = jugadores;
	}

	/*
	 * Elimina de la lista de jugadores activos al perdedor
	 */
	public boolean eliminarJugador(Jugador jugador) {
		return jugadoresActivos.remove(jugador);
	}

	/*
	 * Se actualiza la ronda, es decir, esta jugando una nueva persona. El jugador
	 * realiza la jugada dentro del actualizar Si la partida solo tiene un jugador o
	 * se termino el mazo, se determina al ganador.
	 */
	public void actualizar() {

		int index = 0;

		if (jugadoresActivos.size() > 1 && mazo.getCantidadCartas() > 0) {
			for (Jugador jugador : jugadoresActivos) {
				if (turnoDeJugador == index) {

					/// si se aprico un efecto y quedo fuera un jugador se lo elimina aca
					if (jugador.getEstado() == "Fuera de Ronda") {
						eliminarJugador(jugador);
					} else {
						// deja de ser inmune cuando dio toda la vuelta
						if (jugador.getEstado() == "Inmune")
							jugador.setEstado("Jugando");

//						jugador.jugada(mazo, jugadoresActivos, descarte);
					}

					if (turnoDeJugador < jugadoresActivos.size())
						turnoDeJugador++;
					else
						turnoDeJugador = 0;
				}

				index++;
			}
		} else {
			if (jugadoresActivos.size() > 1)
				determinarGanador();
			notificar();
		}
	}

	public int getTurnoDeJugador() {
		return turnoDeJugador;
	}

	/*
	 * Elimina a los jugadores que no cumplan con la mayor cantidad de cartas
	 * tiradas, solo quedando dentro del array el jugador ganador. Luego notifica al
	 * observador que hubo un cambio en ronda
	 */
	public void determinarGanador() {
		int mayor = 0;
		// Determino si hay solo una persona con mayor fuerza de carta
		for (Jugador jugador : jugadoresActivos) {
			if (mayor < (jugador.getCartaMano().getPuntajeFuerza()))
				mayor = jugador.getCartaMano().getPuntajeFuerza();
		}

		// Elimino a los que no tienen esa carta de mayor fuerza
		for (Jugador jugador : jugadoresActivos) {
			if (mayor != (jugador.getCartaMano().getPuntajeFuerza()))
				eliminarJugador(jugador);
		}

		// Pregunto si tengo que desempatar todavia y sino busco por las cartas tiradas
		if (jugadoresActivos.size() > 1) {
			mayor = 0;
			for (Jugador jugador : jugadoresActivos) {

				if (mayor < jugador.getCartasTiradas())
					mayor = jugador.getCartasTiradas();
			}

			for (Jugador jugador : jugadoresActivos) {
				if (mayor != jugador.getCartasTiradas())
					eliminarJugador(jugador);
			}
		}
	}

	public void resetRonda() {
		for (Jugador jugador : jugadoresActivos) {
			jugador.setEstado("Jugando");
		}
		
		mazo = new Mazo();
		descarte = new Descarte();
		turnoDeJugador = 0;
	}

}