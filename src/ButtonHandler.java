import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

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
		new Timer().schedule(new TimerTask() {
			int iteration = 0;
			public void run() {
				if(_model.getObj1().pos_x >= 0 && _model.getObj2().pos_x <= _screenWidth - _model.getObj2().getWidth() && iteration < 2000) {
					_GUI.update();
					iteration++;
				}
			}
		}, 0,25);
//		for(int iteration=0;				
//			_model.getObj1().pos_x >= 0 && 
//			_model.getObj2().pos_x <= _screenWidth - _model.getObj2().getWidth() && 
//			iteration < 2000;
//			iteration++) {
//				_GUI.update();
//		}
	}

}
