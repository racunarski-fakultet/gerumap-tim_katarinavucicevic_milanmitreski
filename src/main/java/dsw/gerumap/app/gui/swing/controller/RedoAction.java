package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractGeRuMapAction{

    public RedoAction(){
        putValue(NAME, "REDO");
        putValue(SHORT_DESCRIPTION, "REDO");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        AppCore.getInstance().getGui().getCommandManager().doCommand();
    }
}
