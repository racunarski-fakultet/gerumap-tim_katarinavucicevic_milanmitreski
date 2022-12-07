package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.state.SelectorModel;
import dsw.gerumap.app.state.SelectorView;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements State {

    private boolean drag;

    private SelectorModel selectorModel = null;

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

        if(!drag) {
            selectorModel = new SelectorModel(pos);
            selectorModel.addSubscriber(mapView);
            selectorModel.setStartPoint(pos);
            drag = true;
        }

        if(selectorModel != null)
        {
            selectorModel.notifySubscriber(selectorModel);
            selectorModel.setCurrentPoint(pos);
            mapView.update(selectorModel);

        }

        mapView.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        mapView.setSelectorView(null);
        drag = false;
        mapView.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();

        Point pos = e.getPoint();
        selectorModel.setCurrentPoint(pos);

        float width = Math.abs(selectorModel.getCurrentPoint().x - selectorModel.getStartPoint().x);
        float height = Math.abs(selectorModel.getCurrentPoint().y - selectorModel.getStartPoint().y);


        selectorModel.setFrameFromDiagonal(selectorModel.getStartPoint(), selectorModel.getCurrentPoint());

        selectorModel.notifySubscriber(selectorModel);
        for(ElementView ev : mapView.getElementViews()){
            if(selectorModel.contains(ev.getShape().getBounds())){
                mapView.getSelectedElements().add(ev);
                mapView.repaint();
            }
        }
        mapView.repaint();
        // selection model je publisher
        // lista elementView, lista selektovanih i pravougaonik
    }
}
