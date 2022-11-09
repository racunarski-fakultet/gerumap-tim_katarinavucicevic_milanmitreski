package dsw.gerumap.app.gui.swing.controller;

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private ChangeAuthorAction  changeAuthorAction;
    private InfoAction infoAction;

    private EditAction editAction;

    private DeleteNodeAction deleteNodeAction;

    private AddAction addAction;

    private AddTabAction addTabAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        infoAction = new InfoAction();
        editAction = new EditAction();
        deleteNodeAction = new DeleteNodeAction();
        addAction = new AddAction();
        addTabAction = new AddTabAction();
        changeAuthorAction = new ChangeAuthorAction();
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

    public DeleteNodeAction getDeleteNodeAction() {
        return deleteNodeAction;
    }

    public AddAction getAddAction() {
        return addAction;
    }

    public AddTabAction getAddTabAction() {
        return addTabAction;
    }

    public ChangeAuthorAction getChangeAuthorAction() { return changeAuthorAction; }

}
