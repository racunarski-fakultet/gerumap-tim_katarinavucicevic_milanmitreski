package dsw.gerumap.app.gui.swing.controller;

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private InfoAction infoAction;

    private EditAction editAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        infoAction = new InfoAction();
        editAction = new EditAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }
}
