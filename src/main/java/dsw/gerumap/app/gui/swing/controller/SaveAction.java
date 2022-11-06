package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.ChangeAuthorDialog;
import dsw.gerumap.app.gui.swing.view.SaveAuthorButton;

import java.awt.event.ActionEvent;

public class SaveAction extends AbstractGeRuMapAction{

    public SaveAction() { putValue(NAME, "Sacuvaj");}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object objSource = actionEvent.getSource();
        if(objSource instanceof SaveAuthorButton) {
            ChangeAuthorDialog changeAuthorDialog = ((SaveAuthorButton)objSource).getChangeAuthorDialog();
            changeAuthorDialog.getProject().setAuthor(changeAuthorDialog.getAuthorData().getText());
            changeAuthorDialog.dispose();
        }
    }
}
