package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;

public class StateManager {

    private State current;
    private AddState addState;
    private DeleteState deleteState;
    private SelectState selectState;
    private MoveState moveState;
    private ZoomState zoomState;
    private RefactorState refactorState;
    private ConnectState connectState;


    public StateManager() {

        addState = new AddState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        zoomState = new ZoomState();
        selectState = new SelectState();
        refactorState = new RefactorState();
        connectState = new ConnectState();
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

    public ZoomState getZoomState() {
        return zoomState;
    }

    public void setZoomState() {
         current = this.zoomState;
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

    public State getCurrent() {
        return current;
    }
}
