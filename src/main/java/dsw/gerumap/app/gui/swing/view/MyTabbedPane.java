package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class MyTabbedPane extends JTabbedPane {

    private static int count = 1;

    private Icon icon;

    public MyTabbedPane(int tabPlacement, int tabLayoutPolicy) {

        super(tabPlacement, tabLayoutPolicy);

        JComponent panel1 = new JPanel();
        //JComponent panel1 = makeTextPanel("Panel #1");
        this.addTab("Tab " + count, icon, panel1,
                "Does nothing");

        this.setBounds(50,50,200,200);
        count++;

        // this.add(MainFrame.getInstance().getActionManager().getAddTabAction());

    }



}
