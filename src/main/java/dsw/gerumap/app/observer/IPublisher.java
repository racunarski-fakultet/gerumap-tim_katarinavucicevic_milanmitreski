package dsw.gerumap.app.observer;

public interface IPublisher {

    void addSubscriber(ISubscriber sub);
    @SuppressWarnings("unused")
    void removeSubscriber(ISubscriber sub);
    void notifySubscriber(Object notification);
}
