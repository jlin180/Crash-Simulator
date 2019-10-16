import java.lang.Math;

public class Functions {

	public static double elasticVelocity1(shape obj1, shape obj2) {
		double velocityFinal1;
		double velocity2 = -(obj1.velocity);
		velocityFinal1 = (((obj1.mass - obj2.mass)*obj1.velocity )+ (2*obj2.mass*velocity2))/(obj1.mass+obj2.mass);
		return velocityFinal1;
	}
	public static double elasticVelocity2(shape obj1, shape obj2){
		double  velocityFinal2;
		double velocity2 = -(obj1.velocity);
		velocityFinal2 = ((2*obj1.mass*obj1.velocity) - ((obj1.mass-obj2.mass)*velocity2))/(obj1.mass+obj2.mass);
		return velocityFinal2;
	
	}
	public static double inelasticVelocity(shape obj1, shape obj2) {
		double velocityFinal;
		double velocity2 = -(obj1.velocity);
		velocityFinal = ((obj1.mass*obj1.velocity)+(obj2.mass*velocity2))/(obj1.mass+obj2.mass);
		return velocityFinal;
	}
	public static double distanceWithFriction(double friction, double mass, double velocity) {
		double distance;
		distance = (.5*mass*(Math.pow(velocity, 2)))/(friction*(9.81)*mass);
		return distance;
		
	}
}

