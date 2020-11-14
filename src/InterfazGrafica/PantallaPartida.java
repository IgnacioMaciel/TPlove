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
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import juegoTP.Carta;
import juegoTP.Descarte;
import juegoTP.Jugador;
import juegoTP.Mazo;
import juegoTP.Partida;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Dimension;

public class PantallaPartida extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3078354589235509430L;
	
	private JPanel contenedorPartida;
	private SpringLayout sl_contentPane;
	
	private JLabel ronda;
	private int turno=0;
	private int numRonda=0;
	private JButton cartaJugada;
	private JLabel MazoLabel;
	
	private JLabel nombre1;
	private JLabel nombre2;
	private JLabel nombre3;
	private JLabel nombre4;
	
	private JButton cartaVisible1;
	private JButton cartaVisible2;
	private JButton cartaVisible3;
	private JButton cartaVisible4;
	private JButton cartaVisible5;
	private JButton cartaVisible6;
	private JButton cartaVisible7;
	private JButton cartaVisible8;
	
	private JPanel cartaOculta1;
	private JPanel cartaOculta2;
	private JPanel cartaOculta3;
	private JPanel cartaOculta4;
	
	private Jugador p1;
	private Jugador p2;
	private Jugador p3;
	private Jugador p4;
	
	public JPanel getContenedorPartida() {
		return contenedorPartida;
	}

	public void setContenedorPartida(JPanel contenedorPartida) {
		this.contenedorPartida = contenedorPartida;
	}

	public SpringLayout getSl_contentPane() {
		return sl_contentPane;
	}

	public void setSl_contentPane(SpringLayout sl_contentPane) {
		this.sl_contentPane = sl_contentPane;
	}

	public JLabel getRonda() {
		return ronda;
	}

	public void setRonda(JLabel ronda) {
		this.ronda = ronda;
	}

	public JButton getCartaJugada() {
		return cartaJugada;
	}

	public void setCartaJugada(JButton cartaJugada) {
		this.cartaJugada = cartaJugada;
	}

	public JLabel getMazoLabel() {
		return MazoLabel;
	}

	public void setMazoLabel(JLabel mazoLabel) {
		MazoLabel = mazoLabel;
	}

	public JLabel getNombre1() {
		return nombre1;
	}

	public void setNombre1(JLabel nombre1) {
		this.nombre1 = nombre1;
	}

	public JLabel getNombre2() {
		return nombre2;
	}

	public void setNombre2(JLabel nombre2) {
		this.nombre2 = nombre2;
	}

	public JLabel getNombre3() {
		return nombre3;
	}

	public void setNombre3(JLabel nombre3) {
		this.nombre3 = nombre3;
	}

	public JLabel getNombre4() {
		return nombre4;
	}

	public void setNombre4(JLabel nombre4) {
		this.nombre4 = nombre4;
	}

	public JButton getCartaVisible1() {
		return cartaVisible1;
	}

	public void setCartaVisible1(JButton cartaVisible1) {
		this.cartaVisible1 = cartaVisible1;
	}

	public JButton getCartaVisible2() {
		return cartaVisible2;
	}

	public void setCartaVisible2(JButton cartaVisible2) {
		this.cartaVisible2 = cartaVisible2;
	}

	public JButton getCartaVisible3() {
		return cartaVisible3;
	}

	public void setCartaVisible3(JButton cartaVisible3) {
		this.cartaVisible3 = cartaVisible3;
	}

	public JButton getCartaVisible4() {
		return cartaVisible4;
	}

	public void setCartaVisible4(JButton cartaVisible4) {
		this.cartaVisible4 = cartaVisible4;
	}

	public JButton getCartaVisible5() {
		return cartaVisible5;
	}

	public void setCartaVisible5(JButton cartaVisible5) {
		this.cartaVisible5 = cartaVisible5;
	}

	public JButton getCartaVisible6() {
		return cartaVisible6;
	}

	public void setCartaVisible6(JButton cartaVisible6) {
		this.cartaVisible6 = cartaVisible6;
	}

	public JButton getCartaVisible7() {
		return cartaVisible7;
	}

	public void setCartaVisible7(JButton cartaVisible7) {
		this.cartaVisible7 = cartaVisible7;
	}

	public JButton getCartaVisible8() {
		return cartaVisible8;
	}

	public void setCartaVisible8(JButton cartaVisible8) {
		this.cartaVisible8 = cartaVisible8;
	}

	public JPanel getCartaOculta1() {
		return cartaOculta1;
	}

	public void setCartaOculta1(JPanel cartaOculta1) {
		this.cartaOculta1 = cartaOculta1;
	}

	public JPanel getCartaOculta2() {
		return cartaOculta2;
	}

	public void setCartaOculta2(JPanel cartaOculta2) {
		this.cartaOculta2 = cartaOculta2;
	}

	public JPanel getCartaOculta3() {
		return cartaOculta3;
	}

	public void setCartaOculta3(JPanel cartaOculta3) {
		this.cartaOculta3 = cartaOculta3;
	}

	public JPanel getCartaOculta4() {
		return cartaOculta4;
	}

	public void setCartaOculta4(JPanel cartaOculta4) {
		this.cartaOculta4 = cartaOculta4;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getNumRonda() {
		return numRonda;
	}

	public void setNumRonda(int numRonda) {
		this.numRonda = numRonda;
	}

	public Jugador getP1() {
		return p1;
	}

	public void setP1(Jugador p1) {
		this.p1 = p1;
	}

	public Jugador getP2() {
		return p2;
	}

	public void setP2(Jugador p2) {
		this.p2 = p2;
	}

	public Jugador getP3() {
		return p3;
	}

	public void setP3(Jugador p3) {
		this.p3 = p3;
	}

	public Jugador getP4() {
		return p4;
	}

	public void setP4(Jugador p4) {
		this.p4 = p4;
	}
	
	public PantallaPartida(ArrayList<Jugador> jugadores, Partida partida) {
		
		getContentPane().setLayout(null);
		
		if(jugadores.get(0) != null) {
			
			p1 = jugadores.get(0);
			
			if(jugadores.get(1) != null){
				
				p2 = jugadores.get(1);
				
				/*if(jugadores.get(2) != null){
					
					p3 = jugadores.get(2);
					
					if(jugadores.get(3) != null){
						
						p4 = jugadores.get(3);
					}
				}*/
			}
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contenedorPartida = new JPanel();
		contenedorPartida.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedorPartida);
		sl_contentPane = new SpringLayout();
		contenedorPartida.setLayout(sl_contentPane);
		
		nombre1 = new JLabel(p1.getNombre());
		nombre1.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nombre1, 0, SpringLayout.SOUTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, nombre1, -642, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(nombre1);
		
		nombre2 = new JLabel(p2.getNombre());
		nombre2.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nombre2, 0, SpringLayout.NORTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, nombre2, 0, SpringLayout.EAST, nombre1);
		contenedorPartida.add(nombre2);
		
		cartaVisible1 = new JButton("cartaVisible1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaVisible1, -186, SpringLayout.NORTH, nombre1);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaVisible1, 560, SpringLayout.WEST, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaVisible1, -21, SpringLayout.NORTH, nombre1);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible1, 670, SpringLayout.WEST, contenedorPartida);
		contenedorPartida.add(cartaVisible1);
		
		cartaVisible2 = new JButton("cartaVisible2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaVisible2, 0, SpringLayout.NORTH, cartaVisible1);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaVisible2, 11, SpringLayout.EAST, cartaVisible1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaVisible2, -21, SpringLayout.NORTH, nombre1);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible2, -553, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(cartaVisible2);
		
		cartaVisible3 = new JButton("cartaVisible3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaVisible3, 6, SpringLayout.SOUTH, nombre2);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaVisible3, 560, SpringLayout.WEST, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaVisible3, -499, SpringLayout.SOUTH, cartaVisible1);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible3, -670, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(cartaVisible3);
		
		cartaVisible4 = new JButton("cartaVisible4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaVisible4, 6, SpringLayout.SOUTH, nombre2);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaVisible4, 11, SpringLayout.EAST, cartaVisible3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaVisible4, -334, SpringLayout.NORTH, cartaVisible2);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible4, -549, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(cartaVisible4);
		
		cartaJugada = new JButton("cartaJugada");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaJugada, 80, SpringLayout.SOUTH, cartaVisible3);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaJugada, 619, SpringLayout.WEST, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaJugada, -89, SpringLayout.NORTH, cartaVisible1);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaJugada, -610, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(cartaJugada);
		
		numRonda=1;
		
		ronda = new JLabel("Ronda");
		ronda.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, ronda, 41, SpringLayout.NORTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.WEST, ronda, 256, SpringLayout.WEST, contenedorPartida);
		contenedorPartida.add(ronda);
		
		FondoPartida fondo;
		try {
			fondo = new FondoPartida(ImageIO.read(new File("Imagenes\\fondo.jpg")));
			JPanel panel = (JPanel) this.getContentPane();
	        panel.setBorder(fondo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setVisible(true);

		while(partida.hayGanador() == null) { //no haya ganador de partida
			
			turno=0;
			int opc=0;
			Mazo mazo = new Mazo();
			Jugador jug = null;
			
			partida.empezarJuego(jugadores, mazo, this);

			while(partida.hayGanadorDeRonda() == null) {	//no haya ganador de ronda
				
				int numJugador = turno%jugadores.size();
				jug = jugadores.get(numJugador);
				
				if(jug.getEstado() == "Inmune") {
					jug.setEstado("Jugando");
					
					JOptionPane.showMessageDialog(this, "El jugador " + jug.getNombre() + " ya no tiene inmunidad!");
				}
				
				
				if(jug.getEstado() != "Fuera de Ronda") {
					
					jug.agarrarCarta(mazo, this);
					this.actualizarPantalla(numJugador, jug);
					
					if(jug.getManoDeCartas().getMano().get(0).getNombre() == "Condesa" && (jug.getManoDeCartas().getMano().get(1).getNombre() == "Rey" || jug.getManoDeCartas().getMano().get(1).getNombre() == "Principe")
							|| (jug.getManoDeCartas().getMano().get(0).getNombre() == "Rey" || jug.getManoDeCartas().getMano().get(0).getNombre() == "Principe") && jug.getManoDeCartas().getMano().get(1).getNombre() == "Condesa") {
						
						Carta c1 = jug.getManoDeCartas().getMano().get(0);
						Carta c2 = jug.getManoDeCartas().getMano().get(1);
						
						if(c1.getNombre() == "Condesa") {
							opc=0;
						}
						else {
							opc=1;
						}
						
						JOptionPane.showMessageDialog(this, "La condesa no es compatible con el Rey y el Principe, despidete de ella!");
					}
					else {
						Object[] opciones = {jug.getManoDeCartas().getMano().get(0).getNombre(),jug.getManoDeCartas().getMano().get(1).getNombre()};
						opc = JOptionPane.showOptionDialog(this, "Elija 1 carta para jugar","Jugador: " + jug.getNombre(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones, opciones[1]);
					}
					
					if(opc == 0) {
						jug.jugarCartaEnCampo(numJugador,jugadores, mazo, this, jug, 0);
					}
					else{
						jug.jugarCartaEnCampo(numJugador,jugadores, mazo, this, jug, 1);
					}				
					
					this.ocultarCartasJugador(numJugador, jug);
				}
				
				turno++;
			}
			
			partida.hayGanadorDeRonda().sumarCorazon();
			
			for (Jugador jugador : jugadores) {
				jugador.setEstado("Jugando");
			}
			
			
		}
			
		
		JOptionPane.showMessageDialog(this, "El ganador del juego es: " + partida.hayGanador().getNombre() + "\nFelicitaciones!");
		
	}
	
	private void actualizarPantalla(int numJugador, Jugador jug) {
		
		Carta uno = jug.getManoDeCartas().getMano().get(0);
		Carta dos = jug.getManoDeCartas().getMano().get(1);
		
		Image img1 = null;
		try {
			img1 = ImageIO.read(new File( "Imagenes\\"+uno.getNombre()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image img2 = null;
		try {
			img2 = ImageIO.read(new File( "Imagenes\\"+dos.getNombre()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(numJugador == 0) {
			this.cartaVisible1.setIcon(new ImageIcon(img1));
			this.cartaVisible1.setVisible(true);
			this.cartaVisible2.setIcon(new ImageIcon(img2));
			this.cartaVisible2.setVisible(true);
		}
		else if(numJugador == 1) {
			this.cartaVisible3.setIcon(new ImageIcon(img1));
			this.cartaVisible3.setVisible(true);
			this.cartaVisible4.setIcon(new ImageIcon(img2));
			this.cartaVisible4.setVisible(true);
		}
		else if(numJugador == 2) {
			this.cartaVisible5.setIcon(new ImageIcon(img1));
			this.cartaVisible5.setVisible(true);
			this.cartaVisible6.setIcon(new ImageIcon(img2));
			this.cartaVisible6.setVisible(true);
		}
		else if(numJugador == 3) {
			this.cartaVisible7.setIcon(new ImageIcon(img1));
			this.cartaVisible7.setVisible(true);
			this.cartaVisible8.setIcon(new ImageIcon(img2));
			this.cartaVisible8.setVisible(true);
		}
		
	}

	public void ocultarCartasJugador(int numJugador, Jugador jug) {
	
		Image img1 = null;
		try {
			img1 = ImageIO.read(new File( "Imagenes\\mazo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image img2 = null;
		try {
			img2 = ImageIO.read(new File( "Imagenes\\mazo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(numJugador == 0) {
			this.cartaVisible1.setIcon(new ImageIcon(img1));
			this.cartaVisible2.setIcon(new ImageIcon(img2));
		}
		
		if(numJugador == 1) {
			this.cartaVisible3.setIcon(new ImageIcon(img1));
			this.cartaVisible4.setIcon(new ImageIcon(img2));
		}
		
		if(numJugador == 2) {
			this.cartaVisible5.setIcon(new ImageIcon(img1));
			this.cartaVisible6.setIcon(new ImageIcon(img2));
		}
		
		if(numJugador == 3) {
			this.cartaVisible7.setIcon(new ImageIcon(img1));
			this.cartaVisible8.setIcon(new ImageIcon(img2));
		}
	}
	
	public void mostrarRonda(String nroRonda) throws InterruptedException {
		//labelRonda.setText(nroRonda);

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
