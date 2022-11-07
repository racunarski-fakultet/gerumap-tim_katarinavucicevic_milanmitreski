package dsw.gerumap.app.logger;

import dsw.gerumap.app.core.Logger;
import dsw.gerumap.app.message.Message;

public class FileLogger implements Logger {

    // Treba dodati logiku iza pisanja u fajl

    @Override
    public void update(Object notification) {
        if(notification instanceof Message)
            log((Message) notification);
    }

    @Override
    public void log(Message message) {

    }
}
