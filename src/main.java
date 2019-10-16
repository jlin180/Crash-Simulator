import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class main {
	//Shapes
	static shape obj1;
	static shape obj2;
	static BufferedImage obj1Image = null;
	static BufferedImage obj2Image = null;
	
	
	static double finalVelocity1, finalVelocity2;
	public static void main(String args[]) {
		GUI window = new GUI();
		window.startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.startBtn.setEnabled(false);
				generateObject(window);
			}
			
		});
	}
	
	public static void generateObject(GUI window) {
		obj1 = new shape(window.obj1MassTxt.getText(), window.obj1VelTxt.getText());
		obj2 = new shape(window.obj2MassTxt.getText(), window.obj2VelTxt.getText());
		
		finalVelocity1 = Functions.elasticVelocity1(obj1, obj2);
		finalVelocity2 = Functions.elasticVelocity2(obj1, obj2);
		
		
		System.out.println("Final1 "+finalVelocity1);
		System.out.println("Final2 "+finalVelocity2);
		runSimulation();
	}
	
	public static void runSimulation() {
		//Create initial objects
		init();
	}
	
	public static void init() {
//		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			//Start off with circles
			obj1Image = loader.loadImage("/basic sprite sheet.png");
			obj2Image = loader.loadImage("/background.png");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
