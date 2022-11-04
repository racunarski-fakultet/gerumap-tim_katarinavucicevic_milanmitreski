package dsw.gerumap.app.gui.swing.tree;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.Random;

public class MapTreeImplementation implements MapTree{

    // Konkretna implementacija interfejsa MapTree

    // Polja su treeView (kontrola nad GUI-jem) i treeModel (definisanje root-a)
    private MapTreeView treeView;
    private DefaultTreeModel treeModel;

    // Generisemo drvo generisanjem root-a i generisanjem modela i treeView-a
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    // dodaje cvora u drvo
    @Override
    public void addChild(MapTreeItem parent) {
        if (parent == null) return;
        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;

        MapNode child = createChild(parent.getMapNode());
        if(child == null) return;
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }


    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    private MapNode createChild(MapNode parent) {
        if (parent instanceof ProjectExplorer) {
            return new Project("Project" + new Random().nextInt(100), parent);
        }else if(parent instanceof Project){
            return new MindMap("MindMap" + new Random().nextInt(100), parent);
        } else if (parent instanceof MindMap) {
            return new Element("Element" + new Random().nextInt(100), parent);
        }
        return null;
    }

    @Override
    public void removeChild(DefaultMutableTreeNode root){

        root = (DefaultMutableTreeNode)treeModel.getRoot();
        root.removeFromParent();
        treeModel.reload();
    }
}
