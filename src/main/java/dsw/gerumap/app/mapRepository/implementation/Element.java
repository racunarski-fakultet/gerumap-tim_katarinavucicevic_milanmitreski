package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public abstract class Element extends MapNode {

    private int stroke;
    private int color;

    public Element(String ime, MapNode parent, int stroke, int color) {
        super(ime, parent);
        this.stroke = stroke;
        this.color = color;
    }

    public void setColor(int color) {
        this.color = color;
        ((Project)getParent().getParent()).setChanged(true);
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
        ((Project)getParent().getParent()).setChanged(true);
    }

    public int getStroke() {
        return stroke;
    }

    public int getColor() {
        return color;
    }

}
