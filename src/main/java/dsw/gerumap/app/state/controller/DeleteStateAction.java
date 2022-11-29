package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DeleteStateAction extends AbstractGeRuMapAction {

    public DeleteStateAction() {

        putValue(NAME, "Delete element");
        putValue(SHORT_DESCRIPTION, "Delete Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().startDeleteState();
    }
}
