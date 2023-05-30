package dsw.gerumap.app.gui.swing.tree;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.core.MapTree;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class MapTreeImplementation implements MapTree {

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

    @Override
    public void addChild(MapTreeItem parent) {
        // Vec je provereno da li je parent == null ( u slucaju NewProject znamo da je ProjectExplorer vec instanciran prilikom pokretanja aplikacije)
        // Provera da li je parent MapNodeComposite je vec uradjena u AddAction-u

        MapNode child = createChild((MapNodeComposite) parent.getMapNode()); // Kreiranje deteta za cvor parent
        if(child == null) {
            AppCore.getInstance().getMessageGenerator().getMessage("Unable to add child to" + parent.getMapNode().getName(), MessageType.NODE_NOT_CREATED); // Ako Factory vrati null
        }
        parent.add(new MapTreeItem(child)); // Dodavanje child-a u susede cvora parent
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private MapNode createChild(MapNodeComposite parent) {
        return AppCore.getInstance().getMapRepository().getNodeFactory(parent).getNode(parent);
    }

    @Override
    public void rename(MapTreeItem node, String newName) {
        node.setName(newName);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void removeChild(DefaultMutableTreeNode root){
        for(int i = 0; i < root.getChildCount(); i++) {
            removeChild((DefaultMutableTreeNode) root.getChildAt(i));
        }
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) root.getParent();
        treeModel.removeNodeFromParent(root);
        ((MapNodeComposite)((MapTreeItem)parent).getMapNode()).removeChild(((MapTreeItem) root).getMapNode());
    }
    @Override
    public void newProject() {
        addChild((MapTreeItem) treeModel.getRoot());
        TreePath treePath = new TreePath(((MapTreeItem) treeModel.getRoot()).getPath());
        treeView.expandPath(treePath);
        treeView.setSelectionPath(null);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void loadProject(Project project) {
        ProjectExplorer projectExplorer = (ProjectExplorer) ((MapTreeItem) treeModel.getRoot()).getMapNode();
        projectExplorer.addChild(project);
        MapTreeItem projectItem = new MapTreeItem(project);
        for(MapNode child : project.getChildren()) {
            if(child instanceof MindMap) {
                projectItem.add(new MapTreeItem(child));
            }
        }
        ((MapTreeItem) treeModel.getRoot()).add(projectItem);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void loadTemplate(MindMap template) {
        Project project = (Project)this.getSelectedNode().getMapNode();
        project.addChild(template);
        this.getSelectedNode().add(new MapTreeItem(template));
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
