package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.message.MessageType;

import java.awt.event.ActionEvent;

public class AddAction extends AbstractGeRuMapAction{

    public AddAction() {

        putValue(NAME, "Add");
        putValue(SMALL_ICON, loadIcon("/addBtn.png"));
        putValue(SHORT_DESCRIPTION, "Add Project/MindMap/Element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getMapTree().getSelectedNode() == null ) {
            AppCore.getInstance().getMessageGenerator().getMessage("No selected node", MessageType.NODE_NOT_SELECTED);
            return;
        }
        else if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MapNodeComposite) {
            if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap) {
                AppCore.getInstance().getMessageGenerator().getMessage("Element can be added only using SideToolbar", MessageType.ELEMENT_ADDITION_EXCLUSIVE_TO_SIDE_TOOLBAR);
                return;
            }
            MainFrame.getInstance().getMapTree().addChild(MainFrame.getInstance().getMapTree().getSelectedNode());
        }
        else {
            AppCore.getInstance().getMessageGenerator().getMessage("Selected node is a leaf", MessageType.NODE_NOT_COMPOSITE);
        }
    }
}
