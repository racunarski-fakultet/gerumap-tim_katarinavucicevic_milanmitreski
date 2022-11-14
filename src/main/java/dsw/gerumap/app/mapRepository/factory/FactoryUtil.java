package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public class FactoryUtil {

    private static final ProjectFactory projectFactory;
    private static final MindMapFactory mindMapFactory;
    private static final ElementFactory elementFactory;

    static {
        projectFactory = new ProjectFactory();
        mindMapFactory = new MindMapFactory();
        elementFactory = new ElementFactory();
    }

    public static NodeFactory getNodeFactory(MapNodeComposite parent) {
        if(parent instanceof ProjectExplorer)
            return projectFactory;
        else if (parent instanceof Project)
            return mindMapFactory;
        else if (parent instanceof MindMap)
            return elementFactory;
        return null;
    }
}
