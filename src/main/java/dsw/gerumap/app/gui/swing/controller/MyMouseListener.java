package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.MyTabbedPane;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
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

        if(e.getClickCount() == 2){
            if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project){
                ProjectView pv = MainFrame.getInstance().getWorkspace().generateWorkspace();
                MainFrame.getInstance().getSplit().setRightComponent(pv);
            } else if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap){
                if(MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView) {
                    ProjectView pv = (ProjectView) MainFrame.getInstance().getSplit().getRightComponent();
                    MapView mv = new MapView();
                    mv.setSize(new Dimension(pv.getSize().width, pv.getSize().height - 50));
                    JTabbedPane tabbedPane = pv.getMapsTabbedPane();
                    tabbedPane.setVisible(true);
                    tabbedPane.setSize(new Dimension(pv.getSize().width, pv.getSize().height - 50));
                    System.out.println(tabbedPane);
                    tabbedPane.addTab(mv.getMindMap().getName(), mv);
                }
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
