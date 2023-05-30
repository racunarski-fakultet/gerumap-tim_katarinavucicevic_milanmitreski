package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public class Relation extends Element{

    private Term termFrom;
    private Term termTo;

    private final String type = "Relation";

    public Relation(String ime, MapNode parent, int stroke, int color, Term termFrom, Term termTo) {
        super(ime, parent, stroke, color);
        this.termFrom = termFrom;
        this.termTo = termTo;
    }

    public void setTermFrom(Term termFrom) {
        this.termFrom = termFrom;
    }

    public void setTermTo(Term termTo) {
        this.termTo = termTo;
    }

    public Term getTermFrom() {
        return termFrom;
    }

    public Term getTermTo() {
        return termTo;
    }
}
