package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.RenameDialog;
import dsw.gerumap.app.gui.swing.view.SettingsDialog;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;

public class SettingsAction extends AbstractGeRuMapAction{

    public SettingsAction() {

        putValue(NAME, "S");
        putValue(SHORT_DESCRIPTION, "Settings");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SettingsDialog settingsDialog = new SettingsDialog(MainFrame.getInstance(), "Settings");
        settingsDialog.setModal(true);
        settingsDialog.setVisible(true);

    }
}
