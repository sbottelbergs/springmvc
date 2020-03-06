package be.syntra.java.advanced.springmvc.messages;

import be.syntra.java.advanced.springmvc.messages.model.Message;
import be.syntra.java.advanced.springmvc.messages.model.MessageList;

public interface MessagesClient {
    Message getMessageById(int id);
    MessageList getMessages();
}
