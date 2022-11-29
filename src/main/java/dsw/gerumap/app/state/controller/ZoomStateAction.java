package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomStateAction extends AbstractGeRuMapAction {

    public ZoomStateAction() {

        putValue(NAME, "Zoom element");
        putValue(SHORT_DESCRIPTION, "Zoom Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().startZoomState();
    }
}
