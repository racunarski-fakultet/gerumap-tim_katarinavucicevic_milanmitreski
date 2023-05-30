package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InfoDialog extends JDialog {

    public InfoDialog(Frame owner, String title) {
        super(owner, title);

        setBounds(0, 0, 300, 120);
        setLocationRelativeTo(null);
        setResizable(false);
        Container dialogContent = getContentPane();
        dialogContent.setLayout(new FlowLayout());

        JLabel podaciL1 = new JLabel("Student1: Milan Mitreski, 80/21rn");
        JLabel podaciL2 = new JLabel("Student2: Katarina Vučićević, 57/21rn");
        JButton closeButton = new JButton();
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
