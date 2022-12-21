package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.command.commands.AddElementCommand;
import dsw.gerumap.app.command.commands.DeleteElementCommand;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class MindMap extends MapNodeComposite {
    private final boolean template;

    private final String type = "MindMap";
    public MindMap(String name, MapNode parent) {
        super(name, parent);
        template = false;
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element){
            Element element = (Element) child;

            if(!this.getChildren().contains(element)) {
                this.getChildren().add(element);
                notifySubscriber(child);
                AbstractCommand command = new AddElementCommand(this, (Element)child);
                AppCore.getInstance().getGui().getCommandManager().addCommand(command);
            }

            ((Project)getParent()).setChanged(true);
        }

    }

    @Override
    public void removeChild(MapNode child) {
        if(child instanceof Element) {
            Element element = (Element) child;
            this.getChildren().remove(element);
            notifySubscriber(child);
            AbstractCommand command = new DeleteElementCommand(this, (Element)child);
            AppCore.getInstance().getGui().getCommandManager().addCommand(command);
        }

        ((Project)getParent()).setChanged(true);
    }

}
