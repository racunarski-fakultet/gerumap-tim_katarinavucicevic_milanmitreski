package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;

public class MapView extends JPanel implements ISubscriber {
    @Override
    public void update(Object notification) {
        if (notification instanceof MindMap){

        }
    }
}
