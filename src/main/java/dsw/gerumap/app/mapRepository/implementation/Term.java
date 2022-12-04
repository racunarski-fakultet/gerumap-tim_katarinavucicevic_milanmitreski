package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public class Term extends Element{

    private double xCoordinate;
    private double yCoordinate;


    public Term(String ime, MapNode parent, int stroke, int color, double xCoordinate,  double yCoordinate) {
        super(ime, parent, stroke, color);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }
}
