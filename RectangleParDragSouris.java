import java.awt.event.*;
import java.awt.Color;

class RectangleParDragSouris extends java.awt.event.MouseAdapter {
    private int m_x;
    private int m_y;
    private VisualiseurDeFormes m_visu;

    public RectangleParDragSouris(VisualiseurDeFormes visu) 
    {
        m_visu = visu;
    }

    public void mousePressed(MouseEvent e) 
    {
        m_x = e.getX();
        m_y = e.getY();
    }

    public void mouseReleased(MouseEvent e)
    {
        int l = e.getX() - m_x;
        int h = e.getY() - m_y;
        m_visu.getFormes().add(new Rectangle(m_x + l/2, m_y + h/2, l, h, Color.black));
        m_visu.repaint();
    }
}