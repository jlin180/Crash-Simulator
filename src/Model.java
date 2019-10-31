public class Model {

	private shape _obj1;
	private shape _obj2;
	private GUI _observer;
	private long timeStart;
	private double afterColiVelocity1, afterColiVelocity2 ;
	boolean flag;
	
	public Model() {
		_obj1 = new shape("circle");
		_obj2 = new shape("rectangle");
	}

	public void updateMovement() {
		//Time in between, not needed to use until collision
		double timeInBetween = (timeStart != 0) ? (double)((System.currentTimeMillis() - timeStart)/(double)1000) : 1;
		//Collision
		if(_obj1.pos_x + _obj1.getWidth() >= _obj2.pos_x) {
			_obj1.setCoords(_obj1.pos_x, _obj1.pos_y);
			_obj2.setCoords(_obj1.pos_x + _obj1.getWidth(), _obj2.pos_y);
			if (flag == false) {
				afterColiVelocity1 = Functions.elasticVelocity1(_obj1.getVelocity(), _obj1.getMass(),_obj2.getVelocity(),_obj2.getMass());
				afterColiVelocity2 = Functions.elasticVelocity2(_obj1.getVelocity(), _obj1.getMass(),_obj2.getVelocity(),_obj2.getMass());
				flag = true;
				timeStart = System.currentTimeMillis();
			}
		}
		if(flag) {
			System.out.println("Time:"+timeInBetween);
			System.out.println("Friction:"+_observer.friction);
			double finalVelocity1 = Functions.velocityFriction(_obj1.getMass(),_observer.friction, afterColiVelocity1, timeInBetween);
			double finalVelocity2 = Functions.velocityFriction(_obj2.getMass(),_observer.friction, afterColiVelocity2, timeInBetween);
			if(finalVelocity2 < 0 ) {
				finalVelocity2 =0;
			}
			if(finalVelocity1 > 0) {
				finalVelocity1 =0;
			}
			System.out.println("afterColiV1 "+afterColiVelocity1);
			System.out.println("afterColiV2 "+afterColiVelocity2);
			System.out.println("Finalvelocity1: "+ finalVelocity1);
			System.out.println("Finalvelocity2:  "+ finalVelocity2);
			_obj1.setVelocity(finalVelocity1);
			_obj2.setVelocity(finalVelocity2);
		}
		//Change position with vel
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
	public void setTime() {timeStart = 0;}
	public void setFlag() {flag = false;}

}