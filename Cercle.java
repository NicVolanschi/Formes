import java.awt.Graphics;
import java.awt.Color;

public class Cercle extends FormeColoree implements Forme {
	protected int m_x;
	protected int m_y;
	protected int m_r;
	
	public Cercle( int x, int y, int r, Color c )
	{
		m_x = x;
		m_y = y;
		m_r = r;
		m_color = c;
	}
	
	public void redessiner(Graphics g) {
        g.setColor(m_color);
		g.drawOval( m_x - m_r , m_y - m_r,
			2 * m_r, 2 * m_r );
	}

}
