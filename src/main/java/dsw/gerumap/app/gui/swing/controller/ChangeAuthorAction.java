package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.ChangeAuthorDialog;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Project;

import java.awt.event.ActionEvent;

public class ChangeAuthorAction extends AbstractGeRuMapAction{

    public ChangeAuthorDialog changeAuthorDialog;
    public ChangeAuthorAction() { putValue(NAME, "Autor"); }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(MainFrame.getInstance().getMapTree().getSelectedNode() != null && MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project) {
            changeAuthorDialog = new ChangeAuthorDialog(MainFrame.getInstance(), "Autor", (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
            changeAuthorDialog.setModal(true);
            changeAuthorDialog.setVisible(true);
        }
    }
}
