package dsw.gerumap.app.command.commands;

import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;

public class AddElementCommand extends AbstractCommand {

    private final MindMap mindMap;
    private final Element element;

    public AddElementCommand(MindMap mindMap, Element element){
        this.element = element;
        this.mindMap = mindMap;
    }
    @Override
    public void doCommand() {
        mindMap.addChild(element);
    }

    @Override
    public void undoCommand() {
        mindMap.removeChild(element);
    }
}
