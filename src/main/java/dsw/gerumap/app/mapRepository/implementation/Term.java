package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public class Term extends Element{

    private double xCoordinate;
    private double yCoordinate;
    private final String type = "Term";


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

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
        ((Project)getParent().getParent()).setChanged(true);
        notifySubscriber(this);
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
        ((Project)getParent().getParent()).setChanged(true);
        notifySubscriber(this);
    }

}
