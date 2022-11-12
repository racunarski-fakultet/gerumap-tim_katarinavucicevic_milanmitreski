package dsw.gerumap.app.logger;

import dsw.gerumap.app.core.Logger;
import dsw.gerumap.app.message.Message;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class FileLogger implements Logger {

    @Override
    public void update(Object notification) {
        if(notification instanceof Message)
            log((Message) notification);
    }

    @Override
    public void log(Message message) {
        try {
           PrintWriter pw = new PrintWriter(new FileOutputStream(Objects.requireNonNull(getClass().getResource("/log.txt")).getFile(), true));
           pw.println(message.toString());
           pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File log.txt not found.");
        }
    }

}
