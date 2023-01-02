package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

    private String author;
    private String filePath;
    private boolean changed;

    public Project(String name, MapNode mapNode) {
        super(name, mapNode);
        this.changed = true;
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof MindMap){
            MindMap mindMap = (MindMap) child;
            if(!this.getChildren().contains(mindMap)) {
                this.getChildren().add(mindMap);
                child.setParent(this);
                notifySubscriber(child);
            }
            changed = true;
        }
    }

    public void removeChild(MapNode child) {
        if(child instanceof MindMap) {
            MindMap element = (MindMap) child;
            this.getChildren().remove(element);
            notifySubscriber(child);
        }
        changed = true;
    }

    public void setAuthor(String author) {
        this.author = author;
        changed = true;
        notifySubscriber(this);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        changed = true;
    }

    public String getAuthor() {
        return author;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
