package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialog extends JDialog {

    private boolean toggled = false;

    public SettingsDialog(Frame owner, String title) {
        super(owner, title);

        setBounds(0, 0, 500, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        Container dialogContent = getContentPane();
        dialogContent.setLayout(new FlowLayout()); /// ako se promeni ovaj FlowLayout onda moze da se menja raspored komponenti


        JButton saveBtn = new JButton("Save");
        JButton closeBtn = new JButton("Close");
        JButton colorPickBtn = new JButton("pick a color");
        JColorChooser colorChooser;
        colorChooser = new JColorChooser(Color.BLACK); // defaultna boja je crna

        colorPickBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                toggleColorChooser(colorChooser, colorPickBtn); // show i hide za color chooser
            }
        });
        colorPickBtn.setBounds(10, 11, 150, 23);
        add(colorPickBtn);


        colorChooser.setBorder(null);
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                colorChanged(colorChooser, colorPickBtn); // da se promeni pozadina dugmeta
            }
        });



        closeBtn.setAction(new AbstractAction("Close") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });


        add(saveBtn);
        add(closeBtn);
    }

    protected void toggleColorChooser(JColorChooser colorChooser, JButton button) {
        if (toggled) {
            remove(colorChooser);
        } else {
            colorChooser.setBounds(button.getX(), button.getY() + 20, 600, 300);
            colorChooser.setVisible(true);
            add(colorChooser);
        }
        toggled = !toggled;
        validate();
        repaint();
    }

    protected void colorChanged(JColorChooser colorChooser, JButton button) {
        button.setBackground(colorChooser.getSelectionModel().getSelectedColor());
    }
}
