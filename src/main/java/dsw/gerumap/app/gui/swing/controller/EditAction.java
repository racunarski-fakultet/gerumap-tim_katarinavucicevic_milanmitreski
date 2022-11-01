package dsw.gerumap.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;


public class EditAction extends AbstractGeRuMapAction{

    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_E, ActionEvent.ALT_MASK));
        putValue(NAME, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }



}
