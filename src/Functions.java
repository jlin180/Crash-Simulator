
public class Functions {

	public static double elasticVelocity1(double mass1, double mass2, double velocity1, double velocity2) {
		double velocityFinal1;
		velocityFinal1 = (((mass1 - mass2)*velocity1 )+ (2*mass2*velocity2))/(mass1+mass2);
		return velocityFinal1;
	}
	public static double elasticVelocity2(double mass1, double mass2, double velocity1, double velocity2){
		double  velocityFinal2;
		velocityFinal2 = ((2*mass1*velocity1) - ((mass1-mass2)*velocity2))/(mass1+mass2);
		return velocityFinal2;
	}
}

