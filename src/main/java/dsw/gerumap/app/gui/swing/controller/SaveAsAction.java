package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAsAction extends AbstractGeRuMapAction{

    public SaveAsAction() {
        putValue(NAME, "Save as");
        putValue(SHORT_DESCRIPTION, "Save as project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getMapTree().getSelectedNode() == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected project", MessageType.NODE_NOT_SELECTED);
            return;
        } else {
            if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) {
                AppCore.getInstance().getMessageGenerator().getMessage("Only Projects can be saved", MessageType.ONLY_PROJECT_SERIALIZABLE);
                return;
            }
        }

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile;

        JFileChooser jfc = new JFileChooser();
        if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            projectFile = jfc.getSelectedFile();
            project.setFilePath(projectFile.getPath());
        } else {
            return;
        }
        project.setChanged(false);
        AppCore.getInstance().getSerializer().saveProject(project);
    }
}
