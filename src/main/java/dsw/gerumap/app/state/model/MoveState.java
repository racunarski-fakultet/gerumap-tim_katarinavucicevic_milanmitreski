package dsw.gerumap.app.state.model;

import dsw.gerumap.app.command.commands.MoveSelectedCommand;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class MoveState implements State {

    private Point startPoint;
    private final HashMap<Term, Point> map = new HashMap<>();

    @Override
    public void mousePressed(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        map.clear();
        startPoint = e.getPoint();
        for(ElementView ev : mapView.getSelectedElements()) {
            if (ev.getElement() instanceof Term) {
                Term t = (Term) ev.getElement();
                Point p = new Point((int) t.getXCoordinate(), (int) t.getYCoordinate());
                map.put(t, p);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MapView mapView = (MapView) e.getSource();
        for (ElementView elementView : mapView.getSelectedElements()) {
            for(ElementView ev : mapView.getElementViews()) {
                if(ev instanceof TermView && elementView instanceof TermView && !mapView.getSelectedElements().contains(ev) && elementView.getShape().intersects(ev.getShape().getBounds())) {
                    for(Term t : map.keySet()) {
                        t.setXCoordinate(map.get(t).getX());
                        t.setYCoordinate(map.get(t).getY());
                    }
                    mapView.getSelectedElements().clear();
                    mapView.repaint();
                    return;
                }
            }
        }
        MoveSelectedCommand moveSelectedCommand = new MoveSelectedCommand(mapView.getMindMap(), Map.copyOf(map));
        mapView.getMindMap().getCommandManager().addCommand(moveSelectedCommand);
        mapView.getSelectedElements().clear();
        mapView.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        HashMap<Term, Point> help = new HashMap<>();
        MapView mapView = (MapView) e.getSource();
        Point current = e.getPoint();
        for (ElementView elementView : mapView.getSelectedElements()) {
            if (elementView.getElement() instanceof Term) {
                Term t = (Term) elementView.getElement();
                help.put(t, new Point((int) (map.get(t).getX() + (current.getX() - startPoint.getX())/mapView.getScalingFactor()), (int) (map.get(t).getY() + (current.getY() - startPoint.getY())/mapView.getScalingFactor())));
            }
        }
        for (Term t : help.keySet()) {
            t.setXCoordinate(help.get(t).getX());
            t.setYCoordinate(help.get(t).getY());
        }
        mapView.repaint();
    }
}
