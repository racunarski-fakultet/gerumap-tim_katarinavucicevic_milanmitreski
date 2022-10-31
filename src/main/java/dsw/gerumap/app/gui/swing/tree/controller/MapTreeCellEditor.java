package dsw.gerumap.app.gui.swing.tree.controller;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;
    private JTextField edit = null;

    public MapTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
        clickedOn = value;
        edit = new JTextField(value.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if(arg0 instanceof MouseEvent)
            if(((MouseEvent)arg0).getClickCount() == 3) {
                return true;
            }
        return false;
    }

    public void actionPerformed(ActionEvent e){

        if (!(clickedOn instanceof MapTreeItem))
            return;

        MapTreeItem clicked = (MapTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());
    }
}
