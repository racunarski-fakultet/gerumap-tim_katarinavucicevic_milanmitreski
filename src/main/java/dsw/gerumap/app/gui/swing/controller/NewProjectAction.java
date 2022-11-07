package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class NewProjectAction extends AbstractGeRuMapAction{

    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New Node");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MapNodeComposite) {
            MainFrame.getInstance().getMapTree().addChild(MainFrame.getInstance().getMapTree().getSelectedNode());
            return;
        }
        AppCore.getInstance().getMessageGenerator().getMessage("Selected node is a leaf", MessageType.NODE_NOT_COMPOSITE);
    }
}
