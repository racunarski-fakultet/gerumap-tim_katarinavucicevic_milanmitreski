package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadTemplateAction extends AbstractGeRuMapAction{

    public LoadTemplateAction() {
        putValue(NAME, "Load template");
        putValue(SHORT_DESCRIPTION, "Load template from template library");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser jfc = new JFileChooser(MindMap.getTemplatePath());
        if(!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected Project to make MindMap for", MessageType.NO_PROJECT_SELECTED);
        }
        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                if(file.getParent().equals(MindMap.getTemplatePath())) {
                    MindMap mindMap = AppCore.getInstance().getSerializer().loadTemplate(file);
                    MainFrame.getInstance().getMapTree().loadTemplate(project, mindMap);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
