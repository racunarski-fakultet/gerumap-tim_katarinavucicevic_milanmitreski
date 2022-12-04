package dsw.gerumap.app.gui.swing.controller;

import com.sun.tools.javac.Main;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    private boolean isMouseOut = false;

    public void mouseExited(MouseEvent e) {
        isMouseOut = true;
    }


    public void mouseEntered(MouseEvent e) {
        isMouseOut = false;
        Object eSource = e.getSource();
        if (eSource instanceof EditAction) {
            ((JMenuItem) eSource).doClick();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() != MouseEvent.BUTTON1) return;
        if(e.getClickCount() == 2){
            if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project){
                for(ProjectView pv : MainFrame.getInstance().getProjectViews()) {
                    if(pv.getProject().equals(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode())) {
                        MainFrame.getInstance().getSplit().setRightComponent(pv);
                        return;
                    }
                }
                ProjectView pv = MainFrame.getInstance().getWorkspace().generateWorkspace();
                MainFrame.getInstance().getProjectViews().add(pv);
                MainFrame.getInstance().getSplit().setRightComponent(pv);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
