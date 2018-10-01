import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends FormeColoree implements Forme {
	protected int m_x;
	protected int m_y;
	protected int m_l;
	protected int m_h;
	
	public Rectangle( int x, int y, int l, int h, Color c )
	{
    	m_x = x;
		m_y = y;
        m_l = l;
        m_h = h;
        m_color = c;
	}
	
	public void redessiner(Graphics g) {
        g.setColor(m_color);
		g.drawRect( m_x - m_l / 2 , m_y - m_h / 2,
			m_l, m_h );
	}

}
