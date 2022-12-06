package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.state.SelectorModel;
import dsw.gerumap.app.state.SelectorView;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements State {

    private boolean drag = false;

    private SelectorModel selectorModel;

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
        drag = true;
        selectorModel = new SelectorModel(pos);
        selectorModel.addSubscriber(mapView);
        mapView.update(selectorModel);
        selectorModel.notifySubscriber(selectorModel); //ovde je lista subova prazna
        selectorModel.setStartPoint(pos);
        selectorModel.setCurrentPoint(pos);

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
        while(drag){
            Point pos = e.getPoint();
            selectorModel.setDragPoint(pos.x, pos.y);
            selectorModel.notifySubscriber(selectorModel);
            for(ElementView ev : mapView.getElementViews()){
                if(mapView.getSelectorView().getSelectorModel().intersects(ev.getShape().getBounds())){
                    mapView.getSelectedElements().add(ev);
                    mapView.repaint();
                }
            }
        }
        // selection model je publisher
        // lista elementView, lista selektovanih i pravougaonik
    }
}
