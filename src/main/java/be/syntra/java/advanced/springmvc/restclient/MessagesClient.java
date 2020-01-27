package be.syntra.java.advanced.springmvc.restclient;

import be.syntra.java.advanced.springmvc.restclient.model.Message;
import be.syntra.java.advanced.springmvc.restclient.model.MessageList;

public interface MessagesClient {
    Message getMessageById(int id);
    MessageList getMessages();
}
