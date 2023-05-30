package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.command.CommandManager;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

import java.awt.*;
import java.util.Map;

public class MindMap extends MapNodeComposite {
    private boolean template;
    private static final String templatePath = "/GeRuMapTemplates";
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
                child.setParent(this);
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

    public void moveSelected(Map<Term, Point> points){
        for(Term term : points.keySet()) {
            term.setXCoordinate(points.get(term).getX());
            term.setYCoordinate(points.get(term).getY());
        }
    }

    public void setTemplate(boolean template) { this.template = template; }

    public static String getTemplatePath() {
        return templatePath;
    }

    public CommandManager getCommandManager() {
        if(commandManager == null) commandManager = new CommandManager();
        return commandManager;
    }
}
