package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu(("Help"));
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        helpMenu.add(MainFrame.getInstance().getActionManager().getEditAction());
        /// dodati Help -> edit na ToolBar

        this.add(fileMenu);
        this.add(helpMenu);
    }
}
