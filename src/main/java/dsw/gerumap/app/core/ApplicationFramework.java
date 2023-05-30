package dsw.gerumap.app.core;

import dsw.gerumap.app.mapRepository.MapRepository;

public abstract class ApplicationFramework {

    // sve komponente koje koristimo cuvamo u okviru AppCore-a
    protected Gui gui;

    private MapRepository mapRepository;

    private MessageGenerator messageGenerator;
    private Serializer serializer;

    public abstract void run(); // pokretanje aplikacije

    // initialise je "konstruktor" za komponente koje ce cuvati AppCore
    public void initialise(Gui gui, MapRepository mapRepository, MessageGenerator messageGenerator, Serializer serializer, Logger logger) {
        this.mapRepository = mapRepository;
        this.gui = gui;
        this.messageGenerator = messageGenerator;
        this.serializer = serializer;
        messageGenerator.addSubscriber(logger);
        messageGenerator.addSubscriber(gui);
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }

    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }

    public Serializer getSerializer() { return serializer; }

    public Gui getGui() {
        return gui;
    }
}
