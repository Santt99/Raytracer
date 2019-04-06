package Objects;

import Render.Intersection;
import Render.Ray;


import java.awt.*;

public class Triangle extends Object3D {
    private Vector3 position2;
    private Vector3 position3;
    private static double EPSILON = 0.000001;

    public Triangle(Vector3 vertex1, Vector3 vertex2, Vector3 vertex3, Color color) {
        super(vertex1, color);
        setPosition2(vertex2);
        setPosition3(vertex3);
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public static double getEPSILON() {
        return EPSILON;
    }

    public static void setEPSILON(double EPSILON) {
        Triangle.EPSILON = EPSILON;
    }

    public Vector3 getPosition2() {
        return position2;
    }

    public void setPosition2(Vector3 position2) {
        this.position2 = position2;
    }

    public Vector3 getPosition3() {
        return position3;
    }

    public void setPosition3(Vector3 position3) {
        this.position3 = position3;
    }

    @Override
    public Intersection getIntersection(Ray ray) {

        double distance = -1;
        Vector3 normal = Vector3.ZERO();
        Vector3 v2v0 = Vector3.substract(this.getPosition3(), this.getPosition());
        Vector3 v1v0 = Vector3.substract(this.getPosition2(), this.getPosition());
        Vector3 position = Vector3.crossProduct(ray.getDirection(), v1v0);
        double determinant = Vector3.dotProduct(v2v0, position);
        double invDet = 1.0 / determinant;
        Vector3 T = Vector3.substract(ray.getOrigin(), this.getPosition());
        double u = invDet * Vector3.dotProduct(T, position);
        Vector3 Q = Vector3.crossProduct(T, v2v0);
        double v = invDet * Vector3.dotProduct(ray.getDirection(), Q);
        double t = invDet * Vector3.dotProduct(Q, v1v0);

        if (u < 0 || u > 1)
            return null;

        if (v < 0 || (v + u) > (1.0 + this.getEPSILON()))
            return null;

        normal = Vector3.normalize(Vector3.crossProduct(v1v0, v2v0));

        return new Intersection(new Vector3(0f, 0f, t), t, normal, this);


    }


}
