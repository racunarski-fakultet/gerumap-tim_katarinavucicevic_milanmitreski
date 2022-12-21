package dsw.gerumap.app.command.commands;

import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;

public class DeleteElementCommand extends AbstractCommand {

    private MindMap mindMap;
    private Element element;

    public DeleteElementCommand(MindMap parent, Element child) {
        this.element = child;
        this.mindMap = parent;
    }

    @Override
    public void doCommand() {
        //mindMap.removeChild(element);
    }

    @Override
    public void undoCommand() {
        //mindMap.addChild(element);
    }
}
