package dsw.gerumap.app.command.commands;

import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.mapRepository.implementation.Term;

import java.util.ArrayList;
import java.util.List;

public class DeleteElementCommand extends AbstractCommand {

    private final MindMap mindMap;
    private final Element element;
    private final List<Relation> relationList;
    public DeleteElementCommand(MindMap parent, Element child) {
        this.element = child;
        this.mindMap = parent;
        this.relationList = new ArrayList<>();
        if(child instanceof Term) {
            for (MapNode e : parent.getChildren()) {
                Element elem = (Element) e;
                if (elem instanceof Relation && (((Relation) elem).getTermFrom().equals(child) || ((Relation) elem).getTermTo().equals(child))) {
                    Relation r = (Relation) elem;
                    relationList.add(r);
                }
            }
        }
    }

    @Override
    public void doCommand() {
        if(element instanceof Term) {
            for(Relation r : relationList) {
                mindMap.removeChild(r);
            }
        }
        mindMap.removeChild(element);
    }

    @Override
    public void undoCommand() {
        if(element instanceof Term) {
            for(Relation r : relationList) {
                mindMap.addChild(r);
            }
        }
        mindMap.addChild(element);
    }
}
