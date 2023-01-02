package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.RenameDialog;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;

public class RenameAction extends AbstractGeRuMapAction{

    public RenameAction() {
        putValue(SMALL_ICON, loadIcon("/renameBtn.png"));
        putValue(SHORT_DESCRIPTION, "Rename");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getMapTree().getSelectedNode() == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected Project.", MessageType.NODE_NOT_SELECTED);
        }
        else if(!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof ProjectExplorer)) {
            RenameDialog renameDialog = new RenameDialog(MainFrame.getInstance(), "Rename", MainFrame.getInstance().getMapTree().getSelectedNode());
            renameDialog.setModal(true);
            renameDialog.setVisible(true);
        } else {
            AppCore.getInstance().getMessageGenerator().getMessage("Can't rename ProjectExplorer", MessageType.NODE_CANNOT_BE_RENAMED);
        }
    }
}
