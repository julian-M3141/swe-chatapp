package at.mucherl.chatservice.restService;

import at.mucherl.chatservice.dataAccess.MessageRepository;
import at.mucherl.chatservice.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/resource/message")
public class MessageResource {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    Source source;

    @GetMapping
    List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    @PostMapping
    void postNewMessage(@RequestBody String text){
        Message message = new Message(text);
        sendTimestamp(message.getTimestamp());
        messageRepository.save(message);
    }

    private void sendTimestamp(LocalDateTime timestamp){
        org.springframework.messaging.Message<LocalDateTime> message = MessageBuilder
                .withPayload(timestamp)
                .build();

        source.output().send(message);
    }

}
