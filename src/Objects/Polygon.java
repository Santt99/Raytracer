package Objects;

import Render.*;

import java.util.ArrayList;

public class Polygon extends Object3D implements IIntersect {
    private ArrayList<Object3D> triangles = new ArrayList<Object3D>();
    public Polygon() {
        super(null,null);
    }

    @Override
    public Intersection getIntersection(Ray ray, Camera cam) {


        return Raytracer.raycast(ray, triangles, null, cam );

    }

    public void addTriangle(Triangle triangle) {
        if (triangle == null)
            return;
        triangles.add(triangle);
    }

    public ArrayList<Object3D> getTriangles() {
        return this.triangles;
    }

}
