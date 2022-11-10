package dsw.gerumap.app.logger;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.core.Logger;
import dsw.gerumap.app.message.Message;
import dsw.gerumap.app.message.MessageType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileLogger implements Logger {

    @Override
    public void update(Object notification) {
        if(notification instanceof Message)
            log((Message) notification);
    }

    @Override
    public void log(Message message) {
        try {
           PrintWriter pw = new PrintWriter(new FileOutputStream("log.txt", true));
           pw.println(message.toString());
           pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File log.txt not found.");
        }
    }

}
