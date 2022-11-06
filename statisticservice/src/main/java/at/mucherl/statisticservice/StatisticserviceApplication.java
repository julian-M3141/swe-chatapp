package at.mucherl.statisticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class StatisticserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticserviceApplication.class, args);
    }

}
