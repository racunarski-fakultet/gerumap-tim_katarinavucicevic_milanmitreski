package dsw.gerumap.app.core;

import dsw.gerumap.app.mapRepository.MapRepository;

public abstract class ApplicationFramework {

    // sve komponente koje koristimo cuvamo u okviru AppCore-a
    protected Gui gui;

    private MapRepository mapRepository;

    private MessageGenerator messageGenerator;
    private Logger logger;

    public abstract void run(); // pokretanje aplikacije

    // initialise je "konstruktor" za komponente koje ce cuvati AppCore
    public void initialise(Gui gui, MapRepository mapRepository, MessageGenerator messageGenerator, Logger logger) {
        this.mapRepository = mapRepository;
        this.gui = gui;
        this.messageGenerator = messageGenerator;
        this.logger = logger;
        messageGenerator.addSubcriber(logger);
        messageGenerator.addSubcriber(gui);
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }

    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }
}
