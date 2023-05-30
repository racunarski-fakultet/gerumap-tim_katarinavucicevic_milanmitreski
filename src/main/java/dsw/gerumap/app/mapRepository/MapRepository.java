package dsw.gerumap.app.mapRepository;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.factory.NodeFactory;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public interface MapRepository {
    ProjectExplorer getProjectExplorer();
    void addChild(MapNodeComposite parent, MapNode child);
    NodeFactory getNodeFactory(MapNodeComposite parent);

}
