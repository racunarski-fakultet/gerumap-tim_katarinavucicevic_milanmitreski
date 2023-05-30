package dsw.gerumap.app.mapRepository;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.factory.FactoryUtil;
import dsw.gerumap.app.mapRepository.factory.NodeFactory;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImplementation implements MapRepository {

    private final ProjectExplorer projectExplorer;

    public MapRepositoryImplementation() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        parent.addChild(child);
    }

    @Override
    public NodeFactory getNodeFactory(MapNodeComposite parent) {
        return FactoryUtil.getNodeFactory(parent);
    }


}
