package dsw.gerumap.app.mapRepository.composite;

import dsw.gerumap.app.mapRepository.composite.MapNode;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNodeComposite extends MapNode {

    List<MapNode> children;

    public MapNodeComposite(String ime, MapNode parent) {
        super(ime, parent);
        this.children = new ArrayList<>();
    }

    public MapNodeComposite(String ime, MapNode parent, List<MapNode>) {
        super(ime, parent);
        this.children = children;
    }

    public abstract void addChild(MapNode child);

    public MapNode getChildByName(String name) {
        for (MapNode child: this.getChildren()) {
            if (name.equals(child.getIme())) {
                return child;
            }
        }
        return null;
    }

    public List<MapNode> getChildren() {
        return children;
    }
}
