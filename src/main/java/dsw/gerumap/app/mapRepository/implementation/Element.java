package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.observer.ISubscriber;

public class Element extends MapNode {

    public Element(String ime, MapNode parent) {
        super(ime, parent);
    }

    @Override
    public void addSubcriber(ISubscriber sub) {

    }

    @Override
    public void removeSubscriber(ISubscriber sub) {

    }

    @Override
    public void notifySubscriber(Object notification) {

    }
}
