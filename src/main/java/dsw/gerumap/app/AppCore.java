package dsw.gerumap.app;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.core.Logger;
import dsw.gerumap.app.core.MessageGenerator;
import dsw.gerumap.app.logger.ConsoleLogger;
import dsw.gerumap.app.mapRepository.MapRepository;
import dsw.gerumap.app.gui.swing.SwingGui;
import dsw.gerumap.app.mapRepository.MapRepositoryImplementation;
import dsw.gerumap.app.message.MessageGeneratorImplementation;

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
        Logger logger = new ConsoleLogger();
        MapRepository mapRepository = new MapRepositoryImplementation();
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui, mapRepository, messageGenerator, logger);
        appCore.run();
    }

}
