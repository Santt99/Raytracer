import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Sphere[] spheres ={new Sphere(200,50,450 , 10, new Color(255,0,0)),
                new Sphere(100,10,450 , 10, new Color(255,255,0)),
                new Sphere(300,20,450 , 10, new Color(255,0,255))
        };
        Camera cam = new Camera(480,160,0,0,0);
        cam.RenderSphere(spheres);
    }
}
