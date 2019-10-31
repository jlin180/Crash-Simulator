import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel{
	public SimulationPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width,height/2*3));		
	}
	
    public void paintComponent(Graphics g, shape img1, shape img2) {
	    	super.paintComponent(g);
	    	// Draw first image
	    	g.drawImage(img1.getBufferedImage(), img1.pos_x, img1.pos_y, null);
	    	// Draw second image
	    	g.drawImage(img2.getBufferedImage(), img2.pos_x, img2.pos_y, null);
	    	g.dispose();
//	    	dispose(g);
//    	repaint();
    }
    
    public void paintComponent(Graphics g, shape background) {
    	super.paintComponent(g);
    	g.drawImage(background.getBufferedImage(),0,0,null);
    }
    
    public void dispose(Graphics g) {
    	g.dispose();
    }
}
