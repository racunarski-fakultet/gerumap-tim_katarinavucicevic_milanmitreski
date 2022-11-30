package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements State {
    @Override
    public void mousePressed(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        Point pos = e.getPoint();
        for(ElementView elementView : mapView.getElementViews()) {
            if(elementView.elementAt(pos)) {
                mapView.setSelected(elementView);
                break;
            }
            mapView.setSelected(null);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
