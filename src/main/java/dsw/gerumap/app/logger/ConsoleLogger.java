package dsw.gerumap.app.logger;

import dsw.gerumap.app.core.Logger;
import dsw.gerumap.app.message.Message;

@SuppressWarnings("unused")
public class ConsoleLogger implements Logger {

    @Override
    public void update(Object notification) {
        if(notification instanceof Message)
            log((Message) notification);
    }

    @Override
    public void log(Message message) {
        System.out.println(message);
    }
}
