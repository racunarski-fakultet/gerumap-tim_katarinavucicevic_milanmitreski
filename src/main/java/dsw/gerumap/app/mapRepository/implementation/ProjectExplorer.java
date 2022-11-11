package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.observer.ISubscriber;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if(child != null && child instanceof Project){
            Project project = (Project) child;
            if(!this.getChildren().contains(project))
                this.getChildren().add(project);
        }
    }

}
