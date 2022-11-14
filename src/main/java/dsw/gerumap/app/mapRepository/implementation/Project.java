package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

    private String author;
    private String path;

    public Project(String name, MapNode mapNode) {
        super(name, mapNode);
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof MindMap){
            MindMap mindMap = (MindMap) child;
            if(!this.getChildren().contains(mindMap)) {
                this.getChildren().add(mindMap);
                notifySubscriber(child);
            }
        }
    }

    public void removeChild(MapNode child) {
        if(child instanceof MindMap) {
            MindMap element = (MindMap) child;
            this.getChildren().remove(element);
            notifySubscriber(child);
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
