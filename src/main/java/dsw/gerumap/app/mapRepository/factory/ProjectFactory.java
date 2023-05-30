package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.Project;

import java.util.Random;

public class ProjectFactory extends NodeFactory{
    @Override
    protected MapNode createNode(MapNodeComposite parent) {
        return new Project("Project" + new Random().nextInt(100), parent);
    }
}
