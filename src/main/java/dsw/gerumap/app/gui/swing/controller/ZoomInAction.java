package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.ProjectView;

import java.awt.event.ActionEvent;

public class ZoomInAction extends AbstractGeRuMapAction{

    public ZoomInAction() {
        putValue(SMALL_ICON, loadIcon("/zoomIn.png"));
        putValue(SHORT_DESCRIPTION, "Zoom in");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView) {
            ProjectView pv = (ProjectView) MainFrame.getInstance().getSplit().getRightComponent();
            MapView mv = (MapView) pv.getMapsTabbedPane().getSelectedComponent();
            mv.zoomIn();
        }
    }
}
