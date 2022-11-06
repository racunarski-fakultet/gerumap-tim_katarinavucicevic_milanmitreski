package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.OkInfoButton;

import java.awt.event.ActionEvent;

public class OkAction extends AbstractGeRuMapAction{


    public OkAction() {putValue(NAME, "Ok");}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object objSource = actionEvent.getSource();
        if(objSource instanceof OkInfoButton)
            ((OkInfoButton) objSource).getInfoDialog().dispose();
    }
}
