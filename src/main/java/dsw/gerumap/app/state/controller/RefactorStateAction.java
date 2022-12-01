package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class RefactorStateAction extends AbstractGeRuMapAction {

    public RefactorStateAction(){

        putValue(NAME, "R");
        putValue(SHORT_DESCRIPTION, "refactor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().startRefactorState();
    }
}
