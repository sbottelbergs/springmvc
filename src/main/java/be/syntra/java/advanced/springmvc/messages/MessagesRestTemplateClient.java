package be.syntra.java.advanced.springmvc.messages;

import be.syntra.java.advanced.springmvc.messages.model.Message;
import be.syntra.java.advanced.springmvc.messages.model.MessageList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Primary
public class MessagesRestTemplateClient implements MessagesClient {

    @Value("${baseUrl}")
    private String baseUrl;
    private RestTemplate template;

    public MessagesRestTemplateClient(RestTemplate template) {
        this.template = template;
    }

    @Override
    public Message getMessageById(int id) {
        ResponseEntity<Message> response = template.getForEntity(baseUrl + "/messages/{id}", Message.class, id);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public MessageList getMessages() {
        ResponseEntity<MessageList> response = template.getForEntity(baseUrl + "/messages", MessageList.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
