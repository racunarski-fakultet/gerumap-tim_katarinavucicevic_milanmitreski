package dsw.gerumap.app;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.SwingGui;

public class AppCore extends ApplicationFramework {

    // AppCore klasu konstruisemo preko Singleton Design Pattern - a
    private static AppCore instance = null;

    private AppCore() {

    }

    @Override
    public void run() {
        this.gui.start();
    }

    public static AppCore getInstance() {
        if(instance == null) {
            instance = new AppCore();
        }
        return instance;
    }

    public static void main(String[] args) {
        Gui gui = new SwingGui();
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui);
        appCore.run();
    }
}
