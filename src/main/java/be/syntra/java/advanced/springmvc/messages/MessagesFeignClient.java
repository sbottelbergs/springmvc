package be.syntra.java.advanced.springmvc.messages;

import be.syntra.java.advanced.springmvc.messages.model.Message;
import be.syntra.java.advanced.springmvc.messages.model.MessageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "messagesClient", url = "${baseUrl}/messages")
public interface MessagesFeignClient {
    @GetMapping("/{id}")
    Message getMessageById(@PathVariable("id") int id);

    @GetMapping
    MessageList getMessages();
}


