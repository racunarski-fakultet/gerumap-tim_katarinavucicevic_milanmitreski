package dsw.gerumap.app.gui.swing;

import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MessageOptionPane;
import dsw.gerumap.app.message.Message;

public class SwingGui implements Gui {

    public MainFrame mainFrame;

    public SwingGui() {

    }

    @Override
    public void start() {
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Message) {
            MessageOptionPane messageOptionPane = new MessageOptionPane(mainFrame, (Message) notification);
            messageOptionPane.setVisible(true);
        }
    }
}
