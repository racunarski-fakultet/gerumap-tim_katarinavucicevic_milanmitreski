package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveTemplateAction extends AbstractGeRuMapAction{

    public SaveTemplateAction() {
        putValue(NAME, "Save template");
        putValue(SHORT_DESCRIPTION, "Save selected MindMap as template");
        putValue(LONG_DESCRIPTION, "Saves selected MindMap as template in .json format. Name of the saved file is same as the MindMap name.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap)) {
            AppCore.getInstance().getMessageGenerator().getMessage("Only MindMaps can be saved as template", MessageType.ONLY_MIND_MAPS_ARE_TEMPLATES);
            return;
        }

        MindMap mindMap = (MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        mindMap.setTemplate(true);
        AppCore.getInstance().getSerializer().saveTemplate(mindMap);
    }
}
