import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
	static shape obj1;
	static shape obj2;
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
		
		finalVelocity1 = Functions.elasticVelocity1(obj1.getMass(),obj2.getMass(),obj1.getInitialVelocity(),obj2.getInitialVelocity());
		finalVelocity2 = Functions.elasticVelocity2(obj1.getMass(),obj2.getMass(),obj1.getInitialVelocity(),obj2.getInitialVelocity());
		
		
		System.out.println("Final1 "+finalVelocity1);
		System.out.println("Final2 "+finalVelocity2);
	}
}
