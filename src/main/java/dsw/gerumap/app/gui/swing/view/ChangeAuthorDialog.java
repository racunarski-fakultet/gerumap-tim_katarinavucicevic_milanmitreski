package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeAuthorDialog extends JDialog implements ActionListener {

    private final JTextField authorData;
    private final Project project;

    public ChangeAuthorDialog(Frame owner, String title, Project project) {
        super(owner, title);
        this.project = project;
        setBounds(0, 0, 350, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        Container dialogContent = getContentPane();
        dialogContent.setLayout(new FlowLayout());

        JLabel labelAuthor = new JLabel("Insert author name: ");
        authorData = new JTextField();
        authorData.setColumns(15);
        JButton saveAuthorButton = new JButton();
        saveAuthorButton.setAction(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(authorData.getText().equals("")) {
                    AppCore.getInstance().getMessageGenerator().getMessage("Author name can't be empty", MessageType.NAME_CANNOT_BE_EMPTY);
                    return;
                }
                project.setAuthor(authorData.getText());
                dispose();
            }
        });
        JButton closeButton = new JButton();
        closeButton.setAction(new AbstractAction("Close") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        add(labelAuthor);
        add(authorData);
        add(saveAuthorButton);
        add(closeButton);
    }

    public Project getProject() {
        return project;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dispose();
    }
}
