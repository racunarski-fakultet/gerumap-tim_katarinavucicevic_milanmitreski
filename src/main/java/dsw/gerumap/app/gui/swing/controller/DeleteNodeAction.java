package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;


public class DeleteNodeAction extends AbstractGeRuMapAction{

    private MapTreeItem item;

    private MapNodeComposite mapNodeComposite;

    /// kad se klikne dugme treba da se obrise selektovani node

    public DeleteNodeAction(){
        putValue(NAME, "Delete");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        item = MainFrame.getInstance().getMapTree().getSelectedNode();

        if(item.getMapNode().getParent() instanceof MapNodeComposite){
            mapNodeComposite = (MapNodeComposite) item.getMapNode().getParent();
            mapNodeComposite.getChildren().remove(item);
        }

        MainFrame.getInstance().getMapTree().removeChild(item);

    }
}
