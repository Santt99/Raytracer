package Objects;

import Render.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Polygon extends Object3D implements IIntersect {
    private ArrayList<Object3D> triangles = new ArrayList<Object3D>();
    public Polygon(Vector3 pos, Triangle[] triangles, Color color) {

        super(pos,color);
        setTriangles(triangles);
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public void setTriangles(Triangle[] triangles) {
        Vector3 position = getPosition();
        Set<Vector3> uniqueVertices = new HashSet<Vector3>();

        for (Triangle triangle : triangles) {
            uniqueVertices.addAll(Arrays.asList(triangle.getVertices()));
        }

        for (Vector3 vertex : uniqueVertices) {
            vertex.setX(vertex.getX() + position.getX());
            vertex.setY(vertex.getY() + position.getY());
            vertex.setZ(vertex.getZ() + position.getZ());
        }

        this.triangles = Arrays.asList(triangles);
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


}
