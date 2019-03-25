package Render;

import Objects.Object3D;
import Objects.Vector3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Raytracer {
    public static Intersection raycast(Ray ray, ArrayList<Object3D> objects, Object3D caster, Camera mainCamera) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);

            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();

                    if (distance >= 0 && (closestIntersection == null || distance < closestIntersection.getDistance())
                            && intersection.getPosition().getZ() >= mainCamera.getNear() && intersection.getPosition().getZ() <= mainCamera.getFar()) {
                        closestIntersection = intersection;
                    }
                }
            }
        }

        return closestIntersection;
    }

    public static BufferedImage raytrace(Scene scene) {
        Camera mainCamera = scene.getCamera();
        BufferedImage image = new BufferedImage(mainCamera.getResolution()[0], mainCamera.getResolution()[1], BufferedImage.TYPE_INT_RGB);
        ArrayList<Object3D> objects = scene.getObjects();

        Vector3[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
                double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
                double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();
                Ray ray = new Ray(mainCamera.getPosition(), new Vector3(x, y, z));

                Intersection closestIntersection = raycast(ray, objects, null,mainCamera);

                // Background color
                Color pixelColor = Color.WHITE;
                if (closestIntersection != null ) {
                    pixelColor = closestIntersection.getObject().getColor();
                }
                image.setRGB(i, j, pixelColor.getRGB());
            }
        }

        return image;
    }
}
