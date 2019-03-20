import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Camera {
    private Point position;
    private int width;
    private int high;
    Camera(int width, int high, float Xposition,float Yposition, float Zposition ){
        setHigh(high);
        setWidth(width);
        setPosition(new Point(Xposition,Yposition,Zposition));
    }

    public void RenderSphere(Sphere[] spheres) throws IOException {
        BufferedImage image = new BufferedImage(width,high,BufferedImage.TYPE_INT_RGB);
        File outputImage = new File("image.png");
        Color color;
        for (int y = 0; y < high; y++) {
            for (int x = 0; x < width; x++) {
                Vector3 from = new Vector3((float) x, (float) y, this.getPosition().getZ());
                System.out.println(from.getOriginPoint().getX() + " " +from.getOriginPoint().getY() + " " + from.getOriginPoint().getZ() + " ");
                Vector3 to = new Vector3((float) x, (float) y, 500);
                System.out.println(to.getOriginPoint().getX() + " " +to.getOriginPoint().getY() + " " + to.getOriginPoint().getZ() + " ");
                Vector3 director = new Vector3(to.getOriginPoint().getX() -from.getOriginPoint().getX(),
                        to.getOriginPoint().getY() -from.getOriginPoint().getY(),
                        to.getOriginPoint().getZ() -from.getOriginPoint().getZ());
                Ray ray = new Ray(from,to);

                for (Sphere sphere: spheres) {
                    Vector3 orgintoCenter = new Vector3(sphere.getCenter().getX() - from.getOriginPoint().getX(),
                            sphere.getCenter().getY() - from.getOriginPoint().getY(),
                            sphere.getCenter().getZ() - from.getOriginPoint().getZ());
                    float a = director.Dot(director);
                    Vector3 multVec = director.multiplyVectorBy(2);
                    float b = multVec.Dot(orgintoCenter);
                    float c = orgintoCenter.Dot(orgintoCenter) - (float)Math.pow((double) sphere.getRadius(),2);
                    double discriminant = Math.pow(b,2) - (4 * a * c);
                    if(discriminant >= 0){
                        image.setRGB(x,y,sphere.getColor().getRGB());
                    }
                }

            }
        }
        ImageIO.write(image, "png", outputImage);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
