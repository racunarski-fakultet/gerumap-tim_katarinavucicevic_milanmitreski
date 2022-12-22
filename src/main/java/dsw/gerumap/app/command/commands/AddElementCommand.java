package dsw.gerumap.app.command.commands;

import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;

public class AddElementCommand extends AbstractCommand {

    private MindMap mindMap;
    private Element element;

    public AddElementCommand(MindMap mindMap, Element element){
        this.element = element;
        this.mindMap = mindMap;
    }
    @Override
    public void doCommand() {
        // pozivaju se metode primaoca
        mindMap.addChild(element);
    }

    @Override
    public void undoCommand() {
        mindMap.removeChild(element);
        // Nas observer radi obrnuto :)
    }
}
