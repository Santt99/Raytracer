package Render;

public abstract class Ligth {
    public enum TypeOfLigth {
        Directional,
        Spot,
        Ambient
    }
    private TypeOfLigth type;

    public Ligth(TypeOfLigth type) {
        setType(type);
    }

    public TypeOfLigth getType() {
        return type;
    }

    public void setType(TypeOfLigth type) {
        this.type = type;
    }
}
