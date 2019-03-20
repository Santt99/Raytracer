
public class Ray {
	private Vector3 origin;
	private Vector3 direction;

	public Ray(Vector3 from,Vector3 to) {
		setVector(from);
		setDirection(to);
	}

	public Vector3 getVector() {
		return origin;
	}

	public void setVector(Vector3 vector) {
		this.origin = vector;
	}
	public Vector3 getDirection() {
		return direction;
	}

	public void setDirection(Vector3 direction) {
		this.direction = direction;
	}
}
