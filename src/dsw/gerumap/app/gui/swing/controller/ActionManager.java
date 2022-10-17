package dsw.gerumap.app.gui.swing.controller;

public class ActionManager {

    private static ActionManager instance = null;
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private ActionManager() {

    }

    private void initialise() {
        this.exitAction = new ExitAction();
        this.newProjectAction = new NewProjectAction();
    }

    public static ActionManager getInstance() {
        if(instance == null) {
            instance = new ActionManager();
        }
        return instance;
    }
}
