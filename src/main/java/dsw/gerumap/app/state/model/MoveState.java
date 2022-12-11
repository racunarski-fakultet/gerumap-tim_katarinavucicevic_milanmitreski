package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class MoveState implements State {

    private boolean drag;
    private MouseEvent pressed;
    private Point endPoint;
    private List <Point> startingPoints = new ArrayList<>();

    private ElementView firstSelected;

    @Override
    public void mousePressed(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        firstSelected = mapView.getSelectedElements().get(0);
        Point pos = e.getPoint();
        for(ElementView elementView : mapView.getSelectedElements()) {
            System.out.println("selektovani: " + mapView.getSelectedElements());
            if(elementView.elementAt(pos)) {
                // NA NEKU FORU NE DETEKTUJE SELETOVANOST ELEMENTA
                // ELEMENT KOJI JE BIO U LISTI SELEKTOVANIH, OSTAJE TAMO
                drag = true;
                pressed = e;
                //mapView.repaint();
            } else {
                drag = false;
                //mapView.repaint();
            }
            startingPoints.add(new Point((int)((Term)elementView.getElement()).getXCoordinate(), (int)((Term)elementView.getElement()).getYCoordinate()));

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
        //for (ElementView ev : mapView.getSelectedElements()) {

            if(drag) {

                //int x = (int) current.getX();
                //int y = (int) current.getY();

                ((Term) firstSelected.getElement()).setXCoordinate(current.getX());
                ((Term) firstSelected.getElement()).setYCoordinate(current.getY());


                for(int i = 1; i < mapView.getSelectedElements().size(); i++){
                    System.out.println("USAO");
                    Term t = (Term)mapView.getSelectedElements().get(i).getElement();
                    int scalingX = abs((int)startingPoints.get(i).getX() - current.x);
                    int scalingY = abs((int)startingPoints.get(i).getY() - current.y);
                    t.setXCoordinate(scalingX);
                    t.setYCoordinate(scalingY);
                }

                //System.out.println("Prvo X koord: " + ((Term)ev.getElement()).getXCoordinate());



                //System.out.println("Drugo X koord: " + ((Term)ev.getElement()).getXCoordinate());

                //ev.getShape().getBounds().setLocation(x, y);
                //ev.getElement().notifySubscriber(ev.getElement());
                //mapView.updateMove(ev.getElement());
                //mapView.update(ev.getElement()); // radi bolje od ovog iznad
                // mapView.repaint();

            //}
        }
    }
}
