package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

import java.util.List;

public class Term extends Element{

    private final String type = "Term";
    private double xCoordinate;
    private double yCoordinate;
    private transient Term treeParent;
    private transient List<Term> treeChildren;
    private transient int spaceNeeded;

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

    public void setTreeParent(Term treeParent) {
        this.treeParent = treeParent;
        this.spaceNeeded = 0;
    }

    public void spaceNeeded(int newSpaceNeeded) {
        if(treeParent != null) {
            this.spaceNeeded += newSpaceNeeded;
            treeParent.spaceNeeded(newSpaceNeeded);
            if(treeParent.treeParent == null) {
                System.out.println(this.getName() + " " + spaceNeeded);
            }
        }
    }

    public void setTreeChildren(List<Term> treeChildren) {
        this.treeChildren = treeChildren;
    }

    public List<Term> getTreeChildren() {
        return treeChildren;
    }

    public int getSpaceNeeded() {
        return spaceNeeded;
    }

    public void distributeChildren(List<Term> children, int bound, int left) {
        for(Term child : children) {
            child.setXCoordinate(this.getXCoordinate() + left * 250);
            child.setYCoordinate(bound - child.spaceNeeded/2.0);
            child.distributeChildren(child.treeChildren, bound, left);
            bound -= child.spaceNeeded;
        }
    }
}
