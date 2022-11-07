package dsw.gerumap.app.core;

import dsw.gerumap.app.message.Message;
import dsw.gerumap.app.observer.ISubscriber;

public interface Logger extends ISubscriber {
    public void log(Message message);
}
