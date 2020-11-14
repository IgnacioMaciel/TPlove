package juegoTP;

import java.util.ArrayList;

import InterfazGrafica.PantallaPartida;

public class Mucama extends Carta{

	public Mucama() {
		super("Mucama", 4, "El jugador está protegido y no puede ser afectado por cartas de otros jugadores hasta su siguiente turno");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m,
			PantallaPartida pantallaPartida){
		
		jugador.setEstado("Inmune");	///SOLAMENTE SETEA EL ESTADO A INMUNE POR 1 RONDA
		///FALTA MANEJAR EL TEMA DE RONDAS
		return ;
	}
	
	@Override
	public String getDescripcion() {
		return super.getDescripcion();
	}
}
