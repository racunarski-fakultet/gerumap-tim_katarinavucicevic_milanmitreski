package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SelectStateAction extends AbstractGeRuMapAction {

    public SelectStateAction() {

        putValue(NAME, "Select element");
        putValue(SHORT_DESCRIPTION, "Select Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().startSelectState();
    }
}
