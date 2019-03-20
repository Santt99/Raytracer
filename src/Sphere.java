import java.awt.*;

public class Sphere {
	private Point center;
	private float radius;
	Color color;
	public Sphere(float x,float y,float z,float radius, Color color2) {
		setCenter(new Point(x, y, z)); 
		setRadius(radius);
		setColor(color2);
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
