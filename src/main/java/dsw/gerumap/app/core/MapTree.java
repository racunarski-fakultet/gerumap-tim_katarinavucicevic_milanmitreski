package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

import javax.swing.tree.DefaultMutableTreeNode;

public interface MapTree {

    // Interfejs kojim opisujemo povezivanje modela definisanog u mapRepository sa GUI-jem

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();

    void rename(MapTreeItem node, String newName);

    void removeChild(DefaultMutableTreeNode root);

    void newProject();

    void loadProject(Project project);

    void loadTemplate(MindMap template);
}
