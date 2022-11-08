package dsw.gerumap.app.gui.swing.tree.model;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public MapTreeItem(MapNode nodeModel) {
        this.mapNode = nodeModel;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name) {
        this.mapNode.setName(name);
    }

    public MapNode getMapNode() {
        return mapNode;
    }

    @Override
    public void add(MutableTreeNode newChild) {
        super.add(newChild);
        ((MapNodeComposite) this.getMapNode()).addChild(((MapTreeItem)newChild).getMapNode());
    }
}
