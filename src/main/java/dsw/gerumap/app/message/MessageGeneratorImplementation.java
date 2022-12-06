package dsw.gerumap.app.message;

import dsw.gerumap.app.core.MessageGenerator;
import dsw.gerumap.app.observer.ISubscriber;

import java.util.LinkedList;
import java.util.List;

public class MessageGeneratorImplementation implements MessageGenerator {

    private final List<ISubscriber> subscribers;

    public MessageGeneratorImplementation() {
        this.subscribers = new LinkedList<>();
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
        for(ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }

    @Override
    public void getMessage(String text, MessageType messageType) {
        notifySubscriber(new Message(text, messageType));
    }
}
