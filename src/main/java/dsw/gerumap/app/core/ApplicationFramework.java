package dsw.gerumap.app.core;

public abstract class ApplicationFramework {

    // sve komponente koje koristimo cuvamo u okviru AppCore-a
    protected Gui gui;

    public abstract void run(); // pokretanje aplikacije

    // initialise je "konstruktor" za komponente koje ce cuvati AppCore
    public void initialise(Gui gui) {
        this.gui = gui;
    }
}
