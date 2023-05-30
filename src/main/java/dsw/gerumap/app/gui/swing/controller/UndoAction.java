package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGeRuMapAction{

    public UndoAction(){
        putValue(SMALL_ICON, loadIcon("/undoBtn.png"));
        putValue(SHORT_DESCRIPTION, "Undo");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapView mapView = (MapView)MainFrame.getInstance().getWorkspace().getProjectView().getMapsTabbedPane().getSelectedComponent();
        mapView.getMindMap().getCommandManager().undoCommand();
    }
}
