import java.lang.Math;

public class Functions {

	public static double elasticVelocity1(double mass1, double mass2, double velocity1, double velocityp2) {
		double velocityFinal1;
		double velocity2 = -(velocityp2);
		velocityFinal1 = (((mass1 - mass2)*velocity1 )+ (2*mass2*velocity2))/(mass1+mass2);
		return velocityFinal1;
	}
	public static double elasticVelocity2(double mass1, double mass2, double velocity1, double velocityp2){
		double  velocityFinal2;
		double velocity2 = -(velocityp2);
		velocityFinal2 = ((2*mass1*velocity1) - ((mass1-mass2)*velocity2))/(mass1+mass2);
		return velocityFinal2;
	
	}
	public static double inelasticVelocity(double mass1, double mass2, double velocity1, double velocityp2) {
		double velocityFinal;
		double velocity2 = -(velocityp2);
		velocityFinal = ((mass1*velocity1)+(mass2*velocity2))/(mass1+mass2);
		return velocityFinal;
	}
	public static double distanceWithFriction(double friction, double mass, double velocity) {
		double distance;
		distance = (.5*mass*(Math.pow(velocity, 2)))/(friction*(9.81)*mass);
		return distance;
		
	}
}

