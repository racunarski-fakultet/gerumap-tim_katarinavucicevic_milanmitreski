package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public class FactoryUtil {

    public static NodeFactory getNodeFactory(MapNodeComposite parent) {
        if(parent instanceof ProjectExplorer)
            return new ProjectFactory();
        else if (parent instanceof Project)
            return new MindMapFactory();
        else if (parent instanceof MindMap)
            return new ElementFactory();
        return null;
    }
}
