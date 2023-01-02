package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Objects;

public class LoadTemplateAction extends AbstractGeRuMapAction{

    public LoadTemplateAction() {
        putValue(NAME, "Load template");
        putValue(SHORT_DESCRIPTION, "Load template from template library");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if((!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) ||
            MainFrame.getInstance().getMapTree().getSelectedNode() == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected Project to make MindMap for", MessageType.NO_PROJECT_SELECTED);
            return;
        }
        JFileChooser jfc = new JFileChooser(Objects.requireNonNull(getClass().getResource(MindMap.getTemplatePath())).getPath());
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                if(file.getParent().equals(Objects.requireNonNull(getClass().getResource(MindMap.getTemplatePath())).getPath())) {
                    MindMap mindMap = AppCore.getInstance().getSerializer().loadTemplate(file);
                    MainFrame.getInstance().getMapTree().loadTemplate(mindMap);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
