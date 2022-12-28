package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.state.SelectorModel;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements State {

    private boolean drag;
    private SelectorModel selectorModel = null;

    @Override
    public void mousePressed(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        Point pos = new Point((int) ((e.getPoint().getX()-mapView.getxTranslate())/mapView.getScalingFactor()), (int) ((e.getPoint().getY()-mapView.getyTranslate())/mapView.getScalingFactor()));
        for(ElementView elementView : mapView.getElementViews()) {
            if(elementView.elementAt(pos)) {
                mapView.addSelected(elementView);
                mapView.repaint();
            } else {
                mapView.getSelectedElements().removeAll(mapView.getSelectedElements());
                mapView.repaint();
            }
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

        Point pos = new Point((int) ((e.getPoint().getX()-mapView.getxTranslate())/mapView.getScalingFactor()), (int) ((e.getPoint().getY()-mapView.getyTranslate())/mapView.getScalingFactor()));
        selectorModel.setCurrentPoint(pos);
        selectorModel.setFrameFromDiagonal(selectorModel.getStartPoint(), selectorModel.getCurrentPoint());
        selectorModel.notifySubscriber(selectorModel);
        for(ElementView ev : mapView.getElementViews()){
            if(selectorModel.intersects(ev.getShape().getBounds())){
                mapView.addSelected(ev);
                //mapView.setSelected(ev);
            } else {
                mapView.removeSelected(ev);
            }
        }
        mapView.repaint();
    }
}
