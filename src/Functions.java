import java.lang.Math;

public class Functions {
	//Elastic collision calculation (solving for object 1's velocity)
	public static double elasticVelocity1(double v1, double m1, double v2, double m2) {
		double velocityFinal1;
		double velocity2 = (v2);
		System.out.println("velocity2 in eV1: "+velocity2);
		velocityFinal1 = (((m1 - m2)*v1 )+ (2*m2*velocity2))/(m1+m2);
		return velocityFinal1;
	}
	//Elastic collision calculation (solving for object 2's velocity)
	public static double elasticVelocity2(double v1, double m1, double v2, double m2){
		double  velocityFinal2;
		double velocity2 = (v2);
		velocityFinal2 = ((2*m1*v1) - ((m1-m2)*velocity2))/(m1+m2);
		return velocityFinal2;
	
	}
	//Inelastic collision calculation (solving for final velocity)
	public static double inelasticVelocity(double v1, double m1, double v2, double m2) {
		double velocityFinal;
		double velocity2 = -(v2);
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
//	//Calculating the time traveled after the collision
//	public static double time(double travelDistance, double finalVelocity) {
//		//calculating the time traveled
//		//travelDistance should be the distance effected by friction
//		//finalVelocity is the final velocity (After collision)
//		double time;
//		time = travelDistance/finalVelocity;
//		return time;
//	}
	//Calculating horizontal force from friction
	public static double frictionForce(double friction, double mass) {
			double hFriction;
			hFriction = friction*mass*9.81;
			return hFriction;
		}
	//Calculating acceleration based off horizontal force
	public static double accelerationH( double mass, double friction) {
		double hAcceleration;
		double Hforce = frictionForce(friction,mass);
		hAcceleration =  Hforce/(mass);
		return hAcceleration;
	}
	//Calculating time 
	//acceleration obtain from acceleration formula
//	public static double timeH(double mass, double friction, double aftercoliVelocity) {
//		double time;
//		double acceleration = accelerationH(mass,friction);
//		time = aftercoliVelocity/(acceleration);
//		return time;
//	}
	//Calculating speed based off of acceleration from the horizontal force
	//acceleration obtain from acceleration formula
	public static double velocityFriction(double mass, double friction, double aftercoliVelocity, double time) {
		//need to get value of time somehow
		double fVelocity;
		double acceleration;
		if(aftercoliVelocity < 0) {
			acceleration =  accelerationH(mass, friction);
		}
		else {
			 acceleration = -1.0 * accelerationH(mass, friction);
		}
		fVelocity = aftercoliVelocity+(acceleration*time);
		return fVelocity; 

	}
}

