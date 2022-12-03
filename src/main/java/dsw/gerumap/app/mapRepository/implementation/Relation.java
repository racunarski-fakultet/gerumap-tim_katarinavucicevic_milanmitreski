package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public class Relation extends Element{
    private Term termFrom;
    private Term termTo;

    public Relation(String ime, MapNode parent, Term termFrom, Term termTo) {
        super(ime, parent, 4, 0x000000, 0, 0);
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
