package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.controller.MyMouseListener;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu(("Help"));

        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());

        JMenuItem changeAuthorItem = new JMenuItem("Change author");
        fileMenu.add(changeAuthorItem);


        this.add(fileMenu);
        this.add(helpMenu);

        JMenu editMenu = new JMenu("Edit");

        JMenuItem renameItem = new JMenuItem("Rename");  /// ovo mora da se menja koa ovo ispod

        editMenu.add(MainFrame.getInstance().getActionManager().getAddAction());
        editMenu.add(renameItem);
        editMenu.add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
        helpMenu.add(editMenu);

        MyMouseListener mouseListener = new MyMouseListener();

        helpMenu.addMouseListener(mouseListener);
    }




}
