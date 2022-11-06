package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class InfoDialog extends JDialog {

    /// klaza za Info dugme, implementira se u ActionbManager, Toolbar i InfoAction

    private JLabel podaciL1;
    private JLabel podaciL2;

    private OkInfoButton okInfoButton;
    private String putanjaDoSlike;


    public InfoDialog(Frame owner, String title) {
        super(owner, title);

        setBounds(100, 100, 300, 120);
        setResizable(false);
        Container dialogContent = getContentPane();
        dialogContent.setLayout(new FlowLayout()); /// ako se promeni ovaj FlowLayout onda moze da se menja raspored komponenti

        podaciL1 = new JLabel("Student1: Milan Mitreski, 80/21rn");
        podaciL2 = new JLabel("Student2: Katarina Vučićević, 57/21rn");
        okInfoButton = new OkInfoButton(MainFrame.getInstance().getActionManager().getOkAction(), this);

        add(podaciL1);
        add(podaciL2);
        add(okInfoButton);

    }
}
