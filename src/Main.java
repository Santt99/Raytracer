import Objects.Object3D;
import Objects.Triangle;
import Objects.Vector3;
import Render.*;
import Objects.Sphere;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Date());

        Scene scene01 = new Scene();
        scene01.setCamera(new Camera(new Vector3(0, 0, -8), 10,200, 160, 160, 800,800));
        scene01.addObject(new Sphere(new Vector3(0f, 0f, 13f), 1f, Color.RED));
        scene01.addObject(new Sphere(new Vector3(-1f, -1f, 12f), 1f, Color.BLUE));
        scene01.addObject(new Sphere(new Vector3(-2f, 3f, 20f), 1f, Color.BLACK));
        scene01.addObject(new Triangle(new Vector3(2f, 2f, 11f),new Vector3(4f, 2f, 11f), new Vector3(3f, 1f, 11f), Color.ORANGE));

        BufferedImage image = Raytracer.raytrace(scene01);
        File outputImage = new File("image.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (IOException ex) {
            System.out.println("Something failed");
        }

        System.out.println(new Date());
    }



}
