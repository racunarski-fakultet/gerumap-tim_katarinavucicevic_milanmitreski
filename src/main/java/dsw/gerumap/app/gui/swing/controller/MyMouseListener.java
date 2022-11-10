package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MyTabbedPane;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

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
        //Object source = e.getSource();
        //MapTreeView mapTreeView = (MapTreeView) source;

        if(e.getClickCount() == 2){
            if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project){
                System.out.println("Lol");
                ProjectView pv = MainFrame.getInstance().getWorkspace().generateWorkspace();
                MainFrame.getInstance().getDesktop().add(pv);
                MainFrame.getInstance().getDesktop().revalidate();
                pv.updateWorkspace(MainFrame.getInstance().getDesktop());
                System.out.println("Desktop " + MainFrame.getInstance().getDesktop());

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
