package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends Observador {

	private String nombre, estado; // Jugando - Fuera de Ronda - Perdedor - Inmune
	private int puntaje;
	private Mano manoDeCartas;
	boolean esAdmin;
	int cartasTiradas;
	Partida partidaJuego;

	public Jugador(String nombre) {
		this.nombre = nombre;
		estado = "Jugando";
		puntaje = 0;
		manoDeCartas = new Mano();
		esAdmin = false;
		cartasTiradas = 0;
		partidaJuego = null;
	}


	public boolean agarrarCarta(Mazo mazo) {
		Carta cartaAsignada = mazo.asignarCarta();
		if (cartaAsignada != null) {
			asignarCarta(cartaAsignada);
			return true;
		}
		return false;
	}// Agarrar carte debe recibir por parametro una carta, entonces busco en mazo la
		// que esta arriba de todo, y la
		/// retorno a partir del metodo asignar carta

	public void asignarCarta(Carta c) {
		manoDeCartas.agarrarCarta(c);
	}

	public void descarto(Descarte d, Mazo m) {
		Carta c = this.manoDeCartas.sacarCarta(0);
		d.agregarCarta(c);
		cartasTiradas++;
		if (c.getPuntajeFuerza() == 9)
			this.setEstado("Fuera de Ronda");

		else if (m.getCantidadCartas() > 0)
			this.manoDeCartas.agarrarCarta(m.asignarCarta());

	}

	public String getNombre() {
		return nombre;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setPuntaje(int n) {
		this.puntaje += n;
	}

	public int getPuntaje() {
		return this.puntaje;
	}

	public void rendirse() {
		setEstado("Perdedor");
	}

	public boolean esAdminONo() {
		return this.esAdmin;
	}

	public int setCantidadDeSimbolos() {
		Scanner escriboSimbolos = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de simbolos necesarias para ganar la partida: ");
		int simbolos;
		do {
			simbolos = escriboSimbolos.nextInt();
		} while (simbolos < 1 && simbolos > 15);
		return simbolos;
	}

	public void resetCantCartasTiradas() {
		cartasTiradas = 0;
	}

	public Carta getCartaMano() {
		return manoDeCartas.sacarCarta(0);
		/// ESTE METODO SE PENSO PARA COMPARAR AL FINAL DE LA RONDA LA FUERZA DE LAS
		/// CARTAS
	}

	public Mano getManoDeCartas() {
		return manoDeCartas;
		/// ESTE METODO DEVUELVE LA MANO DEL JUGADOR PARA DESCARTAR Y AGARRAR UNA CARTA
		/// MEDIANTE EFECTO DEL PRINCIPE
	}

	public Carta getReferenciaCarta() {
		return this.manoDeCartas.getReferencia();
	}

	/*
	 * Se agrego el get porque necesitabamos saber desde ronda la cantidad de cartas
	 * que tiro cada jugador para desempatar
	 */
	public int getCartasTiradas() {
		return cartasTiradas;
	}

	public void verCarta(Carta c) {
		System.out.println(c);
	}

	/// Se agregan los metodos para que puedan cambiarse el puntaje desde ronda, u
	// no no hace nada porque notifica a partido
	@Override
	public void notificarse() {
		// TODO Auto-generated method stub
		// nada de nada
	}

	/// Ronda avisa a jugador que debe cambiar su valor
	@Override
	public void notificarseJugador(Jugador jugador) {
		jugador.setPuntaje(1);
	}

	public void setCarta(Carta cartaMano) {
		this.manoDeCartas.agarrarCarta(cartaMano);
	}

	public String getInfoCarta() {
		return manoDeCartas.toString();
	}

	public int getFuerzaCarta() {
		return this.manoDeCartas.getCartaEn(0).getPuntajeFuerza();
	}

	public void sumarUnDesc() {
		this.cartasTiradas++;

	}

	public void sumarTiradas() {
		cartasTiradas++;

	}

//	public void seleccionarSala() {
//		
//	}
///////////////////////////////////////////////////////////////// FIN COMMENT 1# ESTOS METODOS LOS VA A EJECUTAR
////UN JUGADOR QUE ES ADMIN APRA CONFIGURAR LA PARTIDA, AL MOMENTO QUE CREA UNA SALA

}
