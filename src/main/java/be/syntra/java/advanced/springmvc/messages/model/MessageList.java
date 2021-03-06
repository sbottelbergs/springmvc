package be.syntra.java.advanced.springmvc.messages.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageList {
    private List<Message> messages;
}
