package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.command.CommandManager;
import dsw.gerumap.app.command.commands.AddElementCommand;
import dsw.gerumap.app.command.commands.DeleteElementCommand;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

import java.awt.*;

public class MindMap extends MapNodeComposite {
    private boolean template;
    private static final String templatePath = System.getProperty("user.home") + System.getProperty("file.separator")+"GeRuMapTemplates";
    private final String type = "MindMap";

    private transient CommandManager commandManager;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
        template = false;
        commandManager = new CommandManager();
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element){
            Element element = (Element) child;

            if(!this.getChildren().contains(element)) {
                this.getChildren().add(element);
                notifySubscriber(child);
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
        }

        ((Project)getParent()).setChanged(true);
    }

    public void moveSelected(Term t, Point p){
        t.setXCoordinate(p.getX());
        t.setYCoordinate(p.getY());
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }

    public static String getTemplatePath() {
        return templatePath;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}
