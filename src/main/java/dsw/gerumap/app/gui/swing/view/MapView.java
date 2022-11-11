package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;

public class MapView extends JPanel implements ISubscriber {

    private MindMap mindMap;


    public MapView(MindMap mindMap) {
        this.mindMap = mindMap;
        this.mindMap.addSubcriber(this);
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof MindMap){
            this.setName(((MindMap) notification).getName());
            ((MyTabbedPane)this.getParent()).setTitleAt(((MyTabbedPane)this.getParent()).indexOfComponent(this), this.getName());
        }
    }

    public MindMap getMindMap() {
        return mindMap;
    }

}
