import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel{
	
	public SimulationPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width,height/2*3));		
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    public void paint(Graphics g, BufferedImage i, int x, int y) {
    	g.drawImage(i, x, y, null);
    }
}
