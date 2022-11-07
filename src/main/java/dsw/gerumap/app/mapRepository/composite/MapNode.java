package dsw.gerumap.app.mapRepository.composite;

import dsw.gerumap.app.observer.IPublisher;

public abstract class MapNode implements IPublisher {

    private String name;
    private MapNode parent;

    public MapNode(String ime, MapNode parent) {
        this.name = ime;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof MapNode){
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
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }
}
