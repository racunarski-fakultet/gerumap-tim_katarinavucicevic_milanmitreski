package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractGeRuMapAction{

        public ExitAction() {
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                    KeyEvent.VK_F4, InputEvent.ALT_MASK));

            putValue(NAME, "Exit");
            putValue(SMALL_ICON, loadIcon("/exitBtn.png"));
            putValue(SHORT_DESCRIPTION, "Exit");
        }

        public void actionPerformed(ActionEvent arg0) {
            MainFrame.getInstance().dispose();
            System.exit(0);
        }



}
