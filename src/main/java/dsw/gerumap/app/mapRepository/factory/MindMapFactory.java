package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.MindMap;

import java.util.Random;

public class MindMapFactory extends NodeFactory{
    @Override
    protected MapNode createNode(MapNodeComposite parent) {
        return new MindMap("MindMap" + new Random().nextInt(100), parent);
    }
}
