package dsw.gerumap.app.state;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectorModel extends Rectangle implements IPublisher {

    private Point startPoint;
    private Point currentPoint;
    private final List <ISubscriber> subscribers;

    public SelectorModel(Point startPoint) {
        this.startPoint = startPoint;
        this.subscribers = new ArrayList<>();
        notifySubscriber(this);
        currentPoint = new Point(0, 0);
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
            sub.update(notification);
        }

    }

}
