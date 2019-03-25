package Objects;

public class Vector3 {
	private static final Vector3 ZERO = new Vector3(0.0, 0.0, 0.0);
	private double x,y,z;
	private double magnitude;

	public Vector3(double x,double y,double z) {
		setX(x);
		setY(y);
		setZ(z);
	}

	public static double dotProduct(Vector3 vectorA, Vector3 vectorB) {
		return (vectorA.x * vectorB.x) + (vectorA.y * vectorB.y) + (vectorA.z * vectorB.z);
	}

	public static Vector3 crossProduct(Vector3 vectorA, Vector3 vectorB) {
		return new Vector3((vectorA.y * vectorB.z) - (vectorA.z * vectorB.y),
				(vectorA.z * vectorB.x) - (vectorA.x * vectorB.z),
				(vectorA.x * vectorB.y) - (vectorA.y * vectorB.x));
	}

	public static double magnitude(Vector3 vectorA) {
		return Math.sqrt(dotProduct(vectorA, vectorA));
	}

	public static Vector3 add(Vector3 vectorA, Vector3 vectorB) {
		return new Vector3(vectorA.x + vectorB.x, vectorA.y + vectorB.y, vectorA.z + vectorB.z);
	}

	public static Vector3 substract(Vector3 vectorA, Vector3 vectorB) {
		return new Vector3(vectorA.x - vectorB.x, vectorA.y - vectorB.y, vectorA.z - vectorB.z);
	}

	public static Vector3 normalize(Vector3 vector) {
		double mag = Vector3.magnitude(vector);
		return new Vector3(vector.getX() / mag, vector.getY() / mag, vector.getZ() / mag);
	}

	public static Vector3 scalarMultiplication(Vector3 vector, double scalar) {
		return new Vector3(vector.getX() * scalar, vector.getY() * scalar, vector.getZ() * scalar);
	}

	@Override
	public String toString() {
		return "x: " + this.getX() + ", y: " + this.getY()+ ", Z: " + this.getZ();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	public Vector3 clone(){
		return new Vector3(getX(), getY(), getZ());
	}

	public static Vector3 ZERO(){
		return ZERO.clone();
	}
}
