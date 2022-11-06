package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.InfoDialog;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class InfoAction extends AbstractGeRuMapAction{

    private InfoDialog infoDialog;
    public InfoAction(){
        putValue(NAME, "Info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        infoDialog = new InfoDialog(MainFrame.getInstance(), "Info");
        infoDialog.setModal(true);
        infoDialog.setVisible(true);
    }
}
