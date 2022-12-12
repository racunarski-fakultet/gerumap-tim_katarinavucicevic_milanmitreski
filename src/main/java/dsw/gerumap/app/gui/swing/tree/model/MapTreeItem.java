package dsw.gerumap.app.gui.swing.tree.model;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;
import dsw.gerumap.app.message.MessageType;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class MapTreeItem extends DefaultMutableTreeNode {

    private final MapNode mapNode;

    public MapTreeItem(MapNode nodeModel) {
        this.mapNode = nodeModel;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name) {
        if(!(this.getMapNode() instanceof ProjectExplorer))
            this.mapNode.setName(name);
        else
            AppCore.getInstance().getMessageGenerator().getMessage("Can't rename ProjectExplorer", MessageType.NODE_CANNOT_BE_RENAMED);
    }

    public MapNode getMapNode() {
        return mapNode;
    }

    @Override
    public void add(MutableTreeNode newChild) {
        super.add(newChild);
        AppCore.getInstance().getMapRepository().addChild(((MapNodeComposite) this.getMapNode()), ((MapTreeItem)newChild).getMapNode());
    }
}
