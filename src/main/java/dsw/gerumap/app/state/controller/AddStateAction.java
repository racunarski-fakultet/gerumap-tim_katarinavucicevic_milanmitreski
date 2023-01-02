package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;

public class AddStateAction extends AbstractGeRuMapAction {

    public AddStateAction() {
        putValue(SHORT_DESCRIPTION, "Add Element");
        putValue(SMALL_ICON, loadIcon("/addBtn.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView)
            MainFrame.getInstance().getWorkspace().getProjectView().startAddState();
        else
            AppCore.getInstance().getMessageGenerator().getMessage("NO PROJECT VIEW SPECIFIED FOR STATE CHANGE", MessageType.NO_PROJECT_VIEW_FOR_STATE);
    }
}