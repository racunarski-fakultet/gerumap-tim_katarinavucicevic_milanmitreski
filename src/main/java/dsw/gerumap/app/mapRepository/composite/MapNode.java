package dsw.gerumap.app.mapRepository.composite;

public abstract class MapNode {

    String ime;
    private MapNode parent;

    public MapNode(String ime, MapNode parent) {
        this.ime = ime;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof MapNode){
            MapNode altObj = (MapNode) obj;
            return this.getIme().equals(altObj.getIme());
        }
        return false;
    }

    public String getIme() {
        return ime;
    }

    public MapNode getParent() {
        return parent;
    }
}
