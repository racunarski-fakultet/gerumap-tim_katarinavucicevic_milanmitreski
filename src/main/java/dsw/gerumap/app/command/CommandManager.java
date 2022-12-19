package dsw.gerumap.app.command;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.SwingGui;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<AbstractCommand> commands = new ArrayList<>();

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
            // logika za impl
        }
        if(pointer == commands.size()){
            AppCore.getInstance().getGui().disableRedo();

        }
    }

    public void undoCommand(){
        if(pointer > 0){
            AppCore.getInstance().getGui().enableRedo();
            commands.get(pointer--).undoCommand();
            // logika za impl
        }
        if(pointer == 0){
            AppCore.getInstance().getGui().disableUndo();
        }
    }

}
