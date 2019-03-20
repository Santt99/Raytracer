
public class Vector3 {
	private Point originPoint;
	private double magnitude;

	public Vector3(float x,float y,float z) {
		setOrigin(new Point(x, y, z));

	}
	public Vector3 multiplyVectorBy(float multiplier){
		return new Vector3(this.getOriginPoint().getX() *multiplier, this.getOriginPoint().getY() *multiplier,
				this.getOriginPoint().getZ() *multiplier);
	}
	public Vector3 Cross(Vector3 vec) {
		return new Vector3(this.getOriginPoint().getY() * vec.getOriginPoint().getZ() - vec.getOriginPoint().getY() * this.getOriginPoint().getZ(), 
				this.getOriginPoint().getX() * vec.getOriginPoint().getZ() - vec.getOriginPoint().getX() * this.getOriginPoint().getZ(), 
				this.getOriginPoint().getY() * vec.getOriginPoint().getX() - vec.getOriginPoint().getY() * this.getOriginPoint().getX());
	}
	public float Dot(Vector3 vec) {
		return ((this.getOriginPoint().getX() * vec.getOriginPoint().getX()) 
				+ (this.getOriginPoint().getY() * vec.getOriginPoint().getY()) 
				+ (this.getOriginPoint().getZ() * vec.getOriginPoint().getZ())); 
	}
	public Vector3 Direction(Vector3 vec) {
		return new Vector3(vec.getOriginPoint().getX() - this.getOriginPoint().getX(), 
				vec.getOriginPoint().getY() - this.getOriginPoint().getY(),
				vec.getOriginPoint().getZ() - this.getOriginPoint().getZ());
	}
	private void Magnitude() {
		magnitude  = Math.sqrt(Math.pow((double)originPoint.getX(),2) + Math.pow((double)originPoint.getY(),2) + Math.pow((double)originPoint.getZ(),2));
	}
	public Point getOriginPoint() {
		return originPoint;
	}
	public void setOrigin(Point origin) {
		this.originPoint = origin;
	}
	public double getMagnitude() {
		return magnitude;
	}
	
	
}
