package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ConnectStateAction extends AbstractGeRuMapAction {

    public ConnectStateAction() {

        putValue(NAME, "C");
        putValue(SHORT_DESCRIPTION, "connect");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().startConnectState();
    }
}
