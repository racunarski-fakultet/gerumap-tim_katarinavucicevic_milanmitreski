package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

public class SetCentralTermState implements State {

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MapView source = (MapView) e.getSource();
        Point realPoint =  new Point((int) ((e.getPoint().getX()-source.getxTranslate())/source.getScalingFactor()), (int) ((e.getPoint().getY()-source.getyTranslate())/source.getScalingFactor()));
        for(ElementView ev : source.getElementViews()) {
            if(ev.elementAt(realPoint) && ev instanceof TermView) {
                double x = source.getVisibleRect().getWidth()/2;
                double y = source.getVisibleRect().getHeight()/2;
                Term term = (Term) ev.getElement();
                source.setCentralTerm((TermView)ev);
                double xTranslate = x - term.getXCoordinate() * source.getScalingFactor() - source.getxTranslate();
                double yTranslate = y - term.getYCoordinate() * source.getScalingFactor() - source.getyTranslate();
                source.translate(xTranslate, yTranslate);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
