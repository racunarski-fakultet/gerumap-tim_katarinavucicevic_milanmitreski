package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.gui.swing.view.SettingsDialog;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;

public class SettingsAction extends AbstractGeRuMapAction{

    public SettingsAction() {
        putValue(SMALL_ICON, loadIcon("/settings.png"));
        putValue(SHORT_DESCRIPTION, "Settings");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView && ((ProjectView) MainFrame.getInstance().getSplit().getRightComponent()).getMapsTabbedPane().getTabCount() != 0) {
            SettingsDialog settingsDialog = new SettingsDialog(MainFrame.getInstance(), "Settings");
            settingsDialog.setModal(true);
            settingsDialog.setVisible(true);
        } else
            AppCore.getInstance().getMessageGenerator().getMessage("NO MAP VIEW TO CHANGE SETTINGS FOR", MessageType.NO_MAP_VIEW_FOR_SETTINGS);

    }
}
