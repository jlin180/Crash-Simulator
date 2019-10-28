import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener{

	private GUI _GUI;
	private Model _model;
	private int _screenWidth;
	
	public ButtonHandler(GUI gui, Model m, int screenWidth) {
		_GUI = gui;
		_model = m;
		_screenWidth = screenWidth;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_GUI.startSimulation();
		for(int iteration=0;				
			_model.getObj1().pos_x >= 0 && 
			_model.getObj2().pos_x <= _screenWidth - _model.getObj2().getWidth() && 
			iteration < 200;
			iteration++) {
			_GUI.update();
		}
	}

}
