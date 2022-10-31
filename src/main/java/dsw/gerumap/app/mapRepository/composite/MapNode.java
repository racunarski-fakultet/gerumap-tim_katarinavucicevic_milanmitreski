package dsw.gerumap.app.mapRepository.composite;

public abstract class MapNode {

    String name;
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
