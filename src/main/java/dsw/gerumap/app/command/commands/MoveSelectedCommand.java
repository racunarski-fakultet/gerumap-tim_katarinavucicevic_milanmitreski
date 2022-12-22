package dsw.gerumap.app.command.commands;

import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Term;

import java.awt.*;

public class MoveSelectedCommand extends AbstractCommand {

    private Point point;
    private Term term;
    private MindMap mindMap;

    public MoveSelectedCommand(MindMap mindMap, Term term, Point p) {
        this.mindMap = mindMap;
        this.term = term;
        this.point = p;
    }
    @Override
    public void doCommand() {
        mindMap.moveSelected(term, point);
        // isto sto i u undo, to ce biti mapin moveMap
        // ili setCoordinates Termov
    }

    @Override
    public void undoCommand() {
        mindMap.moveSelected(term, point);
    }
}
