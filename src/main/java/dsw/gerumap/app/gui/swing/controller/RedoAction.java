package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractGeRuMapAction{

    public RedoAction(){
        putValue(NAME, "REDO");
        putValue(SHORT_DESCRIPTION, "REDO");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapView mapView = (MapView) MainFrame.getInstance().getWorkspace().getProjectView().getMapsTabbedPane().getSelectedComponent();
        mapView.getMindMap().getCommandManager().doCommand();
    }
}
