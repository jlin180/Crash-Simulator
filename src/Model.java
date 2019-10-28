public class Model {

	private shape _obj1;
	private shape _obj2;
	private GUI _observer;

	public Model() {
		_obj1 = new shape("circle");
		_obj2 = new shape("rectangle");
	}

	public void updateMovement() {
		if(_obj1.pos_x > _obj2.pos_x) {
			double finalVelocity1 = Functions.elasticVelocity1(_obj1.getVelocity(), _obj1.getMass(),_obj2.getVelocity(),_obj2.getMass());
			double finalVelocity2 = Functions.elasticVelocity2(_obj1.getVelocity(), _obj1.getMass(),_obj2.getVelocity(),_obj2.getMass());
			System.out.println("Final1 "+finalVelocity1);
			System.out.println("Final2 "+finalVelocity2);
			_obj1.setVelocity(finalVelocity1);
			_obj2.setVelocity(finalVelocity2);
		}
		_obj1.pos_x += _obj1.getVelocity();
		_obj2.pos_x += _obj2.getVelocity();
	}

	public shape getObj1() {
		return _obj1;
	}

	public shape getObj2() {
		return _obj2;
	}

	//Whenever a GUI is created, the interface will keep on calling the update method
	public void setObserver(GUI observer) {
		_observer = observer;
	}

	public void setObj1Velocity(double vel) {_obj1.setVelocity(vel);}
	public void setObj1Mass(double mass) {_obj1.setMass(mass);}
	public void setObj2Velocity(double vel) {_obj2.setVelocity(vel);}
	public void setObj2Mass(double mass) {_obj2.setMass(mass);}

}