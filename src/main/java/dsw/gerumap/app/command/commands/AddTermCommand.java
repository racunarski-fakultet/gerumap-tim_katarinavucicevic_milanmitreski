package dsw.gerumap.app.command.commands;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.command.AbstractCommand;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.TermView;
import dsw.gerumap.app.mapRepository.implementation.Term;

public class AddTermCommand extends AbstractCommand {

    private Term term;
    private MapView mapView;

    public AddTermCommand(Term term, MapView mapView){
        this.term = term;
        this.mapView = mapView;

    }
    @Override
    public void doCommand() {
        TermView tv = new TermView(term);
        mapView.getElementViews().add(tv);
    }

    @Override
    public void undoCommand() {
        mapView.remove(AppCore.getInstance().getGui().getCommandManager().getPointer());

    }
}
