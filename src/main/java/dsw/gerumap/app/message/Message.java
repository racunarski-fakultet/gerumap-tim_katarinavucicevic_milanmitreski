package dsw.gerumap.app.message;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        return "[" + messageType.toString() + "][" + localDate.getDayOfMonth()+"."+ localDate.getMonthValue()+"."+localDate.getYear()+". " + localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond() + "] " + text;
    }
}
