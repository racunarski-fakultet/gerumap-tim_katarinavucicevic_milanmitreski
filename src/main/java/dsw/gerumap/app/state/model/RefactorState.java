package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.*;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;

public class RefactorState implements State {
    @Override
    public void mousePressed(MouseEvent e) {

        RefactorDialog refactorDialog = new RefactorDialog(MainFrame.getInstance(), "Refactor Dialog");
        refactorDialog.setModal(true);
        refactorDialog.setVisible(true);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
