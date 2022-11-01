package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.controller.EditAction;
import dsw.gerumap.app.gui.swing.controller.MouseListenerEdit;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMenuBar extends JMenuBar {

    private boolean isMouseOut = true;

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

        JMenuItem addItem = new JMenuItem("ADD");
        JMenuItem renameItem = new JMenuItem("RENAME");
        JMenuItem deleteItem = new JMenuItem("DELETE");  /// funkcionalnosti vezane za cvorove u stablu

        editMenu.add(addItem);
        editMenu.add(renameItem);
        editMenu.add(deleteItem);
        helpMenu.add(editMenu);

        helpMenu.addMouseListener(new MouseListenerEdit(){

        });
    }




}
