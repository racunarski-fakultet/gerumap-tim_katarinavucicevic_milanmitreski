package dsw.gerumap.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerEdit implements MouseListener {

    private boolean isMouseOut = false;

    public void mouseExited(MouseEvent e) {
        isMouseOut = true;
    }

    public void mouseEntered(MouseEvent e) {
        isMouseOut = false;
        System.out.println("Im in helpMenu region");
        Object eSource = e.getSource();
        if (eSource instanceof EditAction) {
            ((JMenuItem) eSource).doClick();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
