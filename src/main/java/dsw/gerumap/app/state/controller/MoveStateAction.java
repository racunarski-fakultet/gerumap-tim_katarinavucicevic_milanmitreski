package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;

public class MoveStateAction extends AbstractGeRuMapAction {

    public MoveStateAction() {
        putValue(SHORT_DESCRIPTION, "Move Element");
        putValue(SMALL_ICON, loadIcon("/moveBtn.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView)
            MainFrame.getInstance().getWorkspace().getProjectView().startMoveState();
        else
            AppCore.getInstance().getMessageGenerator().getMessage("NO PROJECT VIEW SPECIFIED FOR STATE CHANGE", MessageType.NO_PROJECT_VIEW_FOR_STATE);
    }
}
