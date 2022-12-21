package dsw.gerumap.app.gui.swing.controller;


import com.sun.tools.javac.Main;
import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;


public class DeleteNodeAction extends AbstractGeRuMapAction{

    /// kad se klikne dugme treba da se obrise selektovani node

    public DeleteNodeAction(){
        putValue(NAME, "Delete");
        putValue(SMALL_ICON, loadIcon("/deleteBtn.png"));
        putValue(SHORT_DESCRIPTION, "Delete");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selectedNode = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selectedNode == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected node to delete.", MessageType.NODE_NOT_SELECTED);
        }
        else if(!(selectedNode.getMapNode() instanceof ProjectExplorer)) {
            if(selectedNode.getMapNode() instanceof Project) {
                Project project = (Project) selectedNode.getMapNode();
                ProjectView projectView = null;
                for (ProjectView pv : MainFrame.getInstance().getProjectViews()) {
                    if (pv.getProject().equals(project)){
                        projectView = pv;
                        break;
                    }
                }
                MainFrame.getInstance().getProjectViews().remove(projectView);
            }
            System.out.println(selectedNode.getMapNode().getName());
            MainFrame.getInstance().getMapTree().removeChild(selectedNode);
        } else {
            AppCore.getInstance().getMessageGenerator().getMessage("Unable to delete ProjectExplorer.", MessageType.NODE_CANNOT_BE_DELETED);
        }
    }
}
