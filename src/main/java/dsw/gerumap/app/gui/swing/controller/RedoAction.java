package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractGeRuMapAction{

    public RedoAction(){
        putValue(SMALL_ICON, loadIcon("/redoBtn.png"));
        putValue(SHORT_DESCRIPTION, "Redo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapView mapView = (MapView) MainFrame.getInstance().getWorkspace().getProjectView().getMapsTabbedPane().getSelectedComponent();
        mapView.getMindMap().getCommandManager().doCommand();
    }
}
