package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveState implements State {
    @Override
    public void mousePressed(MouseEvent e) {
        MapView source = (MapView) e.getSource();
        Point pos = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
