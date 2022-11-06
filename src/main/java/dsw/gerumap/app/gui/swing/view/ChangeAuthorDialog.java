package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;

public class ChangeAuthorDialog extends JDialog {

    private JLabel podaciL1;
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

        podaciL1 = new JLabel("Unesite ime autora: ");
        authorData = new JTextField();
        saveAuthorButton = new SaveAuthorButton(MainFrame.getInstance().getActionManager().getSaveAction(), this);
        saveAuthorButton.setName("Sacuvaj");

        authorData.setColumns(15);

        add(podaciL1);
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
