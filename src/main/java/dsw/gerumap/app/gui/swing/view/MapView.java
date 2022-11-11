package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class MapView extends JPanel implements ISubscriber {

    private MindMap mindMap;


    public MapView() {
        this.mindMap = (MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof MindMap){
            this.setName(((MindMap) notification).getName());
        }
    }

    public MindMap getMindMap() {
        return mindMap;
    }

}
