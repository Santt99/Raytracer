package Tools;

import Objects.Polygon;
import Objects.Triangle;
import Objects.Vector3;

import java.awt.*;
import java.util.ArrayList;

public abstract class ObjReader {


    public static Polygon extractDataFromFileAndCreatePolygon(ArrayList<String> rawText) {
        Polygon poly = new Polygon();
        ArrayList<Vector3> vertices = new ArrayList<Vector3>();
        for (int index = 0; index < rawText.size(); index++) {


            String[] line = rawText.get(index).split(" ");
            if (line[0].equals("v")) {
                ArrayList<Double> point = new ArrayList<>();
                String val = rawText.get(index);
                String info = "";
                Boolean still = true;
                for (int i = 0; i < val.length(); i++) {
                    char c = val.charAt(i);
                    if (c != ' ' && c != 'v') {
                        info += val.charAt(i);
                        if (still)
                            still = false;
                    } else if (!still) {
                        point.add(Double.valueOf(info));
                        info = "";
                        still = true;
                    }
                }
                vertices.add(new Vector3(point.get(0), point.get(1), Double.valueOf(info)));
            }
        }
        for (int index = 0; index < rawText.size(); index++) {
            String[] line = rawText.get(index).split(" ");
            ArrayList<Integer> vertexUnion = new ArrayList<>();
            if (line[0].equals("f")) {
                for (int i = 0; i < line.length; i++) {
                    String aux = rawText.get(index);
                    aux = aux.substring(2, rawText.get(index).length());
                    String[] points = aux.split(" ");

                    for (int v = 0; v < points.length; v++) {
                        String value = "";
                        for (int charT = 0; charT < points[v].length(); charT++) {
                            char c = points[v].charAt(charT);
                            if (c != '/') {
                                value += c;
                            } else {
                                vertexUnion.add(Integer.valueOf(value));
                                break;
                            }
                        }

                    }
                    poly.addTriangle(new Triangle(vertices.get(vertexUnion.get(0) - 1),
                            vertices.get(vertexUnion.get(1) - 1),
                            vertices.get(vertexUnion.get(2) - 1),
                            Color.LIGHT_GRAY
                    ));
                    if (vertexUnion.size() == 4) {
                        poly.addTriangle(new Triangle(vertices.get(vertexUnion.get(2) - 1),
                                vertices.get(vertexUnion.get(3) - 1),
                                vertices.get(vertexUnion.get(0) - 1),
                                Color.LIGHT_GRAY
                        ));
                    }

                }
            }
        }
        return poly;
    }

}
