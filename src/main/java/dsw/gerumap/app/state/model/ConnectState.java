package dsw.gerumap.app.state.model;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.message.MessageType;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;

public class ConnectState implements State {

    private static int count = 0;

    private TermView termFrom;
    private TermView termTo;
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("here");
        MapView source = (MapView) e.getSource();
        for(ElementView ev : source.getElementViews()) {
            if(ev.elementAt(e.getPoint())) {
                if (ev instanceof TermView) {
                    termFrom = (TermView) ev;
                    return;
                }
                termFrom = null;
                return;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Here2");
        MapView source = (MapView) e.getSource();
        for(ElementView ev : source.getElementViews()) {
            if(ev.elementAt(e.getPoint())) {
                if (ev instanceof TermView) {
                    termTo = (TermView) ev;
                } else termTo = null;
                break;
            }
        }

        if(termTo != null && termFrom != null && termTo != termFrom) {
            MindMap m = source.getMindMap();
            m.addChild(new Relation("Connection " + count++, m, (Term) termFrom.getElement(), (Term) termTo.getElement()));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
