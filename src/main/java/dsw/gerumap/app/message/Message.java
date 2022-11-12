package dsw.gerumap.app.message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private final String text;
    private final MessageType messageType;
    private final LocalDateTime localDateTime;

    public Message(String text, MessageType messageType) {
        this.text = text;
        this.messageType = messageType;
        this.localDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return "[" + messageType.toString() + "][" + localDateTime.format(dateTimeFormatter) + "] " + text;
    }
}
