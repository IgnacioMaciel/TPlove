package InterfazGrafica;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

import juegoTP.Jugador;
import juegoTP.Partida;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPartida extends JFrame {

	private JPanel contenedorPartida;
	/*private SpringLayout sl_contentPane;
	private JButton BotonCarta;
	private HashMap cartas;*/
	
	private JPanel ronda;
	private PanelJugada cartaJugada;
	public JLabel Mazo;
	
	private JLabel nombre1;
	private JLabel nombre2;
	private JLabel nombre3;
	private JLabel nombre4;
	
	private JPanel Mano1;
	private JPanel Mano2;
	private JPanel Mano3;
	private JPanel Mano4;
	
	private JPanel ocultarMano1;
	private JPanel ocultarMano2;
	private JPanel ocultarMano3;
	private JPanel ocultarMano4;
	
	private Jugador p1;
	private Jugador p2;
	private Jugador p3;
	private Jugador p4;

	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PantallaPartida(Partida partida) {
		
		this.setVisible(true);
		
		/*cartas = new HashMap<String,JButton>();
		
		cartas.put("Baron", new JButton("labelBaron"));
		cartas.put("Condesa", new JButton("labelCondesa"));
		cartas.put("Guardia", new JButton("labelGuardia"));
		cartas.put("Mucama", new JButton("labelMucama"));
		cartas.put("Princesa", new JButton("labelPrincesa"));
		cartas.put("Principe", new JButton("labelPrincipe"));
		cartas.put("Rey", new JButton("labelRey"));
		cartas.put("Sacerdote", new JButton("labelSacerdote"));*/
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contenedorPartida = new JPanel();
		contenedorPartida.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedorPartida);
		sl_contentPane = new SpringLayout();
		contenedorPartida.setLayout(sl_contentPane);
		
		JLabel LabelJugador3 = new JLabel("Jugador 3");
		LabelJugador3.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.WEST, LabelJugador3, 32, SpringLayout.WEST, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, LabelJugador3, -269, SpringLayout.SOUTH, contenedorPartida);
		contenedorPartida.add(LabelJugador3);
		
		JLabel LabelJugador2 = new JLabel("Jugador 2");
		LabelJugador2.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador2, 40, SpringLayout.NORTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador2, -430, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(LabelJugador2);
		
		JLabel LabelJugador1 = new JLabel("Jugador 1");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, LabelJugador1, -24, SpringLayout.SOUTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador1, -411, SpringLayout.EAST, contenedorPartida);
		LabelJugador1.setForeground(Color.WHITE);
		contenedorPartida.add(LabelJugador1);
		
		JLabel LabelJugador4 = new JLabel("Jugador 4");
		LabelJugador4.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, LabelJugador4, 335, SpringLayout.NORTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, LabelJugador4, -10, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(LabelJugador4);
		
		JLabel mazo = new JLabel("mazo");
		sl_contentPane.putConstraint(SpringLayout.WEST, mazo, 407, SpringLayout.WEST, contenedorPartida);
		mazo.setForeground(Color.WHITE);
		contenedorPartida.add(mazo);
		
		JButton botonCarta2 = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2, -31, SpringLayout.NORTH, LabelJugador1);
		botonCarta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		try {
            FondoPartida fondo = new FondoPartida(ImageIO.read(new File("Imagenes\\fondo.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            
            
            
            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
		
		botonCarta2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		if (arg0.getClickCount() == 2) {
//        			partida.getJugador
                }
               
        	}
        });
        contenedorPartida.add(botonCarta2);
        
        labelRonda = new JLabel("Ronda x");
        sl_contentPane.putConstraint(SpringLayout.NORTH, labelRonda, 0, SpringLayout.NORTH, LabelJugador2);
        sl_contentPane.putConstraint(SpringLayout.WEST, labelRonda, 111, SpringLayout.WEST, contenedorPartida);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, labelRonda, 42, SpringLayout.SOUTH, LabelJugador2);
        labelRonda.setForeground(Color.WHITE);
        labelRonda.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contenedorPartida.add(labelRonda);
        
        JButton botonCarta1 = new JButton("");
        sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2, 38, SpringLayout.EAST, botonCarta1);
        sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta2, 180, SpringLayout.EAST, botonCarta1);
        sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1, 407, SpringLayout.WEST, contenedorPartida);
        sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta1, 545, SpringLayout.WEST, contenedorPartida);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1, -29, SpringLayout.NORTH, LabelJugador1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1, -203, SpringLayout.NORTH, LabelJugador1);
        botonCarta1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        contenedorPartida.add(botonCarta1);
        
        JButton botonCarta3 = new JButton("carta 3");
        sl_contentPane.putConstraint(SpringLayout.EAST, labelRonda, -158, SpringLayout.WEST, botonCarta3);
        sl_contentPane.putConstraint(SpringLayout.NORTH, mazo, 39, SpringLayout.SOUTH, botonCarta3);
        sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta3, 407, SpringLayout.WEST, contenedorPartida);
        sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta3, 545, SpringLayout.WEST, contenedorPartida);
        sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta3, 6, SpringLayout.SOUTH, LabelJugador2);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta3, 178, SpringLayout.SOUTH, LabelJugador2);
		botonCarta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contenedorPartida.add(botonCarta3);
		
		JButton botonCarta4 = new JButton("carta 4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2, 256, SpringLayout.SOUTH, botonCarta4);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta4, 38, SpringLayout.EAST, botonCarta3);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta4, -283, SpringLayout.EAST, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta4, 60, SpringLayout.NORTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta4, 232, SpringLayout.NORTH, contenedorPartida);
		botonCarta4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contenedorPartida.add(botonCarta4);
        
       
        
        
        
		
		partida.setPantalla(this);
		partida.comenzarPartida();
		partida.darCarta(0);
		
		//int ancho = botonCarta1.getWidth();
		//int alto = botonCarta1.getHeight();
		
		 Image img = null;
			try {
				img = ImageIO.read(new File( "Imagenes\\"+(partida.deQuienEsTurno().getManoDeCartas().getMano().get(0).getNombre()+ ".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        botonCarta1.setIcon(new ImageIcon(img));
	        //botonCarta1.setIcon(new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)));
	        
	        
	        Image img2 = null;
			try {
				img2 = ImageIO.read(new File( "Imagenes\\"+(partida.deQuienEsTurno().getManoDeCartas().getMano().get(1).getNombre()+ ".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			botonCarta2.setIcon(new ImageIcon(img2));
			//botonCarta2.setIcon(new ImageIcon(img2.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)));
			
			
			
			JLabel Mazo = new JLabel("");
			Mazo.setIcon(new ImageIcon("C:\\Users\\Lucas\\Documents\\GitHub\\TPlove\\Imagenes\\Mazo1.png"));
			sl_contentPane.putConstraint(SpringLayout.NORTH, Mazo, 6, SpringLayout.SOUTH, mazo);
			sl_contentPane.putConstraint(SpringLayout.WEST, Mazo, 399, SpringLayout.WEST, contenedorPartida);
			contenedorPartida.add(Mazo);
			
			
		
	}
	
	public void mostrarCartaJugador1(JButton carta ) {
		
	}
	
	public void mostrarRonda(String nroRonda) throws InterruptedException {
		labelRonda.setText(nroRonda);

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
