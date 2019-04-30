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
                Intersection intersection = currentObj.getIntersection(ray, mainCamera);
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
                Color pixelColor = Color.black;
                if (closestIntersection != null ) {
                    Color intersectionColor = closestIntersection.getObject().getColor();
                    DirectionalLigth ligth = (DirectionalLigth) scene.getLigths().get(0);
                    float red = (float)((ligth.getIntensity() * (ligth.getColor().getRed()/255f) * (intersectionColor.getRed()/255f)) * (Vector3.dotProduct(closestIntersection.getNormal(), ligth.getDirection())));
                    float blue = (float)((ligth.getIntensity() * (ligth.getColor().getBlue()/255f) * (intersectionColor.getBlue()/255f)) * (Vector3.dotProduct(closestIntersection.getNormal(), ligth.getDirection())));
                    float green = (float)((ligth.getIntensity() * (ligth.getColor().getGreen()/255f) * (intersectionColor.getGreen()/255f)) * (Vector3.dotProduct(closestIntersection.getNormal(), ligth.getDirection())));


                    Color colorWithShades = new Color(clamp(red,0,1),clamp(green,0,1),clamp(blue,0,1));
                    pixelColor = addColor(pixelColor, colorWithShades);

                }
                image.setRGB(i, j, pixelColor.getRGB());
            }
        }

        return image;
    }
    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }

        if (value > max) {
            return max;
        }

        return value;
    }

    public static Color addColor(Color original, Color otherColor) {
        float red = clamp((original.getRed() / 255.0f) + (otherColor.getRed() / 255.0f), 0, 1);
        float green = clamp((original.getGreen() / 255.0f) + (otherColor.getGreen() / 255.0f), 0, 1);
        float blue = clamp((original.getBlue() / 255.0f) + (otherColor.getBlue() / 255.0f), 0, 1);
        return new Color(red, green, blue);
    }
}
