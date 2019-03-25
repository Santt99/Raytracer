package Render;

import Objects.Object3D;
import Objects.Vector3;

public class Intersection {
    private double distance;
    private Vector3 normal;
    private Vector3 position;
    private Object3D object;

    public Intersection(Vector3 position, double distance, Vector3 normal, Object3D object){
        setPosition(position);
        setDistance(distance);
        setNormal(normal);
        setObject(object);
    }

    public Object3D getObject() {
        return object;
    }

    private void setObject(Object3D object) {
        this.object = object;
    }

    public Vector3 getPosition() {
        return position;
    }

    private void setPosition(Vector3 position) {
        this.position = position;
    }

    public double getDistance() {
        return distance;
    }

    private void setDistance(double distance) {
        this.distance = distance;
    }

    public Vector3 getNormal() {
        return normal;
    }

    private void setNormal(Vector3 normal) {
        this.normal = normal;
    }
}
