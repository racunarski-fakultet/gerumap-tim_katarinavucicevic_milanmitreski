package dsw.gerumap.app.logger;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.core.Logger;
import dsw.gerumap.app.message.Message;
import dsw.gerumap.app.message.MessageType;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Objects;

@SuppressWarnings("unused")
public class FileLogger implements Logger {

    @Override
    public void update(Object notification) {
        if(notification instanceof Message)
            log((Message) notification);
    }

    @Override
    public void log(Message message) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(Objects.requireNonNull(getClass().getResource("/log.txt")).getFile(), true))) {
           pw.println(message.toString());
        } catch (FileNotFoundException e) {
            AppCore.getInstance().getMessageGenerator().getMessage("log.txt not found", MessageType.LOG_FILE_NOT_FOUND);
        }
    }

}
