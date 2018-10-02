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

	private Color m_color = Color.black;
	
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
				r.nextInt( 40 )+ 20, 
				m_color );
			m_visualiseur.getFormes().add( c );
			m_visualiseur.repaint();
		}
	}
	
	class BoutonRectangleAction implements ActionListener
	{
		public void actionPerformed( ActionEvent e)
		{
			Random r = getRandom();
			Rectangle c = new Rectangle(
				r.nextInt( 200 ),
				r.nextInt( 200 ),
				r.nextInt( 80 )+ 20,
				r.nextInt( 40 ) + 10, 
				m_color );
			getFormes().add( c );
			repaint();
		}
	}

	public VisualiseurDeFormes(String titre)
	{
		super( titre );
		m_formes = new Vector();
		m_formes.add(new Rectangle(100, 50, 100, 40, m_color));
		//m_formes.add( new String( "Texte" ) );
		m_random = new Random();
		setPreferredSize( new Dimension( 600, 300 ) );
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

		BoutonRectangleAction action_rectangle 
			= new BoutonRectangleAction( );
		JButton b2 = new JButton( "Rectangle" );
		b2.addActionListener( action_rectangle );
		m_panneau_boutons.add( b2 );

		JButton b3 = new JButton( "Reset");
		b3.addActionListener( (ActionEvent e) -> {
			m_formes.clear();
			repaint();
		} );
		m_panneau_boutons.add( b3 );

		JButton b4 = new JButton( "Aleatoire");
		b4.addActionListener(
			(ActionEvent e)	-> {
				Random r = getRandom();
				Forme c;
				if (r.nextInt( 2 ) != 0) {
					c = new Cercle(
						r.nextInt( 200 ),
						r.nextInt( 200 ),
						r.nextInt( 40 )+ 20, 
						m_color );
				} else {
					c = new Rectangle(
						r.nextInt( 200 ),
						r.nextInt( 200 ),
						r.nextInt( 80 )+ 20,
						r.nextInt( 40 ) + 10, 
						m_color );
				}
				getFormes().add( c );
				repaint();
			}		
		);
		m_panneau_boutons.add( b4 );

		JButton b5 = new JButton( "Blue");
		b5.addActionListener( (ActionEvent e) -> {
			m_color = Color.blue;
		} );
		m_panneau_boutons.add( b5 );

		JButton b6 = new JButton( "Black");
		b6.addActionListener( (ActionEvent e) -> {
			m_color = Color.black;
		} );
		m_panneau_boutons.add( b6 );

		// Indique ce qu'il faut faire si on clic sur "fermer la fenetre".
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		m_panneau_dessin.addMouseListener(new RectangleParDragSouris(this));
	}
	
	public static void main(String[] args) {
		VisualiseurDeFormes visu = new VisualiseurDeFormes("Visualiseur 1 exercice 3"); 
		//Display the window.
		visu.pack();
		visu.setVisible(true);
		// VisualiseurDeFormes visu2 = new VisualiseurDeFormes("Visualiseur 2 exercice 3"); 
		// //Display the window.
		// visu2.pack();
		// visu2.setVisible(true);
	}
	
	public Vector getFormes() {
		return m_formes;
	}

	public Random getRandom() {
		return m_random;
	}

}
