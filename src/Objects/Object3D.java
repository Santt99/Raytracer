package Objects;

import Render.Intersection;
import Render.Ray;

import java.awt.*;

public abstract class Object3D {
    Vector3 position;
    Color color;

    public Object3D(Vector3 position, Color color){
        setColor(color);
        setPosition(position);
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract Intersection getIntersection(Ray ray);
}
