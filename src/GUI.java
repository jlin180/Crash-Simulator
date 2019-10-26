import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class GUI{
	
	class simulationPanel extends JPanel {

        simulationPanel() {
    		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(screenSize.width,screenSize.height/2*3));
            System.out.println("Width: " + screenSize.width + " Height: " + screenSize.height/2*3);
//            setBackground(new java.awt.Color(255, 255, 255));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
        
        public void paint(Graphics g, BufferedImage i, int x, int y) {
        	g.drawImage(i, x, y, null);
        }
    }
	
	private boolean running = false;
	private Thread thread;
	
//	Canvas canvas = new Canvas();
	
	JFrame frame;
	JTextField obj1MassTxt = new JTextField("");
    JTextField obj2MassTxt = new JTextField("");
    JTextField obj1VelTxt = new JTextField("");
    JTextField obj2VelTxt = new JTextField("");
    JButton startBtn = new JButton("Start");

    //Base panels
    JSplitPane splitPane = new JSplitPane();
    simulationPanel simulation = new simulationPanel();
    
    //Simulation
    shape obj1;
	shape obj2;
	static BufferedImage image1 = null;
	static BufferedImage image2 = null;
	static BufferedImage background = null;

	public GUI() {
		//Base Variables
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Font defaultFont = new Font("MonoSpace", Font.PLAIN, 24);
		Dimension defaultInput = new Dimension(200,35);
		
		// Create Jframe
        frame=new JFrame("Simulator"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //Set frame size
        
        frame.setSize(screenSize);
        
        // Create Panels
        JPanel inputPanel = new JPanel(new BorderLayout());
        
        // Input panel 
        JPanel obj1Panel = new JPanel(new GridBagLayout());
        JPanel obj2Panel = new JPanel(new GridBagLayout());
        JPanel centerPanel = new JPanel(new GridBagLayout());
        
        // GridBag constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        //Center Panel items
        String [] weatherList = { "Clear" ,"Icy", "Rainy ", " Windy" };
        JComboBox weather = new JComboBox(weatherList);
        weather.setSelectedIndex(0);
        weather.setPreferredSize(defaultInput);
        weather.setFont(defaultFont);
//        weather.addActionListener(this);
        startBtn.setPreferredSize(defaultInput);
        startBtn.setFont(defaultFont);
       
        //Input 1 items
        JLabel obj1MassLbl = new JLabel("Mass of first object: ");
        obj1MassLbl.setFont(defaultFont);
        obj1MassTxt.setPreferredSize(defaultInput);
        obj1MassTxt.setFont(defaultFont);
        JLabel obj1VelLbl = new JLabel("Velocity of first object: ");
        obj1VelLbl.setFont(defaultFont);
        obj1VelTxt.setPreferredSize(defaultInput);
        obj1VelTxt.setFont(defaultFont);
        
        //Input 2 items
        JLabel obj2MassLbl = new JLabel("Mass of second object: ");
        obj2MassLbl.setFont(defaultFont);
        obj2MassTxt.setPreferredSize(defaultInput);
        obj2MassTxt.setFont(defaultFont);
        JLabel obj2VelLbl = new JLabel("Velocity of first object: ");
        obj2VelLbl.setFont(defaultFont);
        obj2VelTxt.setPreferredSize(defaultInput);
        obj2VelTxt.setFont(defaultFont);
        
        // 0,0
        constraints.gridx = 0;
        constraints.gridy = 0;
        obj1Panel.add(obj1MassLbl, constraints);
        obj2Panel.add(obj2MassLbl, constraints);
        centerPanel.add(weather, constraints);
        // 1,0
        constraints.gridx = 1;
        obj1Panel.add(obj1MassTxt, constraints);
        obj2Panel.add(obj2MassTxt, constraints);
        // 0,1
        constraints.gridx = 0;
        constraints.gridy = 1;
        obj1Panel.add(obj1VelLbl, constraints);
        obj2Panel.add(obj2VelLbl, constraints);
        centerPanel.add(startBtn, constraints);
        // 1,1
        constraints.gridx = 1;
        obj1Panel.add(obj1VelTxt, constraints);
        obj2Panel.add(obj2VelTxt, constraints);
        
        //Add to input panel
        inputPanel.add(obj1Panel, BorderLayout.WEST);
        inputPanel.add(obj2Panel, BorderLayout.EAST);
        inputPanel.add(centerPanel, BorderLayout.CENTER);
                
        
        //Add panels into split pane 
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(screenSize.height/3);
        splitPane.setTopComponent(inputPanel); 
//        simulation.setBackground(new java.awt.Color(255, 255, 255));
        splitPane.setBottomComponent(simulation);  
        splitPane.setEnabled(false);
       
        // Add split pane
        frame.add(splitPane);
        frame.setResizable(false);
        frame.setVisible(true);
	}
	
	public void startSimulation() {
		if(isValid()) {
			shape obj1 = new shape(obj1MassTxt.getText(), obj1VelTxt.getText());
			shape obj2 = new shape(obj2MassTxt.getText(), obj2VelTxt.getText());
			
			double finalVelocity1 = Functions.elasticVelocity1(obj1, obj2);
			double finalVelocity2 = Functions.elasticVelocity2(obj1, obj2);
			
			
			System.out.println("Final1 "+finalVelocity1);
			System.out.println("Final2 "+finalVelocity2);
//			this.setVisible(true);
			init();
		}
	}
	
	public void init() {
//		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			//Start off with circles
			image1 = loader.loadImage("assets/Circle.png");
			image2 = loader.loadImage("assets/Rectangle.png");
			background = loader.loadImage("assets/background.png");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		Graphics g = simulation.getGraphics();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("Width: " + screenSize.width + " Height: " + screenSize.height/2*3);
		simulation.paint(g, background, 0,0);
		simulation.paint(g, image1, 0, 375);
		simulation.paint(g, image2, screenSize.width-600, 375);
	}
	
	public boolean isValid() {
		if(obj1MassTxt.getText().length() == 0) return false;
		if(obj2MassTxt.getText().length() == 0) return false;
		if(obj1VelTxt.getText().length() == 0) return false;
		if(obj2VelTxt.getText().length() == 0) return false;
		return true;
	}

}
