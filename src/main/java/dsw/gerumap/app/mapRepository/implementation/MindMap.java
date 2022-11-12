package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.NotificationType;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.observer.ISubscriber;

public class MindMap extends MapNodeComposite {

    private String name;
    private boolean template = false;


    public MindMap(String name, MapNode parent) {
        super(name, parent);

    }

    @Override
    public void addChild(MapNode child) {
        if(child != null && child instanceof Element){
            Element element = (Element) child;
            if(!this.getChildren().contains(element)) {
                this.getChildren().add(element);
                notifySubscriber(NotificationType.NODE_CREATED);
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if(child != null && child instanceof Element) {
            Element element = (Element) child;
            this.getChildren().remove(element);
            notifySubscriber(NotificationType.NODE_DELETED);
        }
    }
}
