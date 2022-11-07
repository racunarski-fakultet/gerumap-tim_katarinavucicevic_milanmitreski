package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public abstract class NodeFactory {

    private MapNode getNode(){
        MapNode n = createNode();
        //n.setName();
        //n.setParent();
        return n;
    }

    public abstract MapNode createNode();
}
