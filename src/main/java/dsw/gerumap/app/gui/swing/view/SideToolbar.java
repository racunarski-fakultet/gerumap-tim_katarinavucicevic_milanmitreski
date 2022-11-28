package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class SideToolbar extends JToolBar {

    public SideToolbar() {

        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getAddStateAction());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomStateAction());
        add(MainFrame.getInstance().getActionManager().getSelectStateAction());
    }
}
