package dsw.gerumap.app.gui.swing.controller;


import com.sun.tools.javac.Main;
import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.tree.MapTree;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;
import dsw.gerumap.app.message.MessageType;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;


public class DeleteNodeAction extends AbstractGeRuMapAction{

    /// kad se klikne dugme treba da se obrise selektovani node

    public DeleteNodeAction(){
        putValue(NAME, "Delete");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selectedNode = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selectedNode == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected node to delete.", MessageType.NODE_NOT_SELECTED);
        }
        else if(!(selectedNode.getMapNode() instanceof ProjectExplorer)) {
            System.out.println(selectedNode.getMapNode().getName());
            MainFrame.getInstance().getMapTree().removeChild(selectedNode);
        } else {
            AppCore.getInstance().getMessageGenerator().getMessage("Unable to delete ProjectExplorer.", MessageType.NODE_CANNOT_BE_DELETED);
        }
    }
}
