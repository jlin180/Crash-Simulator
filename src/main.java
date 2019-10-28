//import java.awt.event.ActionEvent; 
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//
//import java.awt.image.BufferStrategy;
//import java.awt.Graphics;
//import java.awt.Canvas;
//
//public class main extends Canvas implements Runnable{
//	//Shapes
//	static shape obj1;
//	static shape obj2;
//	static BufferedImage obj1Image = null;
//	static BufferedImage obj2Image = null;
//	static BufferedImage background = null;
//	
//	
//	static double finalVelocity1, finalVelocity2;
//	
////	public void generateObject(GUI window) {
////		obj1 = new shape(window.obj1MassTxt.getText(), window.obj1VelTxt.getText());
////		obj2 = new shape(window.obj2MassTxt.getText(), window.obj2VelTxt.getText());
////		
////		finalVelocity1 = Functions.elasticVelocity1(obj1, obj2);
////		finalVelocity2 = Functions.elasticVelocity2(obj1, obj2);
////		
////		
////		System.out.println("Final1 "+finalVelocity1);
////		System.out.println("Final2 "+finalVelocity2);
////		runSimulation();
////	}
//	
//	public void runSimulation() {
//		//Create initial objects
//		init();
//	}
//	
//	public void init() {
////		requestFocus();
//		BufferedImageLoader loader = new BufferedImageLoader();
//		try{
//			//Start off with circles
//			obj1Image = loader.loadImage("assets/Circle.png");
//			obj2Image = loader.loadImage("assets/Circle.png");
//			background = loader.loadImage("assets/background.png");
//		}catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		BufferStrategy bs = this.getBufferStrategy();
//		Graphics g = bs.getDrawGraphics();
//		g.drawImage(background, 0, 0, null, this);
//		
//	}
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public static void main(String args[]) {
//		GUI window = new GUI();
//		main m = new main();
//		window.startBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				window.startBtn.setEnabled(false);
////				m.generateObject(window);
//				window.startSimulation();
//			}
//			
//		});
//	}
//}
