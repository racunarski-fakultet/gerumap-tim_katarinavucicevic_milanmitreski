package dsw.gerumap.app.state.model;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.RelationView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.message.MessageType;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class SetCentralTermState implements State {

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MapView source = (MapView) e.getSource();
        Point realPoint =  new Point((int) ((e.getPoint().getX()-source.getxTranslate())/source.getScalingFactor()), (int) ((e.getPoint().getY()-source.getyTranslate())/source.getScalingFactor()));

        /* Priprema za BFS */
        Term centralTerm = null;
        TermView centralTermView = null;
        Map<Term, List<Term>> tree = new HashMap<>();
        Map<Term, Boolean> visited = new HashMap<>();
        for(ElementView ev : source.getElementViews()) {
            if(ev instanceof TermView) {
                if(ev.elementAt(realPoint)) {
                    centralTerm = (Term) ev.getElement();
                    centralTermView = (TermView) ev;
                }
                tree.put((Term) ev.getElement(), new ArrayList<>());
                visited.put((Term) ev.getElement(), false);
            }
        }
        if(centralTerm == null || centralTermView == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected term to center", MessageType.NO_TERM_SELECTED);
            return;
        }
        for(ElementView ev : source.getElementViews()) {
            if(ev instanceof RelationView) {
                Term termTo = ((Relation)ev.getElement()).getTermTo();
                Term termFrom = ((Relation)ev.getElement()).getTermFrom();
                tree.get(termTo).add(termFrom);
                tree.get(termFrom).add(termTo);
            }
        }

        /* BFS deo */
        Map<Term, Integer> level = new HashMap<>();
        Queue<Term> queue = new LinkedList<>();

        level.put(centralTerm, 0);
        visited.put(centralTerm, true);
        queue.add(centralTerm);
        Term current = null;

        int left = -1;
        while(!queue.isEmpty()) {
            current = queue.remove();
            for(Term neighbour : tree.get(current)) {
                if(!visited.get(neighbour)) {
                    level.put(neighbour, level.get(current) + 1);
                    visited.put(neighbour, true);
                    if(level.get(neighbour) == 1) {
                        neighbour.setXCoordinate(centralTerm.getXCoordinate() + left * 200);
                        neighbour.setYCoordinate(centralTerm.getYCoordinate());
                        left *= -1;
                    } else {
                        if(current.getXCoordinate() < centralTerm.getXCoordinate()) {
                            neighbour.setXCoordinate(current.getXCoordinate() - 200);
                            neighbour.setYCoordinate(centralTerm.getYCoordinate());
                        } else {
                            neighbour.setXCoordinate(current.getXCoordinate() + 200);
                            neighbour.setYCoordinate(centralTerm.getYCoordinate());
                        }
                    }
                    queue.add(neighbour);
                }
            }
        }

        double x = source.getVisibleRect().getWidth()/2;
        double y = source.getVisibleRect().getHeight()/2;
        source.setCentralTerm(centralTermView);
        double xTranslate = x - centralTerm.getXCoordinate() * source.getScalingFactor() - source.getxTranslate();
        double yTranslate = y - centralTerm.getYCoordinate() * source.getScalingFactor() - source.getyTranslate();
        source.translate(xTranslate, yTranslate);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
