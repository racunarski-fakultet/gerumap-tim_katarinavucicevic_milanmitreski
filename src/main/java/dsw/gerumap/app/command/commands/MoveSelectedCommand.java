package dsw.gerumap.app.command.commands;

import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Term;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MoveSelectedCommand extends AbstractCommand {

    private final Map<Term, Point> startPoints;
    private final Map<Term, Point> endPoints;
    private final MindMap mindMap;

    public MoveSelectedCommand(MindMap mindMap, Map<Term, Point> startPoints) {
        this.mindMap = mindMap;
        this.startPoints = startPoints;
        this.endPoints = new HashMap<>();
        for(Term t : startPoints.keySet()) {
            endPoints.put(t, new Point((int) t.getXCoordinate(), (int) t.getYCoordinate()));
        }
    }
    @Override
    public void doCommand() {
        mindMap.moveSelected(endPoints);
    }

    @Override
    public void undoCommand() {
        mindMap.moveSelected(startPoints);
    }

}
