package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InfoDialog extends JDialog {

    /// klaza za Info dugme, implementira se u ActionbManager, Toolbar i InfoAction

    private JLabel podaciL1;
    private JLabel podaciL2;

    private JButton closeButton;
    private String putanjaDoSlike;


    public InfoDialog(Frame owner, String title) {
        super(owner, title);

        setBounds(0, 0, 300, 120);
        setLocationRelativeTo(null);
        setResizable(false);
        Container dialogContent = getContentPane();
        dialogContent.setLayout(new FlowLayout()); /// ako se promeni ovaj FlowLayout onda moze da se menja raspored komponenti

        podaciL1 = new JLabel("Student1: Milan Mitreski, 80/21rn");
        podaciL2 = new JLabel("Student2: Katarina Vučićević, 57/21rn");
        closeButton = new JButton();
        closeButton.setAction(new AbstractAction("Close") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        add(podaciL1);
        add(podaciL2);
        add(closeButton);
    }
}
