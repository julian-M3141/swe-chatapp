package at.mucherl.statisticservice.restService;

import at.mucherl.statisticservice.dataAccess.RequestRepository;
import at.mucherl.statisticservice.models.Request;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log
public class StatisticService {

    @Autowired
    private RequestRepository repository;

    @StreamListener(Sink.INPUT)
    public void handleEvent(LocalDateTime timestamp){
        log.info("new Message with timestamp: "+timestamp);
        Request request = repository.save(new Request(timestamp.toLocalDate()));
        log.info(request.toString());
    }
}
