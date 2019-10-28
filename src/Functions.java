import java.lang.Math;

public class Functions {
	
	public static double elasticVelocity1(double v1, double m1, double v2, double m2) {
		double velocityFinal1;
		double velocity2 = -(v1);
		velocityFinal1 = (((m1 - m2)*v1 )+ (2*m2*velocity2))/(m1+m2);
		return velocityFinal1;
	}
	
	public static double elasticVelocity2(double v1, double m1, double v2, double m2){
		double  velocityFinal2;
		double velocity2 = -(v1);
		velocityFinal2 = ((2*m1*v1) - ((m1-m2)*velocity2))/(m1+m2);
		return velocityFinal2;
	
	}
	
	public static double inelasticVelocity(double v1, double m1, double v2, double m2) {
		double velocityFinal;
		double velocity2 = -(v1);
		velocityFinal = ((m1*v1)+(m2*velocity2))/(m1+m2);
		return velocityFinal;
	}
	
	public static double distanceWithFriction(double friction, double mass, double velocity) {
		double distance;
		distance = (.5*mass*(Math.pow(velocity, 2)))/(friction*(9.81)*mass);
		return distance;
		
	}
}

