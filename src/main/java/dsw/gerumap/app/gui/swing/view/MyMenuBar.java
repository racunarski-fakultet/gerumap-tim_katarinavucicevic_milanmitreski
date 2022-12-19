package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu(("Help"));

        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem newProject = new JMenuItem();
        JMenuItem exit = new JMenuItem();
        JMenuItem save = new JMenuItem();
        JMenuItem saveAs = new JMenuItem();
        JMenuItem open = new JMenuItem();
        JMenuItem changeAuthorItem = new JMenuItem("Change author");
        newProject.setAction(MainFrame.getInstance().getActionManager().getNewProjectAction());
        newProject.setIcon(null);
        exit.setAction(MainFrame.getInstance().getActionManager().getExitAction());
        exit.setIcon(null);
        changeAuthorItem.setAction(MainFrame.getInstance().getActionManager().getChangeAuthorAction());
        changeAuthorItem.setIcon(null);
        save.setAction(MainFrame.getInstance().getActionManager().getSaveAction());
        save.setIcon(null);
        saveAs.setAction(MainFrame.getInstance().getActionManager().getSaveAsAction());
        saveAs.setIcon(null);
        open.setAction(MainFrame.getInstance().getActionManager().getOpenAction());
        open.setIcon(null);

        fileMenu.add(newProject);
        fileMenu.add(exit);
        fileMenu.add(changeAuthorItem);
        fileMenu.add(save);
        fileMenu.add(saveAs);
        fileMenu.add(open);

        JMenu editMenu = new JMenu("Edit");

        JMenuItem renameItem = new JMenuItem("Rename");  /// ovo mora da se menja koa ovo ispod
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem deleteItem = new JMenuItem("Delete");

        addItem.setAction(MainFrame.getInstance().getActionManager().getAddAction());
        addItem.setIcon(null);
        deleteItem.setAction(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
        deleteItem.setIcon(null);
        renameItem.setAction(MainFrame.getInstance().getActionManager().getRenameAction());
        renameItem.setIcon(null);
        editMenu.add(addItem);
        editMenu.add(renameItem);
        editMenu.add(deleteItem);
        helpMenu.add(editMenu);
        helpMenu.addMouseListener(MainFrame.getInstance().getActionManager().getMyMouseListener());
        this.add(fileMenu);
        this.add(helpMenu);
    }




}
