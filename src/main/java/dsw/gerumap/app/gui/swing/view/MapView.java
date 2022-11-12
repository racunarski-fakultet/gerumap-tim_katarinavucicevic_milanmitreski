package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.NotificationType;
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
        if(notification instanceof NotificationType) {
            switch((NotificationType) notification) {
                case NODE_CREATED:
                    break;
                case NODE_DELETED:
                    break;
                case NAME_CHANGED:
                    setName(mindMap.getName());
                    ((MyTabbedPane)this.getParent()).setTitleAt(((MyTabbedPane)this.getParent()).indexOfComponent(this), this.getName());
                    break;
                default:
                    break;
            }
        }
    }

    public MindMap getMindMap() {
        return mindMap;
    }

}
