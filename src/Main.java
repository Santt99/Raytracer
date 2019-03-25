import Objects.Object3D;
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
        scene01.addObject(new Sphere(new Vector3(0f, 1f, 5f), 0.5f, Color.RED));
        scene01.addObject(new Sphere(new Vector3(0f, 1f, 11f), 0.5f, Color.BLUE));
        scene01.addObject(new Sphere(new Vector3(0f, 1f, 201f), 0.5f, Color.BLACK));


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
