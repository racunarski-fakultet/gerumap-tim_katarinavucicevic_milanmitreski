package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;

public class AddAction extends AbstractGeRuMapAction{

    private MapTreeItem item;

    public AddAction() {
        putValue(NAME, "Add");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getMapTree().getSelectedNode() == null ) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected node to delete.", MessageType.NODE_NOT_SELECTED);
        }
        else if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MapNodeComposite) {
            MainFrame.getInstance().getMapTree().addChild(MainFrame.getInstance().getMapTree().getSelectedNode());
        }
        else {
            AppCore.getInstance().getMessageGenerator().getMessage("Selected node is a leaf", MessageType.NODE_NOT_COMPOSITE);
        }
    }
}
