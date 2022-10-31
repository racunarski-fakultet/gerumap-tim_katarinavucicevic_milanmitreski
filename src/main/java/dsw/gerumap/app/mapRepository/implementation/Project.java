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

    @Override
    public void addChild(MapNode child) {
        if(child != null && child instanceof MindMap){
            MindMap mindMap = (MindMap) child;
            if(!this.getChildren().contains(mindMap))
                this.getChildren().add(mindMap);
        }
    }
}
