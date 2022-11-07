package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public abstract class NodeFactory {

    public MapNode getNode(MapNodeComposite parent){
        MapNode n = createNode(parent);
        return n;
    }

    protected abstract MapNode createNode(MapNodeComposite parent);
}
