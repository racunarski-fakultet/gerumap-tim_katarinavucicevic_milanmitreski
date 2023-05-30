package dsw.gerumap.app.state.model;

import dsw.gerumap.app.command.commands.DeleteElementCommand;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DeleteState implements State {

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() != MouseEvent.BUTTON1) return;
        MapView mapView = (MapView) e.getSource();
        MindMap mindMap = mapView.getMindMap();
        Point pos = new Point((int) ((e.getPoint().getX()-mapView.getxTranslate())/mapView.getScalingFactor()), (int) ((e.getPoint().getY()-mapView.getyTranslate())/mapView.getScalingFactor()));
        for (ElementView elementView : mapView.getElementViews()) {
            if (elementView.elementAt(pos)) {
                if (mapView.getSelectedElements().contains(elementView)) {
                    break;
                }
                DeleteElementCommand deleteElementCommand = new DeleteElementCommand(mindMap, elementView.getElement());
                mindMap.getCommandManager().addCommand(deleteElementCommand);
                break;
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
