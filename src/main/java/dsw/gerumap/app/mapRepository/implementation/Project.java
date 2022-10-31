package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

    private String name;
    private String author;
    private String path;

    public Project(String name, MapNode mapNode) {
        super(name, mapNode);
        this.name = name;

    }
}
