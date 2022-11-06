package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;

public class ChangeAuthorDialog extends JDialog {

    private JLabel labelAuthor;
    private JTextField authorData;
    private SaveAuthorButton saveAuthorButton;

    private Project project;

    public ChangeAuthorDialog(Frame owner, String title, Project project) {
        super(owner, title);
        this.project = project;
        setBounds(100, 100, 400, 100);
        setResizable(false);
        Container dialogContent = getContentPane();
        dialogContent.setLayout(new FlowLayout()); /// ako se promeni ovaj FlowLayout onda moze da se menja raspored komponenti

        labelAuthor = new JLabel("Unesite ime autora: ");
        authorData = new JTextField();
        authorData.setColumns(15);
        saveAuthorButton = new SaveAuthorButton(MainFrame.getInstance().getActionManager().getSaveAction(), this);

        add(labelAuthor);
        add(authorData);
        add(saveAuthorButton);
    }

    public JTextField getAuthorData() {
        return authorData;
    }

    public SaveAuthorButton getSaveAuthorButton() {
        return saveAuthorButton;
    }

    public Project getProject() {
        return project;
    }
}
