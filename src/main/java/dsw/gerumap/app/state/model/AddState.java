package dsw.gerumap.app.state.model;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.command.commands.AddElementCommand;
import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.message.MessageType;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;

public class AddState implements State {

    private static int count = -1;
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() != MouseEvent.BUTTON1) return;
        MapView source = (MapView) e.getSource();
        MindMap m = source.getMindMap();
        if(count == -1) count = source.getElementViews().size();
        Term t = new Term(
                "Element" + (++count), m, source.getStroke(), source.getColor(),
                (e.getPoint().getX()-source.getxTranslate())/source.getScalingFactor(),
                (e.getPoint().getY()-source.getyTranslate())/source.getScalingFactor()
        );
        t.addSubscriber(source);
        AddElementCommand addElementCommand = new AddElementCommand(m, t);
        m.getCommandManager().addCommand(addElementCommand);

        ElementView tv = null;
        for(ElementView ev : source.getElementViews()) {
            if(ev.getElement().equals(t)) tv = ev;
        }
        boolean found = false;
        ElementView eview = null;
        for(ElementView ev : source.getElementViews()) {
            if(!ev.equals(tv) && ev.getShape().intersects(tv.getShape().getBounds())) {
                found = true;
                eview = ev;
                break;
            }
        }
        if(found) {
            m.removeChild(t);
            AppCore.getInstance().getMessageGenerator().getMessage("FOUND ELEMENT " + eview.getElement().getName() + " AT (" + e.getX() + ", " + e.getY() + ")", MessageType.ELEMENT_FOUND_AT_POINT);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
