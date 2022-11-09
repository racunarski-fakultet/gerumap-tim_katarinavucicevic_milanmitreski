package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.controller.message.MessageType;
import dsw.gerumap.app.observer.IPublisher;

public interface MessageGenerator extends IPublisher {
    public void getMessage(String text, MessageType messageType);
}
