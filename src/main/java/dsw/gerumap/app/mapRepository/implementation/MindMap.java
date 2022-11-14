package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class MindMap extends MapNodeComposite {

    private final boolean template;


    public MindMap(String name, MapNode parent) {
        super(name, parent);
        template = false;
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element){
            Element element = (Element) child;
            if(!this.getChildren().contains(element)) {
                this.getChildren().add(element);
                notifySubscriber(child);
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if(child instanceof Element) {
            Element element = (Element) child;
            this.getChildren().remove(element);
            notifySubscriber(child);
        }
    }

}
