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
    private RefactorStateAction refactorStateAction;
    private StateMouseListener stateMouseListener;
    private ConnectStateAction connectStateAction;
    private SettingsAction settingsAction;
    private ZoomInAction zoomInAction;
    private ZoomOutAction zoomOutAction;
    private MoveMapStateAction moveMapAction;
    private UndoAction undoAction;
    private RedoAction redoAction;

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
        refactorStateAction = new RefactorStateAction();
        stateMouseListener = new StateMouseListener();
        connectStateAction = new ConnectStateAction();
        settingsAction = new SettingsAction();
        zoomInAction = new ZoomInAction();
        zoomOutAction = new ZoomOutAction();
        moveMapAction = new MoveMapStateAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
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

    public ZoomInAction getZoomInAction() {
        return zoomInAction;
    }

    public ZoomOutAction getZoomOutAction() {
        return zoomOutAction;
    }

    public MoveMapStateAction getMoveMapAction() { return moveMapAction; }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }
}
