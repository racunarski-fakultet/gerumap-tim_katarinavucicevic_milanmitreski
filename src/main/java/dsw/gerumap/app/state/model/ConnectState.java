package dsw.gerumap.app.state.model;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.command.commands.AddElementCommand;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.RelationView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.message.MessageType;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

public class ConnectState implements State {

    private GeneralPath generalPath;
    private TermView termFrom;
    private TermView termTo;
    private static int count = -1;

    @Override
    public void mousePressed(MouseEvent e) {
        termFrom = null;
        termTo = null;
        if(e.getButton() != MouseEvent.BUTTON1) return;
        MapView source = (MapView) e.getSource();
        Point realPoint =  new Point((int) ((e.getPoint().getX()-source.getxTranslate())/source.getScalingFactor()), (int) ((e.getPoint().getY()-source.getyTranslate())/source.getScalingFactor()));
        for(ElementView ev : source.getElementViews()) {
            if(ev.elementAt(realPoint)) {
                if (ev instanceof TermView) {
                    ev.getElement().notifySubscriber(ev);
                    termFrom = (TermView) ev;
                    generalPath = new GeneralPath();
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
        Point realPoint = new Point((int) ((e.getPoint().getX()-source.getxTranslate())/source.getScalingFactor()), (int) ((e.getPoint().getY()-source.getyTranslate())/source.getScalingFactor()));
        for(ElementView ev : source.getElementViews()) {
            if (ev.elementAt(realPoint)) {
                if (ev instanceof TermView) {
                    termTo = (TermView) ev;
                } else termTo = null;
                break;
            }
        }
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
            if(count == -1) count = source.getElementViews().size();
            Relation r = new Relation("Connection " + (++count),
                    m, source.getStroke(),
                    source.getColor(),
                    (Term) termFrom.getElement(),
                    (Term) termTo.getElement());
            r.addSubscriber(source);
            AddElementCommand addElementCommand = new AddElementCommand(m, r);
            m.getCommandManager().addCommand(addElementCommand);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(termFrom != null) {
            MapView source = (MapView) e.getSource();
            Point point = e.getPoint();
            generalPath.reset();
            source.repaint();
            double xFrom = ((Term)termFrom.getElement()).getXCoordinate()*source.getScalingFactor() + source.getxTranslate();
            double yFrom = ((Term)termFrom.getElement()).getYCoordinate()*source.getScalingFactor() + source.getyTranslate();

            double xTo = (point.getX());
            double yTo = (point.getY());

            double A = (yTo - yFrom) / (xTo - xFrom);
            double B = 150 * source.getScalingFactor()/(Math.sqrt(4 + 9 * A * A));

            double xCoordinateFrom;
            double yCoordinateFrom;

            double xCoordinateTo;
            double yCoordinateTo;

            if (xTo > xFrom) {
                xCoordinateFrom = xFrom + B;
                yCoordinateFrom = yFrom + A * B;

                xCoordinateTo = xTo;
                yCoordinateTo = yTo;
            } else {
                xCoordinateFrom = xFrom - B;
                yCoordinateFrom = yFrom - A * B;

                xCoordinateTo = xTo;
                yCoordinateTo = yTo;
            }
            generalPath.moveTo(xCoordinateFrom, yCoordinateFrom);
            generalPath.lineTo(xCoordinateTo, yCoordinateTo);
            generalPath.closePath();

            Graphics2D graphics2D = (Graphics2D) source.getGraphics();
            graphics2D.setColor(new Color(source.getColor()));
            graphics2D.setStroke(new BasicStroke(source.getStroke()));
            graphics2D.draw(generalPath);
        }
    }
}
