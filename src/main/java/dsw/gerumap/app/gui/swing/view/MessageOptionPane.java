package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.message.Message;

import javax.swing.*;
import java.awt.*;

public class MessageOptionPane extends JOptionPane {

    public MessageOptionPane(Frame owner, Message message) {
        setBounds(100, 100, 400, 100);
        JOptionPane.showMessageDialog(owner, message.toString());
    }
}
