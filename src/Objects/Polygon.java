package Objects;

import Render.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Polygon extends Object3D implements IIntersect {
    private ArrayList<Object3D> triangles = new ArrayList<Object3D>();
    public Polygon(Vector3 pos) {
        super(pos,null);
    }

    @Override
    public Intersection getIntersection(Ray ray, Camera cam) {


        return Raytracer.raycast(ray, triangles, null, cam );

    }

    public void addTriangle(Triangle triangle) {
        if (triangle == null)
            return;
        triangle.setPosition(Vector3.add(triangle.getPosition() , getPosition()));
        triangle.setPosition2(Vector3.add(triangle.getPosition2() , getPosition()));
        triangle.setPosition3(Vector3.add(triangle.getPosition3() , getPosition()));

        triangles.add(triangle);
    }

    public ArrayList<Object3D> getTriangles() {
        return this.triangles;
    }

}
