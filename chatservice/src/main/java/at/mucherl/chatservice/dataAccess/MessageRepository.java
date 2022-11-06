package at.mucherl.chatservice.dataAccess;

import at.mucherl.chatservice.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {

}
