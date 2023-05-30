package dsw.gerumap.app;

import dsw.gerumap.app.core.*;
import dsw.gerumap.app.logger.FileLogger;
import dsw.gerumap.app.mapRepository.MapRepository;
import dsw.gerumap.app.gui.swing.SwingGui;
import dsw.gerumap.app.mapRepository.MapRepositoryImplementation;
import dsw.gerumap.app.message.MessageGeneratorImplementation;
import dsw.gerumap.app.serializer.GsonSerializer;

public class AppCore extends ApplicationFramework {

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
        Logger logger = new FileLogger();
        MapRepository mapRepository = new MapRepositoryImplementation();
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        Serializer serializer = new GsonSerializer();
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui, mapRepository, messageGenerator, serializer, logger);
        appCore.run();
    }

}
