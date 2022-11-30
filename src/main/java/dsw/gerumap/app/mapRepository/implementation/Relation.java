package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public class Relation extends Element{
    private Term termFrom;
    private Term termTo;

    public Relation(String ime, MapNode parent, int x_coordinate, int y_coordinate, Term termFrom, Term termTo) {
        super(ime, parent, x_coordinate, y_coordinate);
        this.termFrom = termFrom;
        this.termTo = termTo;
    }

    public Term getTermFrom() {
        return termFrom;
    }

    public Term getTermTo() {
        return termTo;
    }
}
