package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;

public class StateManager {

    private State current;
    private final AddState addState;
    private final DeleteState deleteState;
    private final SelectState selectState;
    private final MoveState moveState;
    private final RefactorState refactorState;
    private final ConnectState connectState;
    private final MoveMapState moveMapState;
    private final SetCentralTermState setCentralTermState;


    public StateManager() {
        addState = new AddState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        selectState = new SelectState();
        refactorState = new RefactorState();
        connectState = new ConnectState();
        moveMapState = new MoveMapState();
        setCentralTermState = new SetCentralTermState();
        current = addState;
    }

    public void setAddState() {
        current = this.addState;
    }

    public void setDeleteState() {
         current = this.deleteState;
    }

    public void setSelectState() {
        current = this.selectState;
    }

    public void setMoveState() {
        current = this.moveState;
    }

    public void setRefactorState() {
        current = this.refactorState;
    }

    public void setConnectState() {
        current = this.connectState;
    }

    public void setMoveMapState() { current = this.moveMapState; }

    public void setSetCentralTermState() {
        current = this.setCentralTermState;
    }

    public State getCurrent() {
        return current;
    }
}
