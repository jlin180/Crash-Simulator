import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class GUI {
	JFrame frame;
	JTextField obj1MassTxt = new JTextField("");
    JTextField obj2MassTxt = new JTextField("");
    JTextField obj1VelTxt = new JTextField("");
    JTextField obj2VelTxt = new JTextField("");
    JButton startBtn = new JButton("Start");


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
        JSplitPane splitPane = new JSplitPane();
        JPanel inputPanel = new JPanel(new BorderLayout());
        JPanel simulation = new JPanel();
        
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
        splitPane.setBottomComponent(simulation);  
        splitPane.setEnabled(false);
       
        // Add split pane
        frame.add(splitPane);
        frame.setResizable(false);
        frame.setVisible(true);
	}
}
