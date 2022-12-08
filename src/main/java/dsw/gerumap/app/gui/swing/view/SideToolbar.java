package dsw.gerumap.app.gui.swing.view;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class SideToolbar extends JToolBar {

    public SideToolbar() {
        super(VERTICAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getAddStateAction());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveStateAction());
        add(MainFrame.getInstance().getActionManager().getSelectStateAction());
        add(MainFrame.getInstance().getActionManager().getRefactorStateAction());
        add(MainFrame.getInstance().getActionManager().getConnectStateAction());
        add(MainFrame.getInstance().getActionManager().getSettingsAction());
        add(MainFrame.getInstance().getActionManager().getZoomInAction());
        add(MainFrame.getInstance().getActionManager().getZoomOutAction());
    }
}
