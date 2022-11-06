package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Project;

import javax.swing.*;

public class SaveAuthorButton extends JButton {

    private ChangeAuthorDialog changeAuthorDialog;

    public SaveAuthorButton(Action a, ChangeAuthorDialog changeAuthorDialog) {
        super(a);
        this.changeAuthorDialog = changeAuthorDialog;
    }

    public ChangeAuthorDialog getChangeAuthorDialog() {
        return changeAuthorDialog;
    }
}
