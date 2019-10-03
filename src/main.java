import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class main {
	static shape obj1;
	static shape obj2;
	
	public static void main(String args[]) {
		GUI window = new GUI();
		window.startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(window.checkStatus()) {
					window.startBtn.setEnabled(false);
					obj1 = new shape(window.obj1MassTxt.getText(), window.obj1VelTxt.getText());
					obj2 = new shape(window.obj2MassTxt.getText(), window.obj2VelTxt.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, "Please check all fields are numbers");
				}
			}
			
		});
	}
}
