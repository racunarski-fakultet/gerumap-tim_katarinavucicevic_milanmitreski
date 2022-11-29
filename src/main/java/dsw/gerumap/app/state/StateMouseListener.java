package dsw.gerumap.app.state;

import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class StateMouseListener implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().getStateManager().getCurrent().mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().getStateManager().getCurrent().mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MainFrame.getInstance().getWorkspace().getProjectView().getStateManager().getCurrent().mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
