package dsw.gerumap.app.mapRepository.implementation;

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
            if(!this.getChildren().contains(element))
                this.getChildren().add(element);
        }
    }

    @Override
    public void addSubcriber(ISubscriber sub) {

    }

    @Override
    public void removeSubscriber(ISubscriber sub) {

    }

    @Override
    public void notifySubscriber(Object notification) {

    }
}
