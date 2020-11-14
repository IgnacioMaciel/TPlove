package juegoTP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;

import InterfazGrafica.PantallaPartida;

public class Partida extends Observador {
	private ArrayList<Jugador> jugadores;
	private int simbolosParaGanar;
	private Ronda ronda;
	private PantallaPartida pantallaPartida = null;
	int nroRonda;
	private Jugador creador;
	private Jugador ganador;
	

	/*
	 * Constructor de la clase partido
	 */
	public Partida(int victoriasNecesarias, Jugador jugadorCreador) {
		jugadores = new ArrayList<Jugador>();
		// rondas = new ArrayList<Ronda>();
		simbolosParaGanar = victoriasNecesarias;
		creador=jugadorCreador;
		nroRonda = 1;
		ganador = null;
	}
	
	public Ronda getRonda() {
		return ronda;
	}
	

	public void eliminarJugador(Jugador j) {
		if (this.jugadores.contains(j))
			this.jugadores.remove(jugadores.indexOf(j));

	}
	
	public ArrayList<Jugador> getJugadores(){
		return jugadores;
	}


	public void configurarPartida(Jugador primero, String sentido) { // true -> horario, false -> antihorario
		if (sentido.compareTo("Antihorario") == 0) {
			Collections.reverse(jugadores);
		}
		int i = 0;
		
		
		while (jugadores.size() > i && primero.getNombre().compareTo(jugadores.get(i).getNombre()) != 0) {
			i++;
		}
		jugadores.add(0, jugadores.remove(i));
		
		ronda = new Ronda(jugadores);
	}

	public void setPantalla(PantallaPartida pant) {
		pantallaPartida = pant;
	}

	public Jugador hayGanador() {

		for (Jugador jugador : jugadores) {
			if (jugador.getPuntaje() == simbolosParaGanar)
				return jugador;
		}
		return null;
	}


	public boolean agregarJugador(Jugador jugador) {

		if (jugadores.size() < 4)
			jugadores.add(jugador);
		else {
			System.out.println("Se alcanzo la capacida maxima de jugadores");
			return false;
		}

		return true;
	}

	/*
	 * Metodo que finalizara la partida
	 */
	public void finalizarPartida(Jugador jugador) {
		System.out.println("Es el ganador el jugador: " + jugador.getNombre());
	}

	public int getCantJugadores() {
		return jugadores.size();
	}

	public void comenzarPartida() {
		
		
		for (Jugador jugador : jugadores) {
			jugador.getManoDeCartas().agarrarCarta(this.ronda.getMazo().asignarCarta());
		}
		
		try {
			this.pantallaPartida.mostrarRonda(nroRonda);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		


	
	public void darCarta(int n) {
		jugadores.get(n).getManoDeCartas().agarrarCarta(ronda.getMazo().asignarCarta());
	}

	public int getNroRonda() {
		return nroRonda;
	}

	@Override
	public void notificarse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void notificarseJugador(Jugador jugador) {
		// TODO Auto-generated method stub

	}

	public boolean verificarFinPartida() {
		for (Jugador jugador : jugadores) {
			if(jugador.getPuntaje()==simbolosParaGanar) {
				ganador = jugador;
				return true;
			}
		}
		return false;
	}

	public Jugador getGanador() {
		return ganador;
	}

	public void setNroRonda(int i) {
		nroRonda+=i;
		
	}
}