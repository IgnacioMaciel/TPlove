package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PantallaError extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PantallaError(String e) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
	    contentPane.setLayout(sl_contentPane);
	    
	    JLabel laberError = new JLabel("New label");
	    sl_contentPane.putConstraint(SpringLayout.NORTH, laberError, 43, SpringLayout.NORTH, contentPane);
	    sl_contentPane.putConstraint(SpringLayout.WEST, laberError, 237, SpringLayout.WEST, contentPane);
	    contentPane.add(laberError);
	    
	    laberError.setText(e);
	    this.setVisible(true);
	}

}
