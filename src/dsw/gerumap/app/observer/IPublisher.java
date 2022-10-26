package dsw.gerumap.app.observer;

public interface IPublisher {

    void addSubcriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscriber(Object notification);
}
