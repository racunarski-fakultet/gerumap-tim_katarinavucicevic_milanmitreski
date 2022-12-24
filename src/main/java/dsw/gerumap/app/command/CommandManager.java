package dsw.gerumap.app.command;

import dsw.gerumap.app.AppCore;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final List<AbstractCommand> commands = new ArrayList<>();

    private int pointer = 0;

    public void addCommand(AbstractCommand command){
        while(pointer < commands.size()){
            commands.remove(pointer);
        }
        commands.add(command);
        doCommand();

    }

    public void doCommand(){
        if(pointer < commands.size()){
            commands.get(pointer++).doCommand();
            AppCore.getInstance().getGui().enableUndo();
        }
        if(pointer == commands.size()){
            AppCore.getInstance().getGui().disableRedo();

        }
    }

    public void undoCommand(){
        if(pointer > 0){
            AppCore.getInstance().getGui().enableRedo();
            commands.get(--pointer).undoCommand();
        }
        if(pointer == 0){
            AppCore.getInstance().getGui().disableUndo();
        }
    }
}
