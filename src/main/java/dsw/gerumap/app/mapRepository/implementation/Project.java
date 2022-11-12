package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.NotificationType;
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
                notifySubscriber(NotificationType.NODE_CREATED);
            }
        }
    }

    public void removeChild(MapNode child) {
        if(child != null && child instanceof MindMap) {
            MindMap element = (MindMap) child;
            this.getChildren().remove(element);
            notifySubscriber(NotificationType.NODE_DELETED);
        }
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscriber(NotificationType.AUTHOR_CHANGED);
    }

    public void setPath(String path) {
        this.path = path;
        notifySubscriber(NotificationType.AUTHOR_CHANGED);
    }

    public String getAuthor() {
        return author;
    }
}
