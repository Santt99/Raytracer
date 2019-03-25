package Objects;

import Render.Intersection;
import Render.Ray;

import java.awt.*;

public class Sphere extends Object3D {
	private float radius;
	public Sphere(Vector3 origin,float radius, Color color) {
		super(origin,color);
		setRadius(radius);
	}
	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}



	@Override
	public Intersection getIntersection(Ray ray) {
		double distance = -1;
		Vector3 normal = Vector3.ZERO();
		Vector3 position = Vector3.ZERO();

		Vector3 directionSphereRay = Vector3.substract(ray.getOrigin(), getPosition());
		double firstP = Vector3.dotProduct(ray.getDirection(), directionSphereRay);
		double secondP = Math.pow(Vector3.magnitude(directionSphereRay), 2);
		double intersection = Math.pow(firstP, 2) - secondP + Math.pow(getRadius(), 2);

		if (intersection >= 0) {
			double sqrtIntersection = Math.sqrt(intersection);

			double part1 = -firstP + sqrtIntersection;
			double part2 = -firstP - sqrtIntersection;

			distance = Math.min(part1, part2);
			position = Vector3.add(ray.getOrigin(), Vector3.scalarMultiplication(ray.getDirection(), distance));
			normal = Vector3.normalize(Vector3.substract(position, getPosition()));
		} else {
			return null;
		}

		return new Intersection(position, distance, normal, this);
	}
}
