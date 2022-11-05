package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddAction extends AbstractGeRuMapAction{

    private MapTreeItem item;

    public AddAction() {
        putValue(NAME, "Add");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        item = MainFrame.getInstance().getMapTree().getSelectedNode();
        MainFrame.getInstance().getMapTree().addChild(item);

    }
}
