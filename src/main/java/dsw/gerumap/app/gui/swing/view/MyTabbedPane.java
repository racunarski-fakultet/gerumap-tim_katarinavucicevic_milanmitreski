package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class MyTabbedPane extends JTabbedPane {

    private static int count = 1;

    private Icon icon;

    public MyTabbedPane(int tabPlacement, int tabLayoutPolicy) {

        super(tabPlacement, tabLayoutPolicy);

        JComponent panel1 = new JPanel();
        panel1.add(new JLabel("nesto"));
        //JComponent panel1 = makeTextPanel("Panel #1");
        this.addTab("Tab " + count, icon, panel1,
                "Does nothing");
        // this.setBounds(0,0,parentDimension.width,parentDimension.height - 50);
        count++;

        // this.add(MainFrame.getInstance().getActionManager().getAddTabAction());

    }



}
