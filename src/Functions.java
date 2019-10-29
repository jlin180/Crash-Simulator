import java.lang.Math;

public class Functions {
	//Elastic collision calculation (solving for object 1's velocity)
	public static double elasticVelocity1(double v1, double m1, double v2, double m2) {
		double velocityFinal1;
		double velocity2 = -(v1);
		velocityFinal1 = (((m1 - m2)*v1 )+ (2*m2*velocity2))/(m1+m2);
		return velocityFinal1;
	}
	//Elastic collision calculation (solving for object 2's velocity)
	public static double elasticVelocity2(double v1, double m1, double v2, double m2){
		double  velocityFinal2;
		double velocity2 = -(v1);
		velocityFinal2 = ((2*m1*v1) - ((m1-m2)*velocity2))/(m1+m2);
		return velocityFinal2;
	
	}
	//Inelastic collision calculation (solving for final velocity)
	public static double inelasticVelocity(double v1, double m1, double v2, double m2) {
		double velocityFinal;
		double velocity2 = -(v1);
		velocityFinal = ((m1*v1)+(m2*velocity2))/(m1+m2);
		return velocityFinal;
	}
	//Calculating the distance with friction 
	public static double distanceWithFriction(double friction, double mass, double velocity) {
		//velocity here should be final velocity of one of the objects (after the collision)
		double distance;
		distance = (.5*mass*(Math.pow(velocity, 2)))/(friction*(9.81)*mass);
		return distance;
		
	}
	//Calculating the time traveled after the collision
	public static double time(double travelDistance, double finalVelocity) {
		//calculating the time traveled
		//travelDistance should be the distance effected by friction
		//finalVelocity is the final velocity (After collision)
		double time;
		time = travelDistance/finalVelocity;
		return time;
	}
	//Calculating velocity from friction
	public static double velocityWithFriction(double friction, double mass , double distance) {
		//this one is kind of weird because you're using friction to find the velocity so this doesn't have any relations to the collision
		//distance needs to be specified (not related to distanceWithFriction function)
		double fricVelocity;
		fricVelocity = Math.sqrt((2*(friction*9.81*mass*distance))/mass);
		return fricVelocity;
	}
}

