package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.ChangeAuthorDialog;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;

public class ChangeAuthorAction extends AbstractGeRuMapAction{

    public ChangeAuthorDialog changeAuthorDialog;
    public ChangeAuthorAction() {
        putValue(NAME, "Author");
        putValue(SMALL_ICON, loadIcon("/authorBtn.png"));
        putValue(SHORT_DESCRIPTION, "Change project author");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(MainFrame.getInstance().getMapTree().getSelectedNode() == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected Project.", MessageType.NODE_NOT_SELECTED);
        }
        else if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project) {
            changeAuthorDialog = new ChangeAuthorDialog(MainFrame.getInstance(), "Author", (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
            changeAuthorDialog.setModal(true);
            changeAuthorDialog.setVisible(true);
        } else {
            AppCore.getInstance().getMessageGenerator().getMessage("Selected node not Project", MessageType.NODE_NOT_PROJECT);
        }
    }
}
