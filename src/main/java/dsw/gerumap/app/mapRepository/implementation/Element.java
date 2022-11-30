package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public abstract class Element extends MapNode {

    private int stroke = 2;
    private int color = 0x555555;
    private int xCoordinate;
    private int yCoordinate;

    public Element(String ime, MapNode parent, int xCoordinate, int yCoordinate) {
        super(ime, parent);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public int getStroke() {
        return stroke;
    }

    public int getColor() {
        return color;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
}
