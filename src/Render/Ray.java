package Render;

import Objects.Vector3;

public class Ray {
	private Vector3 origin;
	private Vector3 direction;



	public Ray(Vector3 origin, Vector3 direction) {
		setOrigin(origin);
		setDirection(direction);
	}

	public Vector3 getOrigin() {
		return origin;
	}

	public void setOrigin(Vector3 origin) {
		this.origin = origin;
	}

	public Vector3 getDirection() {
		return Vector3.normalize(direction);
	}

	public void setDirection(Vector3 direction) {
		this.direction = direction;
	}
}
