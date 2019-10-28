import java.awt.image.BufferedImage;
import java.io.IOException;

public class shape{
	private double _mass;
	private double _velocity;
	private BufferedImage _img;
	private String _name;

	public int pos_x,pos_y;
	
	public shape(String obj) {
		_name = obj;
		_mass = 0;
		_velocity = 0;
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			_img = loader.loadImage("assets/"+obj+".png");
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	public shape(double mass, double velocity, String obj) {
		_mass = mass;
		_velocity = velocity;
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			loader.loadImage("assets/"+obj+".png");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getBufferedImage() {
		return _img;
	}
	
	public int getWidth() {
		return _img.getWidth();
	}
	
	public String getName() {	
		return _name;
	}
	
	public int getHeight() {
		return _img.getHeight();
	}
	
	public double getVelocity() {
		return _velocity;
	}
	
	public double getMass() {
		return _mass;
	}
	
	public void setCoords(int x, int y) {
		pos_x = x;
		pos_y = y;
	}
	
	public void setMass(double mass) {
		_mass = mass;
	}
	
	public void setVelocity(double velocity) {
		_velocity = velocity;
	}
}
