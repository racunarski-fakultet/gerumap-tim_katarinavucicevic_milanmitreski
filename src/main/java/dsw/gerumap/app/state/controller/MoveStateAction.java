package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class MoveStateAction extends AbstractGeRuMapAction {

    public MoveStateAction() {

        putValue(NAME, "Move element");
        putValue(SHORT_DESCRIPTION, "Move Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().startMoveState();
    }
}
