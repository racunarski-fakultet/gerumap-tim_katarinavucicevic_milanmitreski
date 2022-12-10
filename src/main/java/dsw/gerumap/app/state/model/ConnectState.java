package dsw.gerumap.app.state.model;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.RelationView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.message.MessageType;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;

public class ConnectState implements State {

    private static int count = 0;

    private boolean drag;
    private TermView termFrom;
    private TermView termTo;
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() != MouseEvent.BUTTON1) return;
        MapView source = (MapView) e.getSource();
        for(ElementView ev : source.getElementViews()) {
            if(ev.elementAt(e.getPoint())) {
                if (ev instanceof TermView) {
                    drag = true;
                    ev.getElement().notifySubscriber(ev);
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
        if(e.getButton() != MouseEvent.BUTTON1) return;
        MapView source = (MapView) e.getSource();
        drag = false;
        /*
        for(ElementView ev : source.getElementViews()) {
            if (ev.elementAt(e.getPoint())) {
                if (ev instanceof TermView) {
                    termTo = (TermView) ev;
                } else termTo = null;
                break;
            }
        }
         */
        if(termTo != null && termFrom != null && termTo != termFrom) {
            for(ElementView ev : source.getElementViews()) {
                if(ev instanceof RelationView) {
                    RelationView rv = (RelationView) ev;
                    Relation r = (Relation) rv.getElement();
                    if((r.getTermFrom().equals(termFrom.getElement()) && r.getTermTo().equals(termTo.getElement())) || (r.getTermFrom().equals(termTo.getElement()) && r.getTermTo().equals(termFrom.getElement()))) {
                        AppCore.getInstance().getMessageGenerator().getMessage("FOUND RELATION BETWEEN " + r.getTermFrom().getName() + " AND " + r.getTermTo().getName(), MessageType.RELATION_FOUND_BETWEEN_TERMS);
                        return;
                    }
                }
            }
            MindMap m = source.getMindMap();
            m.addChild(new Relation("Connection " + count++, m, source.getStroke(), source.getColor(), (Term) termFrom.getElement(), (Term) termTo.getElement()));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MapView source = (MapView) e.getSource();
        for(ElementView ev : source.getElementViews()) {
            if (ev.elementAt(e.getPoint())) {
                if (ev instanceof TermView) {
                    ev.getElement().notifySubscriber(ev);
                    termTo = (TermView) ev;
                } else termTo = null;
                break;
            }
            source.repaint();
        }

    }
}
