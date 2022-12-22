package dsw.gerumap.app.state.model;

import dsw.gerumap.app.command.commands.DeleteElementCommand;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.RelationView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteState implements State {

    private DeleteElementCommand deleteElementCommand;

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() != MouseEvent.BUTTON1) return;
        MapView mapView = (MapView) e.getSource();
        MindMap mindMap = mapView.getMindMap();
        Point pos = new Point((int) ((e.getPoint().getX()-mapView.getxTranslate())/mapView.getScalingFactor()), (int) ((e.getPoint().getY()-mapView.getyTranslate())/mapView.getScalingFactor()));
        ElementView deleted = null;
        Iterator<ElementView> it = mapView.getElementViews().iterator();
        while(it.hasNext()) {
            ElementView elementView = it.next();
            if (elementView.elementAt(pos)) {
                if(mapView.getSelectedElements().contains(elementView)) mapView.addSelected(null);
                deleteElementCommand = new DeleteElementCommand(mindMap, elementView.getElement());
                mindMap.getCommandManager().addCommand(deleteElementCommand);
                deleted = elementView;
                break;
            }
        }
        if(deleted instanceof TermView) {
            List<Relation> relationList = new ArrayList<>();
            it = mapView.getElementViews().iterator();
            while (it.hasNext()) {
                ElementView elementView = it.next();
                if(elementView instanceof RelationView) {
                    RelationView relationView = (RelationView) elementView;
                    Relation relation = (Relation) relationView.getElement();
                    if(relation.getTermTo().equals(deleted.getElement()) || relation.getTermFrom().equals(deleted.getElement())) {
                        relationList.add(relation);
                    }
                }
            }
            for(Relation r : relationList) {
                deleteElementCommand = new DeleteElementCommand(mindMap, r);
                mindMap.getCommandManager().addCommand(deleteElementCommand);
                //mindMap.removeChild(r);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
