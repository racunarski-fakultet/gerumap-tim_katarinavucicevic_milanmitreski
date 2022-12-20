package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGeRuMapAction{

    public UndoAction(){
        putValue(NAME, "UNDO");
        putValue(SHORT_DESCRIPTION, "UNDO");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AppCore.getInstance().getGui().getCommandManager().undoCommand();
    }
}
