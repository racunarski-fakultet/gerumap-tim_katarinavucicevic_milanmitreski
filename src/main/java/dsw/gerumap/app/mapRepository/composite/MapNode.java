package dsw.gerumap.app.mapRepository.composite;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNode implements IPublisher {

    private String name;
    private transient MapNode parent;
    public transient List<ISubscriber> subscribers;

    public MapNode(String ime, MapNode parent) {
        this.name = ime;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MapNode){
            MapNode altObj = (MapNode) obj;
            return this.getName().equals(altObj.getName());
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public MapNode getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
        notifySubscriber(this);
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(subscribers == null) this.subscribers = new ArrayList<>();
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        if(subscribers == null) return;
        for(ISubscriber sub : subscribers){
            sub.update(notification);
        }
    }
}
