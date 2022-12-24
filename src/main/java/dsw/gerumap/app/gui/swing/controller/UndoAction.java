package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGeRuMapAction{

    public UndoAction(){
        putValue(NAME, "UNDO");
        putValue(SHORT_DESCRIPTION, "UNDO");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapView mapView = (MapView)MainFrame.getInstance().getWorkspace().getProjectView().getMapsTabbedPane().getSelectedComponent();
        mapView.getMindMap().getCommandManager().undoCommand();
    }
}
