package Render;

import Objects.Object3D;

import java.util.ArrayList;

public class Scene {
    private Camera camera;
    private ArrayList<Object3D> objects;
    private  ArrayList<Ligth> ligths;

    public ArrayList<Ligth> getLigths() {
        return ligths;
    }

    public void setLigths(ArrayList<Ligth> ligths) {
        this.ligths = ligths;
    }
    public void addLigth(Ligth ligth){
        ligths.add(ligth);
    }
    public Scene(){
        setObjects(new ArrayList<Object3D>());
        setLigths(new ArrayList<Ligth>());
    }

    public void addObject(Object3D object){
        getObjects().add(object);
    }

    public ArrayList<Object3D> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<Object3D> objects) {
        this.objects = objects;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
