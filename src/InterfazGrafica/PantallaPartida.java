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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import juegoTP.Partida;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class PantallaPartida extends JFrame {

	private JPanel contentPane;
	private SpringLayout sl_contentPane;
	private JButton BotonCarta;
	private HashMap cartas;
	private JLabel labelRonda;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PantallaPartida(Partida partida) {
		
		this.setVisible(true);
		
		cartas = new HashMap<String,JButton>();
		
		cartas.put("Baron", new JButton("labelBaron"));
		cartas.put("Condesa", new JButton("labelCondesa"));
		cartas.put("Guardia", new JButton("labelGuardia"));
		cartas.put("Mucama", new JButton("labelMucama"));
		cartas.put("Princesa", new JButton("labelPrincesa"));
		cartas.put("Principe", new JButton("labelPrincipe"));
		cartas.put("Rey", new JButton("labelRey"));
		cartas.put("Sacerdote", new JButton("labelSacerdote"));
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Jugador 3");
		lblNewLabel.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 32, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -269, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jugador 2");
		lblNewLabel_1.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 40, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -430, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Jugador 1");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -24, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, -411, SpringLayout.EAST, contentPane);
		lblNewLabel_2.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Jugador 4");
		lblNewLabel_3.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 335, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, -10, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_3);
		
		JLabel mazo = new JLabel("mazo");
		mazo.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, mazo, 319, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, mazo, -301, SpringLayout.EAST, contentPane);
		contentPane.add(mazo);
		
		JButton botonCarta2 = new JButton("carta 2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta2, -231, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta2, -69, SpringLayout.SOUTH, contentPane);
		
		
		
		
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
        contentPane.add(botonCarta2);
        
        labelRonda = new JLabel("Ronda x");
        labelRonda.setForeground(Color.WHITE);
        sl_contentPane.putConstraint(SpringLayout.NORTH, labelRonda, 0, SpringLayout.NORTH, lblNewLabel_1);
        sl_contentPane.putConstraint(SpringLayout.WEST, labelRonda, 111, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, labelRonda, 42, SpringLayout.SOUTH, lblNewLabel_1);
        sl_contentPane.putConstraint(SpringLayout.EAST, labelRonda, -759, SpringLayout.EAST, contentPane);
        labelRonda.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(labelRonda);
        
        JButton botonCarta1 = new JButton("carta 1");
        sl_contentPane.putConstraint(SpringLayout.NORTH, botonCarta1, 434, SpringLayout.SOUTH, lblNewLabel_1);
        sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta1, 407, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCarta1, -29, SpringLayout.NORTH, lblNewLabel_2);
        sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta1, -463, SpringLayout.EAST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, botonCarta2, 38, SpringLayout.EAST, botonCarta1);
        sl_contentPane.putConstraint(SpringLayout.EAST, botonCarta2, 180, SpringLayout.EAST, botonCarta1);
        contentPane.add(botonCarta1);
        
       
        
        
        
		
		partida.setPantalla(this);
		partida.comenzarPartida();
		partida.darCarta(0);
		
		int ancho = botonCarta1.getWidth();
		int alto = botonCarta1.getHeight();
		
		 Image img = null;
			try {
				img = ImageIO.read(new File( "Imagenes\\"+(partida.deQuienEsTurno().getManoDeCartas().getMano().get(0).getNombre()+ ".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	        botonCarta1.setIcon(new ImageIcon(img));
			botonCarta1.setIcon(new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)));
	        
	        
	        Image img2 = null;
			try {
				img2 = ImageIO.read(new File( "Imagenes\\"+(partida.deQuienEsTurno().getManoDeCartas().getMano().get(1).getNombre()+ ".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			botonCarta1.setIcon(new ImageIcon(img2));
			botonCarta2.setIcon(new ImageIcon(img2.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)));
		

		
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
