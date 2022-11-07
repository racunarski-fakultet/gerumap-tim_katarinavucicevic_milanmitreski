package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.Element;

import java.util.Random;

public class ElementFactory extends NodeFactory{

    @Override
    protected MapNode createNode(MapNodeComposite parent) {
        return new Element("Element" + new Random().nextInt(100), parent);
    }
}
