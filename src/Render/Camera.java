package Render;

import Objects.Object3D;
import Objects.Sphere;
import Objects.Vector3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Camera extends Object3D {

    // 0 is fovh
    // 1 is fovv
    private float[] fieldOfView = new float[2];
    private float defaultZ = 15f;
    private int[] resolution;
    private int near;
    private int far;

    public Camera(Vector3 position,int near, int far ,float fieldOfViewHorizontal, float fieldOfViewVertical, int widthResolution, int heightResolution){
        super(position, new Color(0,0,0));
        setFieldOfViewHorizontal(fieldOfViewHorizontal);
        setFieldOfViewVertical(fieldOfViewVertical);
        setResolution(new int[] { widthResolution, heightResolution });
        setFar(far);
        setNear(near);
    }


    public Vector3[][] calculatePositionsToRay() {
        float angleMaxX = 90 - (getFieldOfViewHorizontal() / 2f);
        float radiusMaxX = getDefaultZ() / (float) Math.cos(Math.toRadians(angleMaxX));

        float maxX = (float) Math.sin(Math.toRadians(angleMaxX)) * radiusMaxX;
        float minX = -maxX;

        float angleMaxY = 90 - (getFieldOfViewVertical() / 2f);
        float radiusMaxY = getDefaultZ() / (float) Math.cos(Math.toRadians(angleMaxY));

        float maxY = (float) Math.sin(Math.toRadians(angleMaxY)) * radiusMaxY;
        float minY = -maxY;

        Vector3[][] positions = new Vector3[getResolution()[0]][getResolution()[1]];
        for (int x = 0; x < positions.length; x++) {
            for (int y = 0; y < positions[x].length; y++) {
                float posX = minX + (((maxX - minX) / (float) positions.length) * x);
                float posY = maxY - (((maxY - minY) / (float) positions[x].length) * y);
                float posZ = getDefaultZ();
                positions[x][y] = new Vector3(posX, posY, posZ);
            }
        }

        return positions;
    }
    public float getFieldOfViewHorizontal() {
        return fieldOfView[0];
    }

    public float getFieldOfViewVertical() {
        return fieldOfView[1];
    }
    public void setFieldOfViewHorizontal(float fov) {
        fieldOfView[0] = fov;
    }

    public void setFieldOfViewVertical(float fov) {
        fieldOfView[1] = fov;
    }

    public float getDefaultZ() {
        return defaultZ;
    }

    public void setDefaultZ(float defaultZ) {
        this.defaultZ = defaultZ;
    }

    public int[] getResolution() {
        return resolution;
    }

    public void setResolution(int[] resolution) {
        this.resolution = resolution;
    }

    public int getNear() {
        return near;
    }

    public void setNear(int near) {
        this.near = near;
    }

    public int getFar() {
        return far;
    }

    public void setFar(int far) {
        this.far = far;
    }


    @Override
    public Intersection getIntersection(Ray ray) {
        return null;
    }
}
