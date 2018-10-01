import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VisualiseurDeFormes extends JFrame 
{
	private Random m_random;
	
	private Vector m_formes;
	
	private ZoneDeDessin m_panneau_dessin;
	
	private JPanel m_panneau_boutons;
	
	class BoutonCercleAction implements ActionListener
	{
		private VisualiseurDeFormes m_visualiseur;

		BoutonCercleAction( VisualiseurDeFormes visu )
		{
			m_visualiseur = visu;
		 }
		 
		public void actionPerformed( ActionEvent e)
		{
			Random r = m_visualiseur.getRandom();
			Cercle c = new Cercle(
				r.nextInt( 200 ),
				r.nextInt( 200 ),
			    r.nextInt( 40 )+ 20 );
			m_visualiseur.getFormes().add( c );
			m_visualiseur.repaint();
		}
	}
	
	public VisualiseurDeFormes()
	{
		super( "Mon joli visualiseur" );
		m_formes = new Vector();
		m_random = new Random();
		setPreferredSize( new Dimension( 400, 300 ) );
		setLayout( new BorderLayout() );
		m_panneau_dessin = new ZoneDeDessin();
		m_panneau_dessin.setFormes( m_formes );
		m_panneau_boutons = new JPanel();
		JLabel label = new JLabel("Visualiseur de Formes");
		getContentPane().add( label, BorderLayout.NORTH );
		getContentPane().add( m_panneau_boutons, BorderLayout.SOUTH );
		getContentPane().add( m_panneau_dessin, BorderLayout.CENTER );
		BoutonCercleAction action_cercle 
			= new BoutonCercleAction( this );
		JButton b1 = new JButton( "Cercle" );
		b1.addActionListener( action_cercle );
		m_panneau_boutons.add( b1 );

		// Indique ce qu'il faut faire si on clic sur "fermer la fenetre".
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		VisualiseurDeFormes visu = new VisualiseurDeFormes();
		//Display the window.
		visu.pack();
		visu.setVisible(true);
	}
	
	public Vector getFormes() {
		return m_formes;
	}

	public Random getRandom() {
		return m_random;
	}

}
