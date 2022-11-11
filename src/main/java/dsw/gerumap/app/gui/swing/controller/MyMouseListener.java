package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
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

        if(e.getClickCount() == 2){
            if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project){
                Project p = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
                ProjectView pv = MainFrame.getInstance().getWorkspace().generateWorkspace();
                MainFrame.getInstance().getSplit().setRightComponent(pv);
                for(MapNode node : p.getChildren()) {
                    if(node instanceof MindMap) {
                        MapView mv = new MapView((MindMap) node);
                        pv.getMapsTabbedPane().addTab(mv.getMindMap().getName(), mv);
                    }
                }
            } else if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap){
                if(MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView) {
                    ProjectView pv = (ProjectView) MainFrame.getInstance().getSplit().getRightComponent();
                    MapView mv = new MapView((MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
                    JTabbedPane tabbedPane = pv.getMapsTabbedPane();
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
