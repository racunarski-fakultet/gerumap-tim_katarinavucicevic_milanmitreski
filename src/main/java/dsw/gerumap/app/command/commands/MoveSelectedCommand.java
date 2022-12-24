package dsw.gerumap.app.command.commands;

import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Term;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class MoveSelectedCommand extends AbstractCommand {


    private Map<Term, Point> startPoints;
    private Map<Term, Point> currentPoints;
    private MindMap mindMap;

    public MoveSelectedCommand(MindMap mindMap, Map<Term, Point> startPoints) {
        this.mindMap = mindMap;
        this.startPoints = startPoints;
        this.currentPoints = startPoints;
    }
    @Override
    public void doCommand() {
        mindMap.moveSelected(currentPoints);
        // isto sto i u undo, to ce biti mapin moveMap
        // ili setCoordinates Termov
    }

    @Override
    public void undoCommand() {
        mindMap.moveSelected(startPoints);
    }

    public void setCurrentPoint(Map<Term, Point> currentPoints) {
        this.currentPoints = currentPoints;
    }
}
