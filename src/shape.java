
public class shape {
	Double mass;
	Double velocity;
	public shape(String m, String v) {
		mass = Double.parseDouble(m);
		velocity = Double.parseDouble(v);
	}
	public double getInitialVelocity() {
		return velocity;
	}
	public double getMass() {
		return mass;
	}
}
