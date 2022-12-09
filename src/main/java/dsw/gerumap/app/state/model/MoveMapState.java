package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveMapState implements State {

    private Point start;

    @Override
    public void mousePressed(MouseEvent e) {
        start = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MapView source = (MapView) e.getSource();
        Point current = e.getPoint();
        double xTranslate = (current.getX() - start.getX())/source.getScalingFactor();
        double yTranslate = (current.getY() - start.getY())/source.getScalingFactor();
        start = current;
        source.translate(xTranslate, yTranslate);
    }
}
