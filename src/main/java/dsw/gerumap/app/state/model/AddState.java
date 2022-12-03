package dsw.gerumap.app.state.model;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.message.MessageType;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;
import java.util.Random;

public class AddState implements State {

    private static int count = 0;
    @Override
    public void mousePressed(MouseEvent e) {
        MapView source = (MapView) e.getSource();
        for(ElementView ev : source.getElementViews()) {
            if(ev.elementAt(e.getPoint())) {
                AppCore.getInstance().getMessageGenerator().getMessage("FOUND ELEMENT " + ev.getElement().getName() + " AT (" + e.getX() + ", " + e.getY() + ")", MessageType.ELEMENT_FOUND_AT_POINT);
                return;
            }
        }
        MindMap m = source.getMindMap();
        m.addChild(new Term("Element" + count++, m, source.getStroke(), source.getColor(), e.getPoint().getX(), e.getPoint().getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
