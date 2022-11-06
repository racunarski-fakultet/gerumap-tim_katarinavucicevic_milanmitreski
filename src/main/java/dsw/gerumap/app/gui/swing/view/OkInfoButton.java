package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class OkInfoButton extends JButton{

    private InfoDialog infoDialog;

    public OkInfoButton(Action a, InfoDialog infoDialog) {
        super(a);
        this.infoDialog = infoDialog;
    }

    public InfoDialog getInfoDialog() {
        return infoDialog;
    }
}
