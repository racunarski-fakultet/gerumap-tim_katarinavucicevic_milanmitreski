package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGeRuMapAction{

    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "Create New Project");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        MainFrame.getInstance().getMapTree().newProject();
    }
}
