import Objects.Object3D;
import Objects.Polygon;
import Objects.Triangle;
import Objects.Vector3;
import Render.*;
import Objects.Sphere;
import Tools.ObjReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Date());

        Scene scene01 = new Scene();
        scene01.setCamera(new Camera(new Vector3(0, 1f, -8), 0,200, 160, 160, 800,800));

        try {
            scene01.addObject(ObjReader.extractDataFromFileAndCreatePolygon(getData("./src/smallTeapot.obj")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage image = Raytracer.raytrace(scene01);
        File outputImage = new File("image.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (IOException ex) {
            System.out.println("Something failed");
        }

        System.out.println(new Date());
    }

    public static ArrayList<String> getData(String filename)throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename).getAbsolutePath()));
        String line = reader.toString();
        ArrayList <String> file = new ArrayList<>();
        while ( (line = reader.readLine()) != null){
            file.add(line);
        }
        return file;
    }

}
