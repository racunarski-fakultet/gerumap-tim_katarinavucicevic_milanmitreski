package dsw.gerumap.app.state;

import dsw.gerumap.app.gui.swing.view.ElementView;
import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectorModel extends Rectangle implements IPublisher {

    private Point startPoint;
    private Point currentPoint;

    private List<ElementView> selectedElements;

    private List <ISubscriber> subscribers;

    public SelectorModel(Point startPoint) {
        this.startPoint = startPoint;
        this.selectedElements = new ArrayList<>();
        this.subscribers = new ArrayList<>();
        notifySubscriber(this);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setStartPoint(Point point) {
        this.startPoint = point;
    }

    public void setCurrentPoint(Point point) {
        this.currentPoint = point;
    }

    public void setDragPoint(int x, int y) {
        currentPoint = new Point(x, y);
    }



    @Override
    public void addSubscriber(ISubscriber sub) {
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        for(ISubscriber sub : subscribers){
            System.out.println("usao ");
            sub.update(notification);
        }

    }

    public List<ElementView> getSelectedElements() {
        return selectedElements;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }
}
