package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RenameDialog extends JDialog {

    private final JTextField tf;

    public RenameDialog(Frame owner, String title, MapTreeItem mapTreeItem) {
        super(owner, title);

        setBounds(0, 0, 325, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        Container dialogContent = getContentPane();
        dialogContent.setLayout(new FlowLayout());

        JLabel lblProjectName = new JLabel("Insert new name: ");
        tf = new JTextField();
        tf.setColumns(15);
        JButton saveBtn = new JButton("Save");
        JButton closeBtn = new JButton("Close");

        saveBtn.setAction(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(tf.getText().equals("")) {
                    AppCore.getInstance().getMessageGenerator().getMessage("Name can't be empty", MessageType.NAME_CANNOT_BE_EMPTY);
                    return;
                }
                MainFrame.getInstance().getMapTree().rename(mapTreeItem, tf.getText());
                dispose();
            }
        });

        closeBtn.setAction(new AbstractAction("Close") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        add(lblProjectName);
        add(tf);
        add(saveBtn);
        add(closeBtn);
    }

}
