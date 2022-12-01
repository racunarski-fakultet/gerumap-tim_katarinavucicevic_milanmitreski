package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.state.StateMouseListener;
import dsw.gerumap.app.state.controller.*;

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private ChangeAuthorAction  changeAuthorAction;
    private InfoAction infoAction;
    private EditAction editAction;
    private DeleteNodeAction deleteNodeAction;
    private AddAction addAction;
    private MyMouseListener myMouseListener;
    private RenameAction renameAction;
    private AddStateAction addStateAction;
    private DeleteStateAction deleteStateAction;
    private MoveStateAction moveStateAction;
    private SelectStateAction selectStateAction;
    private ZoomStateAction zoomStateAction;
    private RefactorStateAction refactorStateAction;
    private StateMouseListener stateMouseListener;

    private ConnectStateAction connectStateAction;
    private SettingsAction settingsAction;

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
        changeAuthorAction = new ChangeAuthorAction();
        myMouseListener = new MyMouseListener();
        renameAction = new RenameAction();
        addStateAction = new AddStateAction();
        deleteStateAction = new DeleteStateAction();
        moveStateAction = new MoveStateAction();
        selectStateAction = new SelectStateAction();
        zoomStateAction = new ZoomStateAction();
        refactorStateAction = new RefactorStateAction();
        stateMouseListener = new StateMouseListener();
        connectStateAction = new ConnectStateAction();
        settingsAction = new SettingsAction();
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
    

    public DeleteNodeAction getDeleteNodeAction() {
        return deleteNodeAction;
    }

    public AddAction getAddAction() {
        return addAction;
    }

    public ChangeAuthorAction getChangeAuthorAction() { return changeAuthorAction; }

    public MyMouseListener getMyMouseListener() {
        return myMouseListener;
    }

    public RenameAction getRenameAction() {
        return renameAction;
    }

    public AddStateAction getAddStateAction() {
        return addStateAction;
    }

    public DeleteStateAction getDeleteStateAction() {
        return deleteStateAction;
    }

    public MoveStateAction getMoveStateAction() {
        return moveStateAction;
    }

    public SelectStateAction getSelectStateAction() {
        return selectStateAction;
    }

    public ZoomStateAction getZoomStateAction() {
        return zoomStateAction;
    }

    public RefactorStateAction getRefactorStateAction() {
        return refactorStateAction;
    }

    public StateMouseListener getStateMouseListener() {
        return stateMouseListener;
    }

    public ConnectStateAction getConnectStateAction() {
        return connectStateAction;
    }

    public SettingsAction getSettingsAction() {
        return settingsAction;
    }
}
