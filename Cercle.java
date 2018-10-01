import java.awt.Graphics;

public class Cercle implements Forme {
	protected int m_x;
	protected int m_y;
	protected int m_r;
	
	public Cercle( int x, int y, int r )
	{
		m_x = x;
		m_y = y;
		m_r = r;
	}
	
	public void redessiner(Graphics g) {
		g.drawOval( m_x - m_r , m_y - m_r,
			2 * m_r, 2 * m_r );
	}

}
