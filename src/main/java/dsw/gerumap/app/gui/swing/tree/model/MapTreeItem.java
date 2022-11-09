package dsw.gerumap.app.gui.swing.tree.model;

import dsw.gerumap.app.mapRepository.composite.MapNode;

import javax.swing.tree.DefaultMutableTreeNode;

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

}
