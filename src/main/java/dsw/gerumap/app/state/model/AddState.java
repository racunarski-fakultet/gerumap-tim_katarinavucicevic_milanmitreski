package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;
import java.util.Random;

public class AddState implements State {
    @Override
    public void mousePressed(MouseEvent e) {
        MapView source = (MapView) e.getSource();
        MindMap m = source.getMindMap();
        m.addChild(new Term("Element" + new Random().nextInt(100), m, e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
