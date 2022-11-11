package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class MyTabbedPane extends JTabbedPane {

    private static int count = 1;

    private Icon icon;

    public MyTabbedPane(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);
    }

    @Override
    public JRootPane getRootPane() {
        return super.getRootPane();
    }

}
