package dsw.gerumap.app.message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private String text;
    private MessageType messageType;
    private LocalDateTime localDateTime;

    public Message(String text, MessageType messageType) {
        this.text = text;
        this.messageType = messageType;
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return "[" + messageType.toString() + "][" + localDateTime.format(dateTimeFormatter) + "] " + text;
    }
}
