package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;

    private MainFrame() {

    }

    public void intialiseGUI() {

    }

    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

}
