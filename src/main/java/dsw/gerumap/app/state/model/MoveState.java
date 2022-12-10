package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveState implements State {

    private boolean drag;
    private MouseEvent pressed;

    @Override
    public void mousePressed(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        Point pos = e.getPoint();
        for(ElementView elementView : mapView.getSelectedElements()) {
            if(elementView.elementAt(pos)) {
                drag = true;
                pressed = e;
                //mapView.repaint();
            } else {
                drag = false;
                mapView.repaint();
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        drag = false;
        mapView.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        Point current = e.getPoint();
        for (ElementView ev : mapView.getSelectedElements()) {

            if(ev.elementAt(current)) {

                if(ev instanceof TermView) {

                    Point shapeLocation = ev.getShape().getBounds().getLocation();

                    int x = shapeLocation.x - 75 + (int) current.getX();
                    int y = shapeLocation.y - 50 + (int) current.getY();
                    System.out.println("Prvo X koord: " + ((Term)ev.getElement()).getXCoordinate());
                    //System.out.println("Prvo Y koord: " + ((Term)ev.getElement()).getYCoordinate());
                    ((Term) ev.getElement()).setXCoordinate(x);
                    ((Term) ev.getElement()).setYCoordinate(y);
                    System.out.println("Drugo X koord: " + ((Term)ev.getElement()).getXCoordinate());
                    //System.out.println("Drugo Y koord: " + ((Term)ev.getElement()).getYCoordinate());

                    ev.getShape().getBounds().setLocation(x, y);
                    //ev.getElement().notifySubscriber(ev.getElement());
                    mapView.update(ev.getElement());
                   // mapView.repaint();
                }
            }
        }

    }
}
