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

    private List<ISubscriber> subscribers;

    public Project(String name, MapNode mapNode) {
        super(name, mapNode);
        subscribers = new ArrayList<>();
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

    @Override
    public void setName(String name) {
        this.name = name;
        notifySubscriber(this);
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscriber(this);
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void addSubcriber(ISubscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        for(ISubscriber sub : subscribers){
            sub.update(notification);
        }
    }
}
