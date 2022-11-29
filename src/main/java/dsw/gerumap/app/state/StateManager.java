package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;

public class StateManager {

    private State current;
    private AddState addState;
    private DeleteState deleteState;
    private SelectState selectState;
    private MoveState moveState;
    private ZoomState zoomState;


    public StateManager() {

        addState = new AddState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        zoomState = new ZoomState();
        selectState = new SelectState();

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

    public State getCurrent() {
        return current;
    }
}
