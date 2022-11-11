package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Project extends MapNodeComposite {

    private String name;
    private String author;
    private String path;

    public Project(String name, MapNode mapNode) {
        super(name, mapNode);
    }

    @Override
    public void addChild(MapNode child) {
        if(child != null && child instanceof MindMap){
            MindMap mindMap = (MindMap) child;
            if(!this.getChildren().contains(mindMap)) {
                this.getChildren().add(mindMap);

            }
        }
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscriber(this);
    }

    public String getAuthor() {
        return author;
    }
}
