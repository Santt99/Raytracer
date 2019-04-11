package Render;

import Objects.Vector3;

import java.awt.*;

public class DirectionalLigth extends Ligth{
    private Vector3 direction = null;
    private Color color = null;
    private double intensity;

    public DirectionalLigth(Vector3 direction, Color color, double intensity, TypeOfLigth type) {
        super(type);
        setColor(color);
        setDirection(direction);
        setIntensity(intensity);
    }

    public Vector3 getDirection() {
        return direction;
    }

    public void setDirection(Vector3 direction) {
        this.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        if(intensity < 0)
            intensity = 0;
        this.intensity = intensity;
    }
}
