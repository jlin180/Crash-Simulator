import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener{

	private GUI _GUI;
	
	public ButtonHandler(GUI gui) {
		_GUI = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_GUI.startSimulation();
		_GUI.update();
	}

}
