import java.awt.Graphics;

public class Rectangle implements Forme {
	protected int m_x;
	protected int m_y;
	protected int m_l;
	protected int m_h;
	
	public Rectangle( int x, int y, int l, int h )
	{
		m_x = x;
		m_y = y;
        m_l = l;
        m_h = h;
	}
	
	public void redessiner(Graphics g) {
		g.drawRect( m_x - m_l / 2 , m_y - m_h / 2,
			m_l, m_h );
	}

}
