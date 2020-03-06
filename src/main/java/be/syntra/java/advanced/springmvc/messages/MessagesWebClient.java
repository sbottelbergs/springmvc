package be.syntra.java.advanced.springmvc.messages;

import be.syntra.java.advanced.springmvc.messages.model.Message;
import be.syntra.java.advanced.springmvc.messages.model.MessageList;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component("messagesWebClient")
public class MessagesWebClient implements MessagesClient {

    private WebClient webClient;

    public MessagesWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Message getMessageById(int id) {
        return webClient.get()
                .uri("/messages/" + id)
                .retrieve()
                .bodyToMono(Message.class)
                .block();
    }

    @Override
    public MessageList getMessages() {
        return webClient.get()
                .uri("/messages")
                .retrieve()
                .bodyToMono(MessageList.class)
                .block();
    }
}
