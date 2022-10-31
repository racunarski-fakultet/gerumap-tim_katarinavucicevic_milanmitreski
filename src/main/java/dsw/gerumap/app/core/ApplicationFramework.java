package dsw.gerumap.app.core;

public abstract class ApplicationFramework {

    // sve komponente koje koristimo cuvamo u okviru AppCore-a
    protected Gui gui;

    private MapRepository mapRepository;

    public abstract void run(); // pokretanje aplikacije

    // initialise je "konstruktor" za komponente koje ce cuvati AppCore
    public void initialise(Gui gui, MapRepository mapRepository) {
        this.mapRepository = mapRepository;
        this.gui = gui;
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }
}
