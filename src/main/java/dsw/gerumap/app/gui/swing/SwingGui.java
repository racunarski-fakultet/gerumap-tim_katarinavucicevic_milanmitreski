package dsw.gerumap.app.gui.swing;

import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.view.MainFrame;

public class SwingGui implements Gui {
    public MainFrame mainFrame;

    public SwingGui() {

    }

    @Override
    public void start() {
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
}