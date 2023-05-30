package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ExportAction extends AbstractGeRuMapAction{

    public ExportAction() {
        putValue(NAME, "Export");
        putValue(SHORT_DESCRIPTION, "Export selected MindMap as image");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView) {
            ProjectView projectView = (ProjectView) MainFrame.getInstance().getSplit().getRightComponent();
            if(projectView.getMapsTabbedPane().getSelectedComponent() instanceof MapView) {
                MapView mapView = (MapView) projectView.getMapsTabbedPane().getSelectedComponent();
                JFileChooser jfc = new JFileChooser();
                if(jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    File imageFile = jfc.getSelectedFile();
                    mapView.exportImage(imageFile);
                }
            }
        } else {
            AppCore.getInstance().getMessageGenerator().getMessage("Open MindMap to be exported as image", MessageType.NO_MIND_MAP_TO_EXPORT);
        }
    }
}
