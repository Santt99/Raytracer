package Objects;

import Render.IIntersect;
import Render.Intersection;
import Render.Ray;
import Render.Raytracer;

import java.util.ArrayList;

public class Polygon extends Object3D implements IIntersect {
    private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    public Polygon() {
        super(null,null);
    }

    @Override
    public Intersection getIntersection(Ray ray) {

        //New way to render that stuff.
        //Raytracer.raycast(ray, triangles, null,  )
        ArrayList<Intersection> intersections = new ArrayList<Intersection>();

        for (Triangle triangle: triangles) {
           intersections.add(triangle.getIntersection(ray));
        }
        Intersection inter = null;
        for (Intersection curr: intersections) {
            if(curr != null){
                if(inter == null){
                    inter = curr;
                }
                else if(inter.getDistance() > curr.getDistance()){
                    inter = curr;
                }
            }

        }
        return inter;
    }

    public void addTriangle(Triangle triangle) {
        if (triangle == null)
            return;
        triangles.add(triangle);
    }

    public ArrayList<Triangle> getTriangles() {
        return this.triangles;
    }

}
