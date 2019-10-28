import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel{
	
	public SimulationPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width,height/2*3));		
	}
	
    public void paintComponent(Graphics g, BufferedImage img, int x, int y) {
//        super.paintComponent(g);
    	g.drawImage(img, x, y, null);
//    	repaint();
    }
}
