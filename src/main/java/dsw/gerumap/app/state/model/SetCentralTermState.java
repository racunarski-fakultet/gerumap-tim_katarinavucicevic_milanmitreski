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
        for(ElementView ev : source.getElementViews()) {
            if(ev instanceof TermView) {
                if(ev.elementAt(realPoint)) {
                    centralTerm = (Term) ev.getElement();
                    centralTermView = (TermView) ev;
                }
                ((Term)ev.getElement()).setTreeChildren(new ArrayList<>());
            }
        }
        if(centralTerm == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected term to center", MessageType.NO_TERM_SELECTED);
            return;
        }
        for(ElementView ev : source.getElementViews()) {
            if(ev instanceof RelationView) {
                Term termTo = ((Relation)ev.getElement()).getTermTo();
                Term termFrom = ((Relation)ev.getElement()).getTermFrom();
                termTo.getTreeChildren().add(termFrom);
                termFrom.getTreeChildren().add(termTo);
            }
        }

        /* BFS deo */
        Map<Term, Integer> level = new HashMap<>();
        Queue<Term> queue = new LinkedList<>();
        List<Term> left = new ArrayList<>();
        List<Term> right = new ArrayList<>();

        level.put(centralTerm, 0);
        queue.add(centralTerm);
        centralTerm.setTreeParent(null);
        Term current;

        /* Ovaj BFS postavlja polje treeParent, odredjuje dubine, rasporedjuje "prvu" decu na levo i desno */
        int isLeft = -1;
        while(!queue.isEmpty()) {
            current = queue.remove();
            if(current.getTreeChildren().isEmpty()) {
                current.spaceNeeded(120);
            } else {
                for (Term neighbour : current.getTreeChildren()) {
                    neighbour.getTreeChildren().remove(current);
                    level.put(neighbour, level.get(current) + 1);
                    if (level.get(neighbour) == 1) {
                        if(isLeft == -1) {
                            left.add(neighbour);
                        } else {
                            right.add(neighbour);
                        }
                        isLeft *= -1;
                    }
                    neighbour.setTreeParent(current);
                    queue.add(neighbour);
                }
            }
        }
        int leftSpaceNeeded = 0;
        int rightSpaceNeeded = 0;
        for(Term t : left) {
            leftSpaceNeeded += t.getSpaceNeeded();
        }
        for(Term t : right) {
            rightSpaceNeeded += t.getSpaceNeeded();
        }
        centralTerm.distributeChildren(right, (int) (centralTerm.getYCoordinate() + rightSpaceNeeded/2), 1);
        centralTerm.distributeChildren(left, (int) (centralTerm.getYCoordinate() + leftSpaceNeeded/2), -1);

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
