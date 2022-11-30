package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class DeleteState implements State {
    @Override
    public void mousePressed(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        MindMap mindMap = mapView.getMindMap();
        Point pos = e.getPoint();
        Iterator<ElementView> it = mapView.getElementViews().iterator();
        while(it.hasNext()) {
            ElementView elementView = it.next();
            if(elementView.elementAt(pos)) {
                if(elementView.equals(mapView.getSelected())) mapView.setSelected(null);
                mindMap.removeChild(elementView.getElement());
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
