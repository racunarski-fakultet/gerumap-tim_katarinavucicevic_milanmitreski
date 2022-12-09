package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;

public class StateManager {

    private State current;
    private AddState addState;
    private DeleteState deleteState;
    private SelectState selectState;
    private MoveState moveState;
    private RefactorState refactorState;
    private ConnectState connectState;

    private MoveMapState moveMapState;


    public StateManager() {

        addState = new AddState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        selectState = new SelectState();
        refactorState = new RefactorState();
        connectState = new ConnectState();
        moveMapState = new MoveMapState();
        current = addState;
    }

    public AddState getAddState() {
        return addState;
    }

    public void setAddState() {
        current = this.addState;
    }

    public DeleteState getDeleteState() {
        return deleteState;
    }

    public void setDeleteState() {
         current = this.deleteState;
    }

    public SelectState getSelectState() {
        return selectState;
    }

    public void setSelectState() {
        current = this.selectState;
    }

    public MoveState getMoveState() {
        return moveState;
    }

    public void setMoveState() {
        current = this.moveState;
    }

    public RefactorState getRefactorState() {
        return refactorState;
    }

    public void setRefactorState() {
        current = this.refactorState;
    }

    public ConnectState getConnectState() {
        return connectState;
    }

    public void setConnectState() {
        current = this.connectState;
    }

    public void setMoveMapState() { current = this.moveMapState; }

    public MoveMapState getMoveMapState() { return moveMapState; }

    public State getCurrent() {
        return current;
    }
}
