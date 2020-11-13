package juegoTP;

import java.util.ArrayList;

import InterfazGrafica.PantallaPartida;

public class Princesa extends Carta{

	public Princesa() {
		super("Princesa", 8, "Si un jugador juega o descarta esta carta por cualquier motivo, ese jugador es eliminado de la ronda");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m, PantallaPartida pantallaPartida) {
		//jugador.setEstado("Fuera de Ronda");
	}
	
}
