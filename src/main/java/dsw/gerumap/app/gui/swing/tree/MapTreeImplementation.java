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
    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    // dodaje cvora u drvo
    @Override
    public void addChild(MapTreeItem parent) {
        if (parent == null) return; // Provera da li je parent null
        if (!(parent.getMapNode() instanceof MapNodeComposite)) return; // Provera da li je parent MapNodeComposite

        MapNode child = createChild(parent.getMapNode()); // Kreiranje deteta za cvor parent
        parent.add(new MapTreeItem(child)); // Dodavanje child-a u susede cvora parent
        ((MapNodeComposite) parent.getMapNode()).addChild(child); // Dodavanje MapNode komponente child-a MapNodeComposite komponenti parent-a
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    // Kreiranje child cvora
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

    // Uklanjanje datog cvora iz drveta
    @Override
    public void removeChild(DefaultMutableTreeNode root){
        for(int i = 0; i < root.getChildCount(); i++) {
            removeChild((DefaultMutableTreeNode) root.getChildAt(i));
        }
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) root.getParent();
        parent.remove(root);
        ((MapNodeComposite)((MapTreeItem)parent).getMapNode()).getChildren().remove(((MapTreeItem) root).getMapNode());
        treeModel.reload(parent);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }
}
