package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public abstract class Element extends MapNode {

    private int stroke;
    private int color ;
    private double xCoordinate;
    private double yCoordinate;

    public Element(String ime, MapNode parent, int stroke, int color, double xCoordinate, double yCoordinate) {
        super(ime, parent);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.stroke = stroke;
        this.color = color;
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

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }
}
